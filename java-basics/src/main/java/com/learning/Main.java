package com.learning;

import com.function.Greeting;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        System.out.println(greeting.Greeting());
        System.out.println(greeting.getHelloName("John"));
    }
}