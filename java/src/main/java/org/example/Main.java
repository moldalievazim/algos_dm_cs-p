package org.example;

import java.util.HashMap;

import java.util.HashMap;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    static HashMap<Integer, Long> cache = new HashMap<Integer, Long>();

    static long fibonacci(int n) {
        if(n<=1){
            return n;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long fib = fibonacci(n - 1) + fibonacci(n - 2);
            cache.put(n, fib);
            return fib;
        }
    }

    public static void main(String[] args) {

        System.out.printf("Hello and welcome!\n");

        for (int i = 0; i<= 100; i++) {
            long fib = fibonacci(i);

            System.out.println("Fib i = " + i + " = " + fib);
        }
    }
}