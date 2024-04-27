package com.hexagonal.template.infrastucture.models.dto;

import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime date) {

}
