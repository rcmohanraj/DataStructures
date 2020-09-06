package com.rcmcode.algorithms.nonlinear.binarytree;

public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(factorialByIterating(5));
        System.out.println(factorialByRecursion(5));
    }

    private static int factorialByIterating(int n) {
        int factorial = 1;
        for(int i = n; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    private static int factorialByRecursion(int n) {
        if(n == 1) {
            return n;
        } else {
            return n * factorialByRecursion(n-1);
        }
    }
}
