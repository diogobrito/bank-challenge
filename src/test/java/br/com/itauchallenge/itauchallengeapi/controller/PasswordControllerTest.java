package br.com.itauchallenge.itauchallengeapi.controller;

import br.com.itauchallenge.itauchallengeapi.dto.PasswordDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PasswordController.class)
class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void passwordValid() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("AbTp9!fok");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void passwordInvalidOne() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .header("Accept-Language","pt-BR")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.field_errors[*].message", hasItem("não deve estar em branco")));
    }

    @Test
    void passwordInvalidTwo() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("aa");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void passwordInvalidThree() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("ab");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void passwordInvalidFour() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("AAAbbbCc");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void passwordInvalidFive() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("AbTp9!foo");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void passwordInvalidSix() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("aAbTp9!foA");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void passwordInvalidSeven() throws Exception {
        PasswordDto password = new PasswordDto();
        password.setPassword("AbTp9 fok");

        this.mockMvc.perform(post("/itau-challenge/password-validate")
                .content(asJsonString(password))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}