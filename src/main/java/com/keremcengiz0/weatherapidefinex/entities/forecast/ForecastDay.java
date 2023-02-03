package com.keremcengiz0.weatherapidefinex.entities.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastDay {
    private String date;
    private Day day;
}
