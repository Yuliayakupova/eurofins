package com.example.eurofinsgenomics;

import com.example.eurofinsgenomics.dto.GeoIpDTO;
import com.example.eurofinsgenomics.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CountryServiceUTest {
    @Autowired
    private CountryService countryService;

    @Test
    public void testGetCountryByIPAddress() throws IOException, URISyntaxException, InterruptedException {
        GeoIpDTO result = countryService.getCountryByIPAddress("8.8.8.8");
        assertNotNull(result);
        assertEquals("US", result.getCountry());
    }
}
