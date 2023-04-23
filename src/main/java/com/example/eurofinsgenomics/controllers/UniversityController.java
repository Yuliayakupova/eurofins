package com.example.eurofinsgenomics.controllers;


import com.example.eurofinsgenomics.dto.UniversityDTO;
import com.example.eurofinsgenomics.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/** User can enter the name of the country and
 * the service should return a list of universities
 */
@RestController
public class UniversityController {

    @Autowired
    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/university")
    public List<UniversityDTO> getUniversityInfo(@RequestParam String country) throws URISyntaxException, IOException, InterruptedException {
        return universityService.getUniversitiesByCountry(country);
    }
}
