package com.rcmcode.datastructures.linear.hashtables;

import java.util.HashMap;
import java.util.Map;

public class HashTableDemo {

    public static void main(String[] args) {
        //hashMapDemo();
        //System.out.println(hash("1253456")); //62
        //System.out.println(hash(1253456));  //56
        customHashTableDemo();
    }

    private static void customHashTableDemo() {
        CustomHashTable hashTable = new CustomHashTable(5);
        hashTable.put(1, "A");
        hashTable.put(1, "B");
        hashTable.put(2, "D");
        hashTable.put(11, "C");
        hashTable.put(12, "F");
        hashTable.remove(60);
        System.out.println(hashTable);
        System.out.println(hashTable.get(10));
    }


    private static void hashMapDemo() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "AAA");
        map.put(2, "BBB");
        map.put(3, "CCC");
        map.put(null, "DDD");
        map.remove(null);
        String value = map.get(3);
        System.out.println(value);
        System.out.println(map);
        System.out.println(map.containsKey(1)); //O(1)
        System.out.println(map.containsValue("AAA"));   //O(n)
        for(int key : map.keySet()) {
            System.out.println(key);
        }

        for(Map.Entry<Integer, String> key : map.entrySet()) {
            System.out.println(key.getKey());
            System.out.println(key.getValue());
        }
    }

    //To generate hash value between 0-99 (Array Indexes)
    private static int hash(String key) {
        int hash = 0;
        for(Character ch : key.toCharArray()) {
            hash += ch;
        }
        return hash % 100;
    }

    private static int hash(Integer key) {
        return key % 100;
    }
}
