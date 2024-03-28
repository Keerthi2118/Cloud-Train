import java.util.InputMismatchException;
import java.util.Scanner;

public class ComplexAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the first number
        System.out.print("Enter the first number: ");
        double num1 = getInput(scanner);

        // Prompt user to enter the second number
        System.out.print("Enter the second number: ");
        double num2 = getInput(scanner);

        // Perform addition
        double sum = num1 + num2;

        // Display the result
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        scanner.close();
    }

    // Method to get input from user with error handling
    private static double getInput(Scanner scanner) {
        double input = 0;
        boolean validInput = false;
        do {
            try {
                input = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                // Clear scanner buffer
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid number.");
                System.out.print("Retry: ");
            }
        } while (!validInput);
        return input;
    }
}
