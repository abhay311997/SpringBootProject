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

// Reads files whose names start with "in*" from the "files" directory, 
// extracts numbers from them, sorts the numbers, 
// and writes them to files/out.txt 
// If the out.txt file already exists, it will be overwritten.

public class ReadSortAndWrite {
    public static void main(String[] args) throws IOException {
        Path filesDir = Paths.get("files");
        List<Integer> numbers = new ArrayList<>();

        try (DirectoryStream<Path> inputFiles =
                     Files.newDirectoryStream(filesDir, "in*")) {
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