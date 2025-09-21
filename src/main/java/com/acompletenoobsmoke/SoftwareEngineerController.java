package com.acompletenoobsmoke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    @GetMapping
    public List<SoftwareEngineer>  getEngineers() {
        return engineerList();
    }

    private List<SoftwareEngineer> engineerList() {
        return List.of(new SoftwareEngineer(1, "Osaretin", "Omofonmwan", "Java"),
                       new SoftwareEngineer(2, "Victoria", "Marshall", "Javascript"),
                       new SoftwareEngineer(3, "Adedayo", "Uwensuyi", "Python"),
                       new SoftwareEngineer(4, "Ajinboye", "Uwensuyi", "ServiceNow/Javascript"),
                       new SoftwareEngineer(5, "Dustin", "Carpenter", "C++")
        );
    }
}
