package com.acompletenoobsmoke;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void addSoftwareEngineer(SoftwareEngineer newSoftwareEngineer) {
        softwareEngineerRepository.save(newSoftwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineer(Integer id) {
        return softwareEngineerRepository.findById(id).orElse(null);
    }

    public void deleteSoftwareEngineer(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }
}
