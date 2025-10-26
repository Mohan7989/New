package com.mrca.studentshub.repository;

import com.mrca.studentshub.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByApprovedTrue();
    List<Material> findByApprovedFalse();
}