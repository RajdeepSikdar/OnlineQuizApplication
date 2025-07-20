package com.quizapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        User user = new User(name);
        Quiz quiz = new Quiz();
        quiz.start(user);
    }
}
