package com.mrca.studentshub.controller;

import com.mrca.studentshub.model.Timetable;
import com.mrca.studentshub.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/timetables")
@CrossOrigin(origins = "*")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @PostMapping("/add")
    public ResponseEntity<Timetable> addTimetable(@RequestBody Timetable timetable) {
        return ResponseEntity.ok(timetableService.save(timetable));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Timetable>> getActiveTimetables() {
        return ResponseEntity.ok(timetableService.getActiveTimetables());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Timetable>> getAllTimetables() {
        return ResponseEntity.ok(timetableService.getAllTimetables());
    }
}