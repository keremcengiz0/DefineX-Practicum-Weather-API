package com.keremcengiz0.weatherapidefinex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class WeatherCurrentRequest {
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "Enter a valid city name")
    @NotBlank(message = "City name cannot be empty!")
    private String city;
}
