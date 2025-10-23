package com.mrca.studentshub.controller;

import com.mrca.studentshub.model.Internship;
import com.mrca.studentshub.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {

    @Autowired
    private InternshipRepository internshipRepository;

    @PostMapping("/add")
    public ResponseEntity<Internship> addInternship(@RequestBody Internship internship) {
        return ResponseEntity.ok(internshipRepository.save(internship));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Internship>> getAllInternships() {
        return ResponseEntity.ok(internshipRepository.findAll());
    }
}
