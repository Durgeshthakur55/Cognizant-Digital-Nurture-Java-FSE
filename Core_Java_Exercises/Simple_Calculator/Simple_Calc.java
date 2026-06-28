package Core_Java_Exercises.Simple_Calculator;

import java.util.Scanner;

public class Simple_Calc {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Choose an operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        if (operation == '+') {
            System.out.println("Result: " + (num1 + num2));
        } else if (operation == '-') {
            System.out.println("Result: " + (num1 - num2));
        } else if (operation == '*') {
            System.out.println("Result: " + (num1 * num2));
        } else if (operation == '/') {
            System.out.println("Result: " + (num1 / num2));
        } else {
            System.out.println("Invalid operation selected.");
        }

        scanner.close();
    }
}

    

