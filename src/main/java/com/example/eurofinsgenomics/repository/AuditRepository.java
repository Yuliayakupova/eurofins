package com.example.eurofinsgenomics.repository;

import com.example.eurofinsgenomics.dto.GeoIpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuditRepository {

    private final String  SQL_INSERT_AUDIT = "insert into audit (ip, country, city, loc) values(:IP, :COUNTRY, :CITY, :LOCATION)";
    @Autowired
    private final JdbcTemplate connection;

    public AuditRepository(JdbcTemplate connection) {
        this.connection = connection;
    }

    public void insertGeoIPData(final GeoIpDTO geo){

        Map<String, Object> params = new HashMap<>();
        params.put("IP",geo.getIP());
        params.put("COUNTRY",geo.getCountry());
        params.put("CITY",geo.getCity());
        params.put("LOCATION",geo.getLoc());

        connection.update(SQL_INSERT_AUDIT, params);
    }
}
