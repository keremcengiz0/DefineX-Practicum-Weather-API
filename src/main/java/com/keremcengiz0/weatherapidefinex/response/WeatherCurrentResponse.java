package com.keremcengiz0.weatherapidefinex.response;

import com.keremcengiz0.weatherapidefinex.entities.WeatherCurrent;
import com.keremcengiz0.weatherapidefinex.entities.WeatherLocation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherCurrentResponse {
    private WeatherLocation location;
    private WeatherCurrent current;
}
