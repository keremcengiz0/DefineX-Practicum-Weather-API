package com.keremcengiz0.weatherapidefinex.response;

import com.keremcengiz0.weatherapidefinex.entities.WeatherCurrent;
import com.keremcengiz0.weatherapidefinex.entities.WeatherLocation;
import com.keremcengiz0.weatherapidefinex.entities.forecast.Forecast;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastResponse {
    private WeatherLocation location;
    private WeatherCurrent current;
    private Forecast forecast;
}
