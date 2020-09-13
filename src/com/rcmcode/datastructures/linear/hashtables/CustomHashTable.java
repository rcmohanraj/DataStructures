package com.rcmcode.datastructures.linear.hashtables;

import java.util.Arrays;
import java.util.LinkedList;

public class CustomHashTable {

    private LinkedList<KeyValuePair>[] store;
    private int count;
    private int size;

    public CustomHashTable(int size) {
        this.size = size;
        store = new LinkedList[size];
    }

    public void put(int key, String value) {
        KeyValuePair keyValuePair = new KeyValuePair(key, value);
        int newIndex = hash(key);
        LinkedList<KeyValuePair> bucket = store[newIndex];
        if(bucket != null) {
            int index = checkKeyPresentInBucket(key, bucket);
            if(index >= 0)
                bucket.remove(index);
            bucket.addLast(keyValuePair);
        } else {
            LinkedList<KeyValuePair> list = new LinkedList<>();
            list.add(keyValuePair);
            store[newIndex] = list;
        }
    }

    public String get(int key) {
        LinkedList<KeyValuePair> bucket = getBucket(key);
        if(bucket != null) {
            for(KeyValuePair pair : bucket) {
                if(pair.getKey() == key)
                    return pair.getValue();
            }
        }
        return null;
    }

    private LinkedList<KeyValuePair> getBucket(int key) {
        return store[hash(key)];
    }

    public void remove(int key) {
        LinkedList<KeyValuePair> bucket = getBucket(key);
        int index =  checkKeyPresentInBucket(key, bucket);
        if(index >= 0)
            bucket.remove(index);
        else
            throw new IllegalArgumentException();
    }

    private int checkKeyPresentInBucket(int key, LinkedList<KeyValuePair> bucket) {
        if(bucket != null) {
            for(int i = 0; i < bucket.size(); i++) {
                KeyValuePair pair = bucket.get(i);
                if(pair.getKey() == key) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int hash(int key) {
        return key % size;
    }

    @Override
    public String toString() {
        return Arrays.toString(store);
    }

    private class KeyValuePair {
        private int key;
        private String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Key="+key + " Value="+value;
        }
    }
}
