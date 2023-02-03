package com.keremcengiz0.weatherapidefinex.dtos;

import com.keremcengiz0.weatherapidefinex.entities.WeatherCurrent;
import com.keremcengiz0.weatherapidefinex.entities.WeatherLocation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherCurrentDTO {
    private WeatherLocation location;
    private WeatherCurrent current;
}
