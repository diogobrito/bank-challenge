package br.com.itauchallenge.itauchallengeapi.controller;

import br.com.itauchallenge.itauchallengeapi.model.PasswordDto;
import br.com.itauchallenge.itauchallengeapi.utils.ValidateRepeatChar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/itau-challenge")
public class PasswordController {

    @PostMapping("/password-validate")
    public ResponseEntity<?> passwordValidate(@RequestBody @Valid PasswordDto input) {
        boolean hasRepeted = new ValidateRepeatChar().hasRepeted(input.getPassword());
        return hasRepeted ? ResponseEntity.badRequest().build() : ResponseEntity.ok().build();
    }
}
