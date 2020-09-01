package com.rcmcode.algorithms.stacks;

import java.util.Arrays;

public class CustomStack {

    private int[] store;
    private int count;

    public CustomStack() {
        store = new int[5];
    }

    //push
    public void push(int item) {
        if(count == store.length) {
            throw new StackOverflowError();
        }
        store[count++] = item;
    }

    public int pop() {
        if(count == 0) {
            throw new IllegalStateException();
        }
        return store[--count];
    }

    public int peek() {
        if(count == 0) {
            throw new IllegalStateException();
        }
        return store[count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] range = Arrays.copyOfRange(store, 0, count);
        return Arrays.toString(range);

    }
}
