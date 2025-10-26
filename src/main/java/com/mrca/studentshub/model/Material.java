package com.mrca.studentshub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subject;

    @Column(name = "group_name") // ✅ Avoids SQL keyword conflict
    private String groupName;

    private String year;
    private String semester;
    private String fileType; // PDF or Image
    private String filePath; // Stored file path
    private boolean approved; // Admin approval status
}