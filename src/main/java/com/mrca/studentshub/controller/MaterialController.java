package com.mrca.studentshub.controller;

import com.mrca.studentshub.model.Material;
import com.mrca.studentshub.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/materials")
@CrossOrigin(origins = "*")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    // Folder where files will be saved
    private final String uploadDir = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<Material> uploadMaterial(
            @RequestParam String title,
            @RequestParam String subject,
            @RequestParam String groupName,
            @RequestParam String year,
            @RequestParam String semester,
            @RequestParam MultipartFile file
    ) throws IOException {
        // Generate unique filename
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Create uploads folder if it doesn't exist
        File dest = new File(uploadDir + fileName);
        dest.getParentFile().mkdirs();

        // Save file to disk
        file.transferTo(dest);

        // Build Material object
        Material material = Material.builder()
                .title(title)
                .subject(subject)
                .groupName(groupName)
                .year(year)
                .semester(semester)
                .fileType(file.getContentType())
                .filePath("/uploads/" + fileName) // ✅ Public path for frontend access
                .approved(false)
                .build();

        // Save to database
        return ResponseEntity.ok(materialService.save(material));
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Material>> getApprovedMaterials() {
        return ResponseEntity.ok(materialService.getApprovedMaterials());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Material>> getPendingMaterials() {
        return ResponseEntity.ok(materialService.getPendingMaterials());
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<Material> approveMaterial(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.approveMaterial(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.ok().build();
    }
}