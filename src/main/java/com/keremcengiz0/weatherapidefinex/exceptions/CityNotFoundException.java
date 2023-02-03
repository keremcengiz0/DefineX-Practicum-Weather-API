package com.keremcengiz0.weatherapidefinex.exceptions;

public class CityNotFoundException extends IllegalArgumentException {

    public CityNotFoundException() {
    }

    public CityNotFoundException(String message) {
        super(message);
    }
}
