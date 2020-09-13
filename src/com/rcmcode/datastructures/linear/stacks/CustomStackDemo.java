package com.rcmcode.datastructures.linear.stacks;

public class CustomStackDemo {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
//        stack.push(60);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}
