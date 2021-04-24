package com.lasalle.sd2.g2.pokemons.infrastructure.dto;

public class ErrorMessageDto {

    private final String message;

    public ErrorMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
