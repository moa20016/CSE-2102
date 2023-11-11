package com.example.demo;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        this.questions = new ArrayList<>();

        Question question1 = new Question(UUID.randomUUID(), "is An 18\" pizza is more pizza than two 12\" pizzas", true);
        Question question2 = new Question(UUID.randomUUID(), "Does 69*420 = NICE?", false);
        Question question3 = new Question(UUID.randomUUID(), "Is the capital of Iraq Baghdad?", true);
        
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}