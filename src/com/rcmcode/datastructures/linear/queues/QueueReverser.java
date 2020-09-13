package com.rcmcode.datastructures.linear.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    /*Only use add remove isEmpty methods to reverse the input queue*/
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> result = new ArrayDeque<>();
        for(int item : queue)
            stack.push(item);

        while(!stack.empty())
            result.add(stack.pop());

        System.out.println(result);
    }
}
