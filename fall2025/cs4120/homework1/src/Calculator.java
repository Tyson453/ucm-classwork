
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            char choice;
            int num1, num2;

            try {
                // prompt user for first number
                System.out.print("Enter first number: ");
                num1 = scanner.nextInt();

                // prompt user for second number
                System.out.print("Enter second number: ");
                num2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                // If user enters wrong input (not integer), print a message and exit the program
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }

            System.out.println();

            // prompt user for operation
            System.out.println("Select an operation: +, -, *, /, %, &, |, ^, ?");
            System.out.print("> ");
            choice = scanner.next().charAt(0);
            System.out.println();

            switch (choice) {
                case '+' ->
                    System.out.println("Result: " + (num1 + num2));
                case '-' ->
                    System.out.println("Result: " + (num1 - num2));
                case '*' ->
                    System.out.println("Result: " + (num1 * num2));
                case '/' ->
                    System.out.println("Result: " + (num1 / num2));
                case '%' ->
                    System.out.println("Result: " + (num1 % num2));
                case '&' ->
                    System.out.println("Result: " + (num1 & num2));
                case '|' ->
                    System.out.println("Result: " + (num1 | num2));
                case '^' ->
                    System.out.println("Result: " + (num1 ^ num2));
                case '?' ->
                    System.out.println("Largest: " + (num1 > num2 ? num1 : num2));
                default ->
                    System.out.println("Invalid choice");
            }
        }
    }
}
