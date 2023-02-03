package com.keremcengiz0.weatherapidefinex.exceptions;

public class InvalidApiKeyException extends IllegalArgumentException{
    private static final String message = "Error with API Key!";

    public InvalidApiKeyException() {
    }

    public InvalidApiKeyException(String _message) {
        super(message + " " + _message);
    }
}
