package com.keremcengiz0.weatherapidefinex.controllers;

import com.keremcengiz0.weatherapidefinex.exceptions.CityNotFoundException;
import com.keremcengiz0.weatherapidefinex.exceptions.InvalidApiKeyException;
import com.keremcengiz0.weatherapidefinex.request.ForecastRequest;
import com.keremcengiz0.weatherapidefinex.request.WeatherCurrentRequest;
import com.keremcengiz0.weatherapidefinex.response.ForecastResponse;
import com.keremcengiz0.weatherapidefinex.response.WeatherCurrentResponse;
import com.keremcengiz0.weatherapidefinex.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/weather/api")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    // These controllers send a request to the service to fetch the current weather condition.
    @PostMapping(value = "/current")
    public WeatherCurrentResponse getCurrentWeather(@RequestBody @Valid WeatherCurrentRequest weatherCurrentRequest) throws Exception {
        try {
            WeatherCurrentResponse response = this.weatherService.getCurrentWeather(weatherCurrentRequest.getCity());
            return response;
        } catch (InvalidApiKeyException e) {
            throw new Exception("Error: Invalid API key provided!");
        } catch (CityNotFoundException e) {
            throw new Exception("Error: City not found!");
        } catch (Exception e) {
            throw new Exception("Error: An unexpected error occurred!");
        }
    }

    // These controllers send a request to the service to fetch the daily weather.
    @PostMapping(value = "/forecast")
    public ForecastResponse getForecastWeather(@RequestBody @Valid ForecastRequest forecastRequest) throws Exception {
        try {
            ForecastResponse forecastResponse = this.weatherService.getForecastWeather(forecastRequest.getCity(), forecastRequest.getDays());
            return forecastResponse;
        } catch (InvalidApiKeyException e) {
            throw new Exception("Error: Invalid API key provided!");
        } catch (CityNotFoundException e) {
            throw new Exception("Error: City not found!");
        } catch (Exception e) {
            throw new Exception("Error: An unexpected error occurred!");
        }
    }
}
