package br.com.itauchallenge.itauchallengeapi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateRepeatCharTest {

    @Test
    void hasRepeted() {
        String senhaNaoRepetida = "AbTp9!fok";

        boolean naoTemCaracterRepetido = new ValidateRepeatChar().hasRepeted(senhaNaoRepetida);
        assertFalse(naoTemCaracterRepetido);
    }

    @Test
    void hasNotRepeted() {
        String senhaNaoRepetida = "AbTp9!foA";

        boolean temCaracterRepetido = new ValidateRepeatChar().hasRepeted(senhaNaoRepetida);
        assertTrue(temCaracterRepetido);
    }
}