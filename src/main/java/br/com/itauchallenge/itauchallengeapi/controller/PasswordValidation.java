package br.com.itauchallenge.itauchallengeapi.controller;

import br.com.itauchallenge.itauchallengeapi.business.ValidateRepeatChar;
import br.com.itauchallenge.itauchallengeapi.dto.PasswordDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Validation;

public class PasswordValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return PasswordDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordDto password = (PasswordDto) target;
        if(!errors.hasErrors()) {
            if(new ValidateRepeatChar().hasRepeted(password.getPassword())) {
                errors.rejectValue("password", null, "Não possuir caracteres repetidos dentro do conjunto.");
            }
        }
    }
}
