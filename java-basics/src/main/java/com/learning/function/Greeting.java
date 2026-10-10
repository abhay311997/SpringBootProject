package com.learning.function;

public class Greeting {
    /*
    generate a greeting message based on the time of day.
    time need to calculate by generating time in 24 hour format and return the greeting message based on the time of day. 
    For example, if the time is between 5 AM and 12 PM, return "Good Morning!", if it's between 12 PM and 5 PM, return "Good Afternoon!", and if it's between 5 PM and 9 PM, return "Good Evening!". If it's between 9 PM and 5 AM, return "Good Night!".
     */
    public String Greeting(String name) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        int minute = calendar.get(java.util.Calendar.MINUTE);
        if (hour >= 5 && hour < 12) {
            return "Good Morning!, " + name + " Its " + hour + ":" + minute + " am";
        } else if (hour >= 12 && hour < 17) {
            return "Good Afternoon!, " + name + " Its " + hour + ":" + minute + " pm";
        } else if (hour >= 17 && hour < 21) {
            return "Good Evening!, " + name + " Its " + hour + ":" + minute + " pm";
        } else {
            return "Good Night! " + name + " Its " + hour + ":" + minute + " pm";
        }
    }

    /**
     * generate a Hello name by taking name input from user and return the greeting message with name.
     * For example, if the name is "John", return "Hello John!".
     * @param name the name of the person to greet
     * @return the greeting message
     */
    public String getHelloName(String name) {
        return "Hello " + name + "!";
    }
}
