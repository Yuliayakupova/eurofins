package com.example.eurofinsgenomics.controllers;


import com.example.eurofinsgenomics.dto.GeoIpDTO;
import com.example.eurofinsgenomics.repository.AuditRepository;
import com.example.eurofinsgenomics.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * User can enter an IP address and
 * the service should return details about the country it is assigned to
 */

@RestController
public class CountryController {

    @Autowired
    private final CountryService countryService;
    @Autowired
    private final AuditRepository auditRepository;

    public CountryController(CountryService countryService, AuditRepository auditRepository) {
        this.countryService = countryService;
        this.auditRepository = auditRepository;
    }

    @GetMapping("/ip/{ipAddress}")
    public GeoIpDTO getCountryInfo(@PathVariable String ipAddress) throws IOException, URISyntaxException, InterruptedException {

        /**
         * Retrieving country details by IP address
         * Write audit record into the database
         */

        final GeoIpDTO geo = this.countryService.getCountryByIPAddress(ipAddress);
        auditRepository.insertGeoIPData(geo);

        return geo;
    }
}
