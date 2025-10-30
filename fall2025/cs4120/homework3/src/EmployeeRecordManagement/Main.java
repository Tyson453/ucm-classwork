package EmployeeRecordManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Employee currentEmployee = new Employee(
            "E123",
            "Alice",
            "Software Engineer",
            85000,
            new Address("123 Main St", "New York", "NY", "10001")
    );

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Employee obj to store updates
            Employee editedEmployee;
            try {
                editedEmployee = currentEmployee.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Failed to clone current employee");
                return;
            }

            // print current employee
            System.out.println("Current Employee:");
            System.out.println(editedEmployee.toString());
            System.out.println();

            // prompt for what to update
            System.out.println("Which field would you like to update?");
            System.out.println("1. Salary");
            System.out.println("2. Address");
            System.out.println("3. Both");
            System.out.print("> ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 3.");
                scanner.nextLine();
                return;
            }

            System.out.println();

            // if choice is 1 or 3, prompt for new salary and update
            if (choice == 1 || choice == 3) {
                double newSalary;
                try {
                    System.out.print("Enter new salary: ");
                    newSalary = scanner.nextDouble();
                    scanner.nextLine();
                    editedEmployee.setSalary(newSalary);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number");
                    scanner.nextLine();
                    return;
                }
            }
            // if choice is 2 or 3, prompt for new address and update
            if (choice == 2 || choice == 3) {
                String newStreet, newCity, newState, newZip;

                System.out.print("Enter new street: ");
                newStreet = scanner.nextLine();
                System.out.print("Enter new city: ");
                newCity = scanner.nextLine();
                System.out.print("Enter new state: ");
                newState = scanner.nextLine();
                System.out.print("Enter new ZIP: ");
                newZip = scanner.nextLine();

                editedEmployee.setAddress(new Address(newStreet, newCity, newState, newZip));
            }

            // print updated employee
            System.out.println();
            System.out.println("Updated Employee Record:");
            System.out.println(editedEmployee.toString());

            // prompt if user wants to undo
            String undo;
            System.out.print("Do you want to undo? (yes/no): ");
            undo = scanner.next();

            System.out.println("Final Employee Record:");
            switch (undo) {
                // if undo is "yes", print currentEmployee as final employee
                case "yes":
                    System.out.println(currentEmployee.toString());
                    break;
                // otherwise, print editedEmployee as final employee
                default:
                    System.out.println(editedEmployee.toString());
            }
        }
    }
}
