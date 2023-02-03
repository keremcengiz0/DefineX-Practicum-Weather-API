package com.keremcengiz0.weatherapidefinex.response;

import com.keremcengiz0.weatherapidefinex.entities.Error;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private Error error;
}
