
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    private static LibraryItem[] libraryItems = new LibraryItem[]{
        new Book("B101", "Clean Code", 1.5, "Robert C. Martin", 464),
        new Book("B102", "Design Patterns", 1.75, "GoF", 395),
        new Magazine("M201", "NatGeo July 2025", 0.8, "July-2025", "National Geographic"),
        new DVD("D301", "Interstellar", 2.0, 169, "PG-13"),
        new DVD("D302", "Clean Code", 2.0, 148, "PG-13")
    };

    private static void viewAvailableItems() {
        System.out.println("-- Available Items --");
        for (LibraryItem item : libraryItems) {
            if (item.getIsAvailable()) {
                item.displayDetails();
            }
        }
    }

    private static void borrowItem(Scanner scanner) {
        // Prompt user for itemId
        System.out.print("Enter Item ID to borrow: ");
        String itemId = scanner.next();

        // Loop through libraryItems array to get item by itemId
        LibraryItem itemToBorrow = null;
        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equals(itemId)) {
                itemToBorrow = item;
                break;
            }
        }

        if (itemToBorrow == null) {
            // If item could not be found, inform user and exit the operation.
            System.out.println(String.format("Operation failed. Could not find item with id '%s'", itemId));
            return;
        } else if (!(itemToBorrow instanceof Borrowable)) {
            // If item is not borrowable, inform user and exit the operation.
            System.out.println(String.format("Operation failed. Item '%s' is not borrowable.", itemId));
            return;
        }

        if (!itemToBorrow.getIsAvailable()) {
            // If item is not available, inform user and exit the operation.
            System.out.println(String.format("Item '%s' is not currently available", itemId));
            return;
        }

        int days;
        try {
            // Prompt user for number of days to borrow the item
            System.out.print("Enter number of days: ");
            days = scanner.nextInt();
        } catch (InputMismatchException e) {
            // If input is invalid, inform user and exit the operation.
            System.out.println("Operation failed. Invalid input.");
            // clear invalid input
            scanner.nextLine();
            return;
        }

        // Successful operation
        System.out.println(String.format(
                "You borrowed '%s' for %d day(s). Total cost: $%.2f",
                itemId,
                days,
                ((Borrowable) itemToBorrow).calculateBorrowCost(days)
        ));
        itemToBorrow.setIsAvailable(false);
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int choiceInput;

            while (true) {
                System.out.println("==== Library Menu ====");
                System.out.println("1. View Available Items");
                System.out.println("2. Borrow an Item");
                System.out.println("3. Exit");
                System.out.print("Choose (1-3): ");

                try {
                    choiceInput = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a number from 1 through 3.\n");
                    // clear invalid input
                    scanner.nextLine();
                    continue;
                }

                System.out.println();
                switch (choiceInput) {
                    case 1:
                        viewAvailableItems();
                        break;
                    case 2:
                        borrowItem(scanner);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid input. Please enter a number from 1 through 3.");
                        break;
                }
                System.out.println();
            }
        }
    }
}
