package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class QuizController {

    private final QuestionBank questionBank = new QuestionBank();

    @PostMapping("/validatePassword")
    public ResponseEntity<Password> validatePassword(
            @RequestParam(value = "pwd") String pwd,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "email") String email) {
        Password password = new Password(pwd, username, email);
        return ResponseEntity.ok(password);
    }

    @PostMapping("/validateEmail")
    public ResponseEntity<String> checkEmail(@RequestParam(value = "email") String email) {
        if (EmailValidator.isValidEmail(email)) {
            return ResponseEntity.ok("Email is valid.");
        } else {
            return ResponseEntity.badRequest().body("Email is invalid.");
        }
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuizQuestions() {
        List<Question> questions = questionBank.getQuestions();
        return ResponseEntity.ok(questions);
    }
}