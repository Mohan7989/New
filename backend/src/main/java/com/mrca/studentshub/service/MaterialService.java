package com.mrca.studentshub.service;

import com.mrca.studentshub.model.Material;
import com.mrca.studentshub.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public List<Material> getApprovedMaterials() {
        return materialRepository.findByApprovedTrue();
    }

    public List<Material> getPendingMaterials() {
        return materialRepository.findByApprovedFalse();
    }

    public Material approveMaterial(Long id) {
        Material material = materialRepository.findById(id).orElseThrow();
        material.setApproved(true);
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}