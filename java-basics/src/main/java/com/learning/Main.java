package com.learning;

import com.learning.function.Greeting;
import com.learning.http.Client;
import com.learning.rest.RestClient;

public class Main {
    public static void main(String[] args) {

        String arg = args.length > 0 ? args[0] : "greet";

        switch (arg) {
            case "greet":
                Greeting greeting = new Greeting();
                //System.out.println(greeting.getHelloName("John"));
                System.out.println(greeting.Greeting("Abhay"));
                break;
            case "http":
                Client client = new Client();
                try {
                    String response = client.get("https://example.com/");
                    System.out.println("Response: " + response);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case "rest":
                RestClient restClient = new RestClient();
                try {
                    var apiresponse = restClient.getApi().getPhotos().execute();
                    //System.out.println(apiresponse);
                    apiresponse.body().forEach(photo -> {
                        System.out.println(photo.getTitle());
                    });
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Please provide a valid argument: 'greet', 'http', or 'rest'");
        }
    }
}
