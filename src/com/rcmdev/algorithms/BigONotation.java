package com.rcmdev.algorithms;

import java.util.Arrays;

public class BigONotation {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 5, 10, 20, 50, 11, 21, 57, 789, 4654, 131,41,2};
        print(numbers);
    }

    private static void print(int[] numbers) {
        System.out.println(numbers[1]); // O(1)
        for (int first: numbers) //O(n)
            for(int second: numbers) //O(n)
                System.out.println(first + " " + second);
    }
}
