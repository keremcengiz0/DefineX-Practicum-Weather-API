package com.keremcengiz0.weatherapidefinex.entities.forecast;

import com.keremcengiz0.weatherapidefinex.entities.WeatherCondition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Day {
    private double maxtemp_c;
    private double mintemp_c;
    private double avgtemp_c;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalsnow_cm;
    private double avghumidity;
    private int daily_will_it_rain;
    private int daily_chance_of_rain;
    private int daily_will_it_snow;
    private int daily_chance_of_snow;
    private WeatherCondition condition;
}
