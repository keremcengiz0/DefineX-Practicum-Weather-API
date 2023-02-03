package com.keremcengiz0.weatherapidefinex.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private Integer code;
    private String message;
}
