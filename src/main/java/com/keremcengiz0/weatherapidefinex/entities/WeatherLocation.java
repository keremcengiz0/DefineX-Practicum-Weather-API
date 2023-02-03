package com.keremcengiz0.weatherapidefinex.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherLocation {
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private String localtime;
}
