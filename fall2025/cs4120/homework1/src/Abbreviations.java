
import java.util.Scanner;

public class Abbreviations {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();

            System.out.print("Enter a phrase: ");
            String phrase = scanner.nextLine().trim();
            String[] words = phrase.split(" ");

            for (String word : words) {
                // Get first character of the word
                char firstChar = word.charAt(0);
                // If the first character is uppercase, add to the string builder
                if (Character.isUpperCase(firstChar)) {
                    sb.append(firstChar);
                }
            }

            System.out.println("Generated Abbreviation: " + sb.toString());
        }
    }
}
