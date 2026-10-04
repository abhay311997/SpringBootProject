package com.learning;

import com.learning.function.Greeting;
import com.learning.http.Client;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        System.out.println(greeting.Greeting());
        System.out.println(greeting.getHelloName("John"));

        Client client = new Client() ;
        try {
            String response  = client.get("https://example.com/");
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}