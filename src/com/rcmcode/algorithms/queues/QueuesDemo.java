package com.rcmcode.algorithms.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueuesDemo {

    public static void main(String[] args) {
//        queuesDemo();
//        customArrayQueuesDemo();
//        customStackQueueDemo();
        customPriorityQueue();
    }

    private static void customPriorityQueue() {
        CustomPriorityQueue queue = new CustomPriorityQueue();
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(5);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

    private static void customStackQueueDemo() {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue);
        int item = queue.dequeue();
        System.out.println(item);
        queue.enqueue(30);
        queue.enqueue(40);
        int item2 = queue.peek();
        System.out.println(item2);
        System.out.println(queue);
    }

    private static void customArrayQueuesDemo() {
        CustomArrayQueue queue = new CustomArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        int item = queue.dequeue();
        System.out.println(item);
        queue.enqueue(80);
        System.out.println(queue);
    }

    private static void queuesDemo() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        //System.out.println(queue.remove());
        //System.out.println(queue);
        QueueReverser.reverse(queue);
    }


}
