package com.mrca.studentshub.service;

import com.mrca.studentshub.model.Timetable;
import com.mrca.studentshub.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    public Timetable save(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    public List<Timetable> getActiveTimetables() {
        return timetableRepository.findByActiveTrue();
    }

    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }
}