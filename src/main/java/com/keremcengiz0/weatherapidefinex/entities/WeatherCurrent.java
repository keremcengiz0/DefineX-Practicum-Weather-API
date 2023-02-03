package com.keremcengiz0.weatherapidefinex.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherCurrent {
    private String last_updated;
    private double temp_c;
    private WeatherCondition condition;
    private double wind_kph;
    private String wind_dir;
    private int humidity;
    private int cloud;
    private double feelslike_c;
}
