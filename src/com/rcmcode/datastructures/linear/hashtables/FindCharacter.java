package com.rcmcode.datastructures.linear.hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindCharacter {

    public static void main(String[] args) {
        String value = "a green apple";
        System.out.println("findFirstNonRepeatableCharacter Ans:"+findFirstNonRepeatableCharacter(value));
        System.out.println("findFirstRepeatableCharacter Ans:"+ findFirstRepeatableCharacter(value));
    }

    private static Character findFirstNonRepeatableCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = input.toCharArray();
        for(char key : chars) {
            if(!isEmpty(key)) {
                int count = map.containsKey(key) ? map.get(key) : 0;
                map.put(key, count + 1);
            }
        }

        System.out.println(map);

        for(char key : chars) {
            if(!isEmpty(key) && map.get(key) == 1) {
                return key;
            }
        }
        return Character.MIN_VALUE;
    }

    public static Character findFirstRepeatableCharacter(String input) {
        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();
        for(char key : chars) {
            if(set.contains(key)) return key;
            set.add(key);
        }
        return Character.MIN_VALUE;
    }

    private static boolean isEmpty(Character value) {
        return value == ' ';
    }
}
