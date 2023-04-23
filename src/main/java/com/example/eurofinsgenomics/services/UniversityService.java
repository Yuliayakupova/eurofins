package com.example.eurofinsgenomics.services;

import com.example.eurofinsgenomics.dto.UniversityDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class UniversityService {

    private static final String SEARCH_UNIVERSITIES_API_URL = "http://universities.hipolabs.com/search?country=%s";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public UniversityService() {
        httpClient = HttpClient.newHttpClient();

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public List<UniversityDTO> getUniversitiesByCountry(final String country) throws URISyntaxException, IOException, InterruptedException {
        final URI uri = new URI(String.format(SEARCH_UNIVERSITIES_API_URL, country));

        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to get universities by country " + country);
        }

        final String json = response.body();

        return objectMapper.readValue(json, new TypeReference<List<UniversityDTO>>(){});

    }
}
