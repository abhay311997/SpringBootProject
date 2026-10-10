package com.assignment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Reads files whose names start with "in*" from the "files" directory, 
// extracts numbers from them, sorts the numbers, 
// and writes them to files/out.txt 
// If the out.txt file already exists, it will be overwritten.

public class ReadSortAndWrite {
    public static void main(String[] args) throws IOException {
        Path filesDir = Paths.get("files");
        List<Integer> numbers = new ArrayList<>();

        /* Read two input files in1.txt and in2.txt and extract numbers from them 
        then push them into the list numbers */
        try {
            Path path = Paths.get("files", "in1.txt"); //read from files/in1.txt when run from the java-basics folder
            Files.readAllLines(path).forEach(line -> {
                String value = line.trim();
                if (!value.isEmpty()) {
                    numbers.add(Integer.parseInt(value));
                }
            });
        } catch (IOException e) {
                e.printStackTrace();
        }
        try{
            Path path = Paths.get("files", "in2.txt"); 
            Files.readAllLines(path).forEach(line -> {
                String value = line.trim();
                if (!value.isEmpty()) {
                    numbers.add(Integer.parseInt(value));
                }
            });
        } catch (IOException e) {
                e.printStackTrace();
        }

        // Bonus1: Make the program work for any number of files.

        // Read all files in the "files" directory whose names start with "in*" and extract numbers from them, 
        // push them into the list numbers
        /* 
        try (DirectoryStream<Path> inputFiles =
                     Files.newDirectoryStream(filesDir, "in*")) { // Read all files in the "files" directory whose names start with "in*"
            for (Path inputFile : inputFiles) {
                if (!Files.isRegularFile(inputFile)) {
                    continue;
                }
                for (String line : Files.readAllLines(inputFile)) {
                    String value = line.trim();
                    if (!value.isEmpty()) {
                        numbers.add(Integer.parseInt(value));
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading input files: " + e.getMessage());
            return;
        }
        */

        // Bonus2: Make sure that the file read and write operations are on a separate thread

        // Bonus3: Make sure that the read operations can be all done in parallel 
        // (i.e. we are not waiting for file 1 to be read before we read file 2)



        // Sort the numbers of List<Integer> numbers in ascending order
        // then write them to files/out.txt
        numbers.sort(Integer::compareTo);

        List<String> outputLines = numbers.stream()
                .map(String::valueOf)
                .toList();

         Files.write(
                filesDir.resolve("out.txt"),
                outputLines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}