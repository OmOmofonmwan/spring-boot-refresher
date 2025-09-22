package com.acompletenoobsmoke;

import org.springframework.data.crossstore.ChangeSetPersister;
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
        if (!softwareEngineerRepository.existsById(id))
            throw new IllegalStateException("SoftwareEngineer with id " + id + " not found");
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer newSoftwareEngineer) {
        SoftwareEngineer updated = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("SoftwareEngineer with id "
                + id + " does not exist"));
        updated.setFirstName(newSoftwareEngineer.getFirstName());
        updated.setLastName(newSoftwareEngineer.getLastName());
        updated.setTechStack(newSoftwareEngineer.getTechStack());
        softwareEngineerRepository.save(updated);
    }
}
