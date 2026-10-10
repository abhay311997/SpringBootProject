package com.assignment.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Reads the file "files/in1.txt" line by line and 
// prints each line to the console.

public class ReadFileLineByLine {
    public static void main(String[] args) {
        //Path path = Paths.get("C:\\SpringBoot\\Project\\java-basics\\src\\main\\java\\com\\assignment\\assignment1\\files\\in1.txt");
        Path path = Paths.get("C:\\SpringBoot\\Project\\java-basics\\src\\main\\java\\com\\assignment\\assignment1\\files", "in1.txt");
        try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}