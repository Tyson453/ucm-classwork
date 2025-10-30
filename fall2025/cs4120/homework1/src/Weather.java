
import java.util.InputMismatchException;
import java.util.Scanner;

public class Weather {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numDays;
            int[] temperatures;

            try {
                // prompt user for number of days
                System.out.print("Enter number of days: ");
                numDays = scanner.nextInt();

                // prompt user for temperatures and store in array
                temperatures = new int[numDays];
                System.out.println("Enter " + numDays + " temperature values:");
                for (int i = 0; i < numDays; i++) {
                    System.out.print("Day " + (i + 1) + ": ");
                    temperatures[i] = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                // If user enters wrong input (not integer), print a message and exit the program
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }

            System.out.println();

            int high = temperatures[0], highIndex = 0;
            int low = temperatures[0], lowIndex = 0;
            double total = 0;
            int currentStreak = 1, currentStreakStartIndex = 0;
            int longestStreak = 1, longestStreakStartIndex = 0;
            boolean hasDuplicates = false;

            // Loop through temps to get high, low, total, and check duplicates
            for (int i = 0; i < numDays; i++) {
                int temp = temperatures[i];

                // If current temp higher than high, update high and highIndex
                if (temp > high) {
                    high = temp;
                    highIndex = i;
                }

                // If current temp lower than low, update low and lowIndex
                if (temp < low) {
                    low = temp;
                    lowIndex = i;
                }

                // Add current temp to total
                total += temp;

                // Skip first loop iteration because there is no previous temp to compare to
                if (i != 0) {
                    // compare current temp and previous temp
                    if (temperatures[i] > temperatures[i - 1]) {
                        currentStreak++;
                    } else {
                        // Set longestStreak if currentStreak is larger
                        if (currentStreak > longestStreak) {
                            longestStreak = currentStreak;
                            longestStreakStartIndex = currentStreakStartIndex;
                        }
                        // Reset current streak
                        currentStreak = 1;
                        currentStreakStartIndex = i;
                    }
                }

                // If we've already found a duplicate, we don't need to keep checking
                if (!hasDuplicates) {
                    // Check all temps after current temp for duplicates
                    for (int j = i + 1; j < numDays; j++) {
                        if (temperatures[j] == temp) {
                            hasDuplicates = true;
                        }
                    }
                }
            }

            // currentStreak never formally ended during the loop
            // so we must do another check to see if it's the longest
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestStreakStartIndex = currentStreakStartIndex;
            }

            System.out.println(String.format("Highest temperature: %d (Day %d)", high, highIndex + 1));
            System.out.println(String.format("Lowest temperature: %d (Day %d)", low, lowIndex + 1));
            System.out.println(String.format("Average temperature: %f", total / numDays));
            System.out.println(String.format(
                    "Longest increasing streak: %d %s (Day %d to Day %d)",
                    longestStreak,
                    longestStreak == 1 ? "day" : "days",
                    longestStreakStartIndex + 1,
                    longestStreakStartIndex + longestStreak
            ));
            System.out.println(String.format("Any duplicate temperatures recorded? %s", hasDuplicates ? "Yes" : "No"));
        }

    }
}
