package br.com.itauchallenge.itauchallengeapi.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
@Getter
public class ValidationErrorsOutputDto {
    @JsonProperty("field_errors")
    private final List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();
    public void addFieldError(String field, String message) {
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        this.fieldErrors.add(fieldError);
    }
}