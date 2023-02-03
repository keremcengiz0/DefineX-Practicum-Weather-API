package com.keremcengiz0.weatherapidefinex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ForecastRequest {

    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "Enter a valid city name")
    @NotBlank(message = "City name cannot be empty!")
    private String city;

    @Min(value = 1, message = "The day must be at least 1. " )
    @Max(value = 15, message = "The day must be at least 15. " )
    @NotNull(message = "Days cannot be null for a daily forecast!")
    private Integer days;
}
