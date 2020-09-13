package com.rcmcode.datastructures.linear.arrays;

public class CustomDynamicArray {

    private int actualSize;
    private int[] result;

    public CustomDynamicArray(int size) {
        result = new int[size];
    }

    public void insert(int value) {
        if(result.length == actualSize) {
            int[] newResult = new int[actualSize*2];
            for(int i = 0; i < actualSize; i++) {
                newResult[i] = result[i];
            }
            result = newResult;
        }
        result[actualSize++] = value;
    }

    public void print() {
        for(int i = 0; i < actualSize; i++) {
            System.out.println(result[i]);
        }
    }

    public void removeAt(int index) {
        if(index < 0 || index >= actualSize)
            throw new IllegalArgumentException();

        for(int i = index; i < actualSize; i++) {
            result[i] = result[i+1];
        }
        actualSize--;
    }

    //Runtime Complexity
    //Best Case O(1)    => if the item is at first, so it will run in constant time
    //Worst Case O(n)   => if the item is at last, so it will run in linear time
    public int indexof(int item) {
        for(int i = 0; i < actualSize; i++) {
            if(result[i] == item) return i;
        }
        return -1;
    }

}
