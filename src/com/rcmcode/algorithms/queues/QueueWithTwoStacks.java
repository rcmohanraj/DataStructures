package com.rcmcode.algorithms.queues;

import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueWithTwoStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    //O(1)
    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    //O(1+n) => O(n)
    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return dequeueStack.pop();//O(1)
    }

    public int peek() {
        moveStack1ToStack2();
        return dequeueStack.peek();//O(1)
    }

    private void moveStack1ToStack2() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {    //O(n)
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    private boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    @Override
    public String toString() {
        System.out.println("Enqueue Stack:"+Arrays.toString(enqueueStack.toArray()));
        System.out.println("Dequeue Stack:"+Arrays.toString(dequeueStack.toArray()));
        return "";
    }
}
