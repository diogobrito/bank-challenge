package br.com.itauchallenge.itauchallengeapi.shared;

import lombok.Getter;
@Getter
public class FieldErrorOutputDto {
    private final String field;
    private final String message;
    public FieldErrorOutputDto(String field, String message) {
        this.field = field;
        this.message = message;
    }
}