package com.growthhungry;

import java.util.Scanner;

public class FibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Check if n is valid
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            long fibonacciNumber = computeFibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacciNumber);
        }

        scanner.close();
    }

    // Function to compute the nth Fibonacci number
    public static long computeFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        long previous = 1, current = 1, next = 0;

        for (int i = 3; i <= n; i++) {
            next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }
}
