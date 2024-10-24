package com.growthhungry;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number to check if it's a palindrome: ");
        int number = scanner.nextInt();

        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }

        public static boolean isPalindrome(int num){
            int originalNum = num;
            int reversedNum = 0;

            while (num != 0){
                int digit = num % 10;
                reversedNum = reversedNum * 10 + digit;
                num = num/10;
            }

            return originalNum == reversedNum;
        }
}

