package com.example.eurofinsgenomics;

import com.example.eurofinsgenomics.dto.UniversityDTO;
import com.example.eurofinsgenomics.services.UniversityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UniversityServiceUTest {

    @Test
    void testGetUniversitiesByCountry() throws URISyntaxException, IOException, InterruptedException {

        UniversityService service = new UniversityService();

        List<UniversityDTO> universities = service.getUniversitiesByCountry("Latvia");

        assertNotNull(universities);
        assertFalse(universities.isEmpty());

        for (UniversityDTO university : universities) {
            assertNotNull(university.getName());
            assertNotNull(university.getCountry());
            assertNotNull(university.getWebPages());
            assertFalse(university.getWebPages().isEmpty());
        }
    }
}
