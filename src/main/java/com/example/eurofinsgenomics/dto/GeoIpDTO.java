package com.example.eurofinsgenomics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoIpDTO {

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("city")
    private String city;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("loc")
    private String loc;

    @JsonProperty("org")
    private String org;

    @JsonProperty("timezone")
    private String timezone;

    public String getIP() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLoc() {
        return loc;
    }

    public String getOrg() {
        return org;
    }

    public String getTimezone() {
        return timezone;
    }
}