package com.mrca.studentshub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final String ADMIN_PASSWORD = "mrca@admin123"; // You can change this

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String password) {
        if (ADMIN_PASSWORD.equals(password)) {
            return ResponseEntity.ok("ACCESS_GRANTED");
        } else {
            return ResponseEntity.status(403).body("ACCESS_DENIED");
        }
    }
}