package com.keremcengiz0.weatherapidefinex.entities.forecast;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ForecastWeather {
    private List<ForecastDay> forecastday;
}
