package br.com.itauchallenge.itauchallengeapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class PasswordDto {

    @NotBlank
    @Size(min = 9, message = "Nove ou mais caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{9,20}$",
            message = "Ao menos 1 dígito, " +
                    "ao menos 1 letra minúscula, " +
                    "ao menos 1 letra maiúscula, " +
                    "ao menos 1 caractere especial. " +
                    "Considere como especial os seguintes caracteres: !@#$%^&*()-+ ")
    private String password;

}
