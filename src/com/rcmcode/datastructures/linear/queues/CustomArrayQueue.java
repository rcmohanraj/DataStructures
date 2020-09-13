package com.rcmcode.datastructures.linear.queues;

import java.util.Arrays;

public class CustomArrayQueue {

    private int[] store;
    private int front;
    private int rear;
    private int count;


    public CustomArrayQueue() {
        store = new int[5];
    }

    public void enqueue(int item) {
        if(count == store.length) throw new IllegalStateException();
        store[rear] = item;
        rear = (rear+1)%store.length;
        count++;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();
        int item = store[front];
        store[front] = 0;
        front = (front+1)%store.length;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(store);
    }
}
