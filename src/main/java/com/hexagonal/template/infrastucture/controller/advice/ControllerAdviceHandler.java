package com.hexagonal.template.infrastucture.controller.advice;

import com.hexagonal.template.domain.commons.exceptions.ProductNotFoundException;
import com.hexagonal.template.infrastucture.models.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto productNotFound(ProductNotFoundException ex) {
        return new ErrorDto(ex.getMessage(), LocalDateTime.now());
    }
}
