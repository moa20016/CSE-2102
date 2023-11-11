package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidatePassword() throws Exception {
        mockMvc.perform(post("/validatePassword")
                .param("pwd", "StrongPwd123@")
                .param("username", "john_doe")
                .param("email", "john.doe@example.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pwd", is("StrongPwd123@")))
                .andExpect(jsonPath("$.username", is("john_doe")))
                .andExpect(jsonPath("$.email", is("john.doe@example.com")));
    }

    @Test
    public void testCheckEmail() throws Exception {
        mockMvc.perform(post("/validateEmail")
                .param("email", "test@example.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Email is valid."));
    }

    @Test
    public void testGetQuizQuestions() throws Exception {
        mockMvc.perform(get("/question"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3))) // Assuming you have 3 questions in your QuestionBank
                .andExpect(jsonPath("$[0].text", is("is An 18\" pizza is more pizza than two 12\" pizzas")))
                .andExpect(jsonPath("$[1].text", is("Does 69*420 = NICE?")))
                .andExpect(jsonPath("$[2].text", is("Is the capital of Iraq Baghdad?")));
    }
}
