package com.rcmcode.datastructures.linear.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        //demoJavaLinkedList();
        demoCustomLinkedList();
    }

    private static void demoJavaLinkedList() {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println(list);
        System.out.println("Does list contains 20:"+list.contains(20));
        System.out.println("What is the index of 10:"+list.indexOf(10));
        System.out.println("Size of the list:"+list.size());
        System.out.println("List to Array:"+Arrays.toString(list.toArray()));
    }

    private static void demoCustomLinkedList() {
        CustomLinkedList list = new CustomLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(11);
        list.addFirst(21);
        list.addFirst(31);
        list.addFirst(41);
        list.addFirst(51);
        list.addFirst(61);
        System.out.println(list);
        int kthValue = list.getKthNodeFromTheEnd(6);
        System.out.println(kthValue);
        list.deleteLast();
        System.out.println(list.size());
        list.deleteFirst();
        System.out.println(list.size());
        System.out.println(list.indexOf(21));
        System.out.println(list.contains(30));
        System.out.println(list.contains(21));
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));


    }


}
