package com.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Reads the file "files/in1.txt" line by line and 
// prints each line to the console.

public class ReadFileLineByLine {
    public static void main(String[] args) {
        //Path path = Paths.get("C:\\SpringBoot\\Project\\java-basics\\files\\in1.txt");
        Path path = Paths.get("files", "in1.txt"); // when run from the java-basics folder
        try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}