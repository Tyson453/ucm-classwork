
import java.util.Scanner;

public class Sentences {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence:");

            String sentence = scanner.nextLine().trim();
            String[] words = sentence.split(" ");

            String sentenceNoSpaces = sentence.replaceAll("\\s", "");
            String reversedNoSpaces = new StringBuilder(sentenceNoSpaces).reverse().toString();

            System.out.println();
            System.out.println("=== Sentence Analysis ===");
            System.out.println("Original sentence: " + sentence);
            System.out.println("Character count (no spaces): " + sentenceNoSpaces.length());
            System.out.println("Word count: " + words.length);
            System.out.println("Uppercase: " + sentence.toUpperCase());
            System.out.println("Lowercase: " + sentence.toLowerCase());
            System.out.println("First word: " + words[0]);
            System.out.println("Last word: " + words[words.length - 1]);
            System.out.println("Is palindrome? " + (sentenceNoSpaces.equalsIgnoreCase(reversedNoSpaces) ? "Yes" : "No"));

            System.out.print("Sentence classification: ");
            if (sentence.length() < 20) {
                System.out.println("Short");
            }
            if (20 <= sentence.length() && sentence.length() <= 50) {
                System.out.println("Medium");
            }
            if (50 < sentence.length()) {
                System.out.println("Long");
            }
        }
    }
}
