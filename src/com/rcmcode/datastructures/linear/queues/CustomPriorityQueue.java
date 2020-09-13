package com.rcmcode.datastructures.linear.queues;

import java.util.Arrays;

public class CustomPriorityQueue {

    private int[] store;
    private int count;

    public CustomPriorityQueue() {
        store = new int[5];
    }

    public void enqueue(int item) {
        if(count == store.length) {
            throw new IllegalArgumentException();
        }
        if(count == 0) {
            store[count] = item;
        } else {
            for(int i = count-1; i >= 0; i--) {
                int current = store[i];
                if(current > item) {
                    store[i+1] = store[i];
                } else {
                    store[i+1] = item;
                    break;
                }
            }
        }
        count++;
    }

    public int dequeue() {
        if(count == 0) throw new IllegalStateException();
        return store[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(store);
    }
}
