package com.quizapp;

import java.util.*;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?",
            new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));

        questions.add(new Question("Which language is used for Android development?",
            new String[]{"1. Swift", "2. Kotlin", "3. JavaScript", "4. Ruby"}, 2));

        questions.add(new Question("What does JVM stand for?",
            new String[]{"1. Java Variable Machine", "2. Java Virtual Method", "3. Java Virtual Machine", "4. Just Virtual Machine"}, 3));

        // Add more questions as needed
    }

    public void start(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + user.getUsername() + " to the Quiz!");

        int questionNumber = 1;
        for (Question q : questions) {
            System.out.println("\nQuestion " + questionNumber + ": " + q.getQuestionText());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            if (q.isCorrect(choice)) {
                System.out.println("✅ Correct!");
                user.incrementScore();
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.getOptions()[q.getCorrectOption() - 1]);
            }
            questionNumber++;
        }

        System.out.println("\n🎯 Quiz completed. Your score: " + user.getScore() + "/" + questions.size());
    }
}
