package br.com.itauchallenge.itauchallengeapi.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateRepeatCharTest {

    @Test
    void hasNotRepeted() {
        String password = "AbTp9!fok";

        boolean naoTemCaracterRepetido = new ValidateRepeatChar().hasRepeted(password);
        assertFalse(naoTemCaracterRepetido);
    }

    @Test
    void hasRepeted() {
        String password = "AbTp9!foA";

        boolean temCaracterRepetido = new ValidateRepeatChar().hasRepeted(password);
        assertTrue(temCaracterRepetido);
    }

    @Test
    void invalidPassword1(){
        String password = "";
    }
}