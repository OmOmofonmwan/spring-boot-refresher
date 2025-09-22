package com.acompletenoobsmoke;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer>  getEngineers() {
        return softwareEngineerService.getSoftwareEngineers();
    }

    @PostMapping
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer newSoftwareEngineer) {
        softwareEngineerService.addSoftwareEngineer(newSoftwareEngineer);
    }

    @GetMapping(path = "{id}")
    public SoftwareEngineer  getSoftwareEngineer(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineer(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping(path = "{id}")
    public String updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer newSoftwareEngineer) {
        try {
            softwareEngineerService.updateSoftwareEngineer(id, newSoftwareEngineer);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Update Completed";

    }

}
