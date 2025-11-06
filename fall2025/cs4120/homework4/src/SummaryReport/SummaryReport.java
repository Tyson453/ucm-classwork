package SummaryReport;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SummaryReport {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputFilePath, outputFilePath;

            System.out.print("Enter the name of the input file: ");
            inputFilePath = scanner.nextLine();
            System.out.print("Enter the name of the output file: ");
            outputFilePath = scanner.nextLine();

            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);

            if (!inputFile.exists() || !inputFile.canRead()) {
                System.out.println("The file '" + inputFilePath + "' either does not exist or could not be read.");
                return;
            }

            System.out.println("File exists: true");
            System.out.println("Absolute Path: " + inputFile.getAbsolutePath());
            System.out.println("File Size: " + inputFile.length() + " bytes");

            int charCount = 0, wordCount = 0, lineCount = 0, nonBlankLineCount = 0;
            String firstNonBlankLine = null, lastNonBlankLine = null;
            try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile))) {
                String line;

                // Simply looping with the condition ((line = inputReader.readLine()) != null)
                // makes it so that line count is inaccurate when last line is empty
                while (true) {
                    // read line
                    line = inputReader.readLine();

                    if (line == null) {
                        break;
                    }

                    // increment lineCount for each line
                    lineCount++;
                    if (!line.isBlank()) {
                        nonBlankLineCount++;
                    } else {
                        continue;
                    }

                    // set non-blank lines
                    if (firstNonBlankLine == null) {
                        firstNonBlankLine = line;
                    }
                    lastNonBlankLine = line;

                    // Split line string by whitespace and increment wordCount
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;

                    // Increment charCount by num of chars in each word
                    for (String word : words) {
                        charCount += word.length();
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading '" + inputFilePath + "': " + e.getMessage());
            }

            try (BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile))) {
                outputWriter.write(
                        "SUMMARY\n"
                        + "---------------\n"
                        + "Total lines: " + lineCount + "\n"
                        + "Non-blank lines: " + nonBlankLineCount + "\n"
                        + "Total words: " + wordCount + "\n"
                        + "Total characters (excluding spaces): " + charCount + "\n"
                        + "---------------\n"
                        + "First non-blank line: " + firstNonBlankLine + "\n"
                        + "Last non-blank line: " + lastNonBlankLine
                );
                System.out.println("Summary written successfully to " + outputFilePath);
            } catch (IOException e) {
                System.err.println("Error writing to '" + outputFilePath + "': " + e.getMessage());
            }
        }
    }
}
