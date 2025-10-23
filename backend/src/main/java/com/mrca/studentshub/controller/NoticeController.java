package com.mrca.studentshub.controller;

import com.mrca.studentshub.model.Notice;
import com.mrca.studentshub.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    @PostMapping("/add")
    public ResponseEntity<Notice> addNotice(@RequestBody Notice notice) {
        return ResponseEntity.ok(noticeRepository.save(notice));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notice>> getAllNotices() {
        return ResponseEntity.ok(noticeRepository.findAll());
    }
}