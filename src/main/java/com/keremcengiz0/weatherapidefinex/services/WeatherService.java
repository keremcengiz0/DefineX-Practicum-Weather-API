package com.keremcengiz0.weatherapidefinex.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keremcengiz0.weatherapidefinex.dtos.ForecastDTO;
import com.keremcengiz0.weatherapidefinex.dtos.WeatherCurrentDTO;
import com.keremcengiz0.weatherapidefinex.exceptions.CityNotFoundException;
import com.keremcengiz0.weatherapidefinex.exceptions.InvalidApiKeyException;
import com.keremcengiz0.weatherapidefinex.response.ErrorResponse;
import com.keremcengiz0.weatherapidefinex.response.ForecastResponse;
import com.keremcengiz0.weatherapidefinex.response.WeatherCurrentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    // API KEY and API URL are defined in application.properties file. And the data was pulled from there using @Value annotation.
    @Value("${API_KEY}")
    private String API_KEY;

    @Value("${API_URL}")
    private String API_URL;

    // It is the function that brings instant weather data.
    public WeatherCurrentResponse getCurrentWeather(String city) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        WeatherCurrentDTO weatherCurrentDTO = null;

        // The request URL is created.
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_URL + "/current.json")
                .queryParam("key", "{key}")
                .queryParam("q", "{q}")
                .queryParam("aqi", "{aqi}")
                .encode()
                .toUriString();

        // Adds relevant data to the URL address.
        Map<String, String> params = new HashMap<>();
        params.put("key", API_KEY);
        params.put("q", city);
        params.put("aqi", "no");

        try {
            //A request is made to the API and the data is passed to the weatherCurrentDTO object.
            weatherCurrentDTO = restTemplate.getForObject(urlTemplate, WeatherCurrentDTO.class, params);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);
            // The 2008 error code indicates invalid api key. The 1006 error code indicates city not found.
            if (e.getStatusCode() == HttpStatus.FORBIDDEN && errorResponse.getError().getCode() == 2008 ) {
                throw new InvalidApiKeyException();
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST && errorResponse.getError().getCode() == 1006) {
                throw new CityNotFoundException();
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonInString = objectMapper.writeValueAsString(weatherCurrentDTO);

        //We transferred the data to the object named weatherCurrentResponse using ObjectMapper.
        WeatherCurrentResponse weatherCurrentResponse = objectMapper.readValue(jsonInString, WeatherCurrentResponse.class);

        return weatherCurrentResponse;
    }

    //It is the function that returns daily weather data.
    public ForecastResponse getForecastWeather(String city, Integer days) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ForecastDTO forecastDTO = null;

        // The request URL is created.
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_URL + "/forecast.json")
                .queryParam("key", "{key}")
                .queryParam("q", "{q}")
                .queryParam("days", "{days}")
                .queryParam("aqi", "{aqi}")
                .queryParam("alerts","{alerts}")
                .encode()
                .toUriString();

        // Adds relevant data to the URL address.
        Map<String, String> params = new HashMap<>();
        params.put("key", API_KEY);
        params.put("q", city);
        params.put("days", String.valueOf(days));
        params.put("aqi", "no");
        params.put("alerts","no");

        try {
            //A request is made to the API and the data is passed to the forecastDTO object.
            forecastDTO = restTemplate.getForObject(urlTemplate, ForecastDTO.class, params);
        } catch (HttpClientErrorException e) {
            ErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class);

            // The 2008 error code indicates invalid api key. The 1006 error code indicates city not found.
            if (e.getStatusCode() == HttpStatus.FORBIDDEN && errorResponse.getError().getCode() == 2008 ) {
                throw new InvalidApiKeyException();
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST && errorResponse.getError().getCode() == 1006) {
                throw new CityNotFoundException();
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonInString = objectMapper.writeValueAsString(forecastDTO);

        //We transferred the data to the object named forecastResponse using ObjectMapper.
        ForecastResponse forecastResponse = objectMapper.readValue(jsonInString, ForecastResponse.class);

        return forecastResponse;
    }
}
