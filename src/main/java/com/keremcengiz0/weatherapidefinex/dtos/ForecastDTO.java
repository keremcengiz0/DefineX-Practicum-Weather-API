package com.keremcengiz0.weatherapidefinex.dtos;

import com.keremcengiz0.weatherapidefinex.entities.WeatherCurrent;
import com.keremcengiz0.weatherapidefinex.entities.WeatherLocation;
import com.keremcengiz0.weatherapidefinex.entities.forecast.ForecastWeather;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastDTO {
    private WeatherLocation location;
    private WeatherCurrent current;
    private ForecastWeather forecast;
}
