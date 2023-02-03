package com.keremcengiz0.weatherapidefinex.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherCondition {
    private String text;
    private String icon;
    private int code;
}
