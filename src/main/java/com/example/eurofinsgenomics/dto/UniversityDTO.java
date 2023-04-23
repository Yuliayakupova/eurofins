package com.example.eurofinsgenomics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UniversityDTO {
    @JsonProperty("state-province")
    private String stateProvince;

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;

    @JsonProperty("web_pages")
    private List<String> webPages;

    @JsonProperty("domains")
    private List<String> domains;

    @JsonProperty("alpha_two_code")
    private String countryCode;

    public String getStateProvince() {
        return stateProvince;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public List<String> getDomains() {
        return domains;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
