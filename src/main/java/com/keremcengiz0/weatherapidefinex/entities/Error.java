package com.keremcengiz0.weatherapidefinex.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private Integer code;
    private String message;
}
