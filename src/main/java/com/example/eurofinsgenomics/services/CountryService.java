package com.example.eurofinsgenomics.services;

import com.example.eurofinsgenomics.dto.GeoIpDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CountryService {

    private static final String GEO_API_URL = "https://ipinfo.io/%s/geo";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public CountryService() {
        httpClient = HttpClient.newHttpClient();

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public GeoIpDTO getCountryByIPAddress(String ipAddress) throws IOException, URISyntaxException, InterruptedException {
        final URI uri = new URI(String.format(GEO_API_URL, ipAddress));

        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to get IP info for IP address: " + ipAddress);
        }

        final String json = response.body();

        return objectMapper.readValue(json, GeoIpDTO.class);
    }
}
