package br.com.itauchallenge.itauchallengeapi.controller;

import br.com.itauchallenge.itauchallengeapi.dto.PasswordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/itau-challenge")
public class PasswordController {

    @PostMapping("/password-validate")
    public ResponseEntity<?> passwordValidate(@RequestBody @Valid PasswordDto input) {
        Map<String, String> success = new HashMap<>();
        success.put("message", "Sua senha atende aos criterios de validação.");
        return ResponseEntity.ok(success);
    }

    @InitBinder("passwordDto")
    public void customize(WebDataBinder binder) {
        binder.addValidators(new PasswordValidation());
    }

}
