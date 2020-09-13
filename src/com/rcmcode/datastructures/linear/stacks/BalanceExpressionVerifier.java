package com.rcmcode.datastructures.linear.stacks;

import java.util.List;
import java.util.Stack;

public class BalanceExpressionVerifier {

    private static final List<Character> OPEN_BRACKETS = List.of('(', '[', '{', '<');
    private static final List<Character> CLOSE_BRACKETS = List.of(')', ']', '}', '>');

    public static void main(String[] args) {
        String input = "{(1+2)}]";
        System.out.println(checkBalance(input));
    }

    private static boolean checkBalance(String input) {
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) {
            if(OPEN_BRACKETS.contains(ch)) {
                stack.push(ch);
            }
            if(CLOSE_BRACKETS.contains(ch)) {
                if(stack.empty()) return false;

                char top = stack.pop();
                if(!isBracketsMatched(top, ch)) return false;
            }
        }
        return stack.empty();
    }

    private static boolean isBracketsMatched(char open, char close) {
        return OPEN_BRACKETS.indexOf(open) == CLOSE_BRACKETS.indexOf(close);
    }
}
