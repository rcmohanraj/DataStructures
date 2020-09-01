package com.rcmcode.algorithms.arrays;

public class DynamicArrayDemo {

    public static void main(String[] args) {
        CustomDynamicArray numbers = new CustomDynamicArray(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(0);
        numbers.print();
        System.out.println(numbers.indexof(30));
        numbers.print();
    }
}
