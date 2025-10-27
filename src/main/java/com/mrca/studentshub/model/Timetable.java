package com.mrca.studentshub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String dateDay;
    private String baSubjects;
    private String bscSubjects;
    private String bcomSubjects;
    private String bbaSubjects;
    private String time;
    private boolean active;
}