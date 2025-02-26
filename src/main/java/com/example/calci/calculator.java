package com.example.calci;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Scientific Calculator");
        System.out.println("--------------------");

        while (!exit) {
            // Display menu
            System.out.println("\nAvailable Operations:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                exit = true;
                System.out.println("Thank you for using the calculator. Goodbye!");
                continue;
            }

            // Validate choice
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please select 1-5.");
                continue;
            }

            double result = 0;
            double num;

            try {
                System.out.print("Enter number: ");
                num = scanner.nextDouble();

                switch (choice) {
                    case 1: // Square Root
                        if (num < 0) {
                            System.out.println("Error: Cannot calculate square root of negative number");
                            continue;
                        }
                        result = findSquareRoot(num);
                        System.out.printf("√%.2f = %.4f%n", num, result);
                        break;

                    case 2: // Factorial
                        if (num < 0 || num != Math.floor(num)) {
                            System.out.println("Error: Factorial only works with non-negative integers");
                            continue;
                        }
                        result = findFactorial(num);
                        System.out.printf("%.0f! = %.0f%n", num, result);
                        break;

                    case 3: // Natural Log
                        if (num <= 0) {
                            System.out.println("Error: Cannot calculate logarithm of zero or negative number");
                            continue;
                        }
                        result = findLog(num);
                        System.out.printf("ln(%.2f) = %.4f%n", num, result);
                        break;

                    case 4: // Power
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        result = findPower(num, exponent);
                        System.out.printf("%.2f^%.2f = %.4f%n", num, exponent, result);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear buffer
                continue;
            }
        }
        scanner.close();
    }

    public static double findSquareRoot(double a) {
        return Math.sqrt(a);
    }

    public static double findFactorial(double a) {
        if (a == 0 || a == 1) return 1;
        double ans = 1;
        for (int i = 2; i <= (int)a; i++) {
            ans *= i;
        }
        return ans;
    }

    public static double findLog(double a) {
        double ans = Math.log(a);
        return Math.round(ans * 10000.0) / 10000.0; // Round to 4 decimal places
    }

    public static double findPower(double a, double e) {
        return Math.pow(a, e);
    }
}