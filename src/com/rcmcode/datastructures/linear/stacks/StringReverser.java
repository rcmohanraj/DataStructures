package com.rcmcode.datastructures.linear.stacks;

import java.util.Stack;

public class StringReverser {

    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }

    private static String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        /*for(int i = input.length(); i > 0; i--) {
            char c = input.charAt(i-1);
            stack.push(c);
        }*/

        if(input == null) throw new IllegalArgumentException();

        for(char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer output = new StringBuffer();
        while(!stack.empty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }
}
