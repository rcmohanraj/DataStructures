package com.rcmcode.algorithms.linkedlist;

import java.util.NoSuchElementException;

public class CustomLinkedList {

    private Node first;
    private Node last;
    private int nodeCount;

    //addFirst
    public void addFirst(int item) {
        Node newNode = new Node(item);
        if(first == null)
            first = last = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        nodeCount++;
    }

    //addLast
    public void addLast(int item) {
        Node newNode = new Node(item);
        if(first == null)
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        nodeCount++;
    }
    //deleteFirst
    public void deleteFirst() {
        if(first == null)
            throw new NoSuchElementException();

        if(first == last) {
            first = last = null;
        } else {
            Node secondNode = first.next;
            first.next = null;
            first = secondNode;
        }
        nodeCount--;
    }

    //deleteLast
    public void deleteLast() {
        if(first == null)
            throw new NoSuchElementException();

        if(first == last) {
            first = last = null;
        } else {
            Node previousNode = getPreviousNode(last);
            last = previousNode;
            last.next = null;
        }
        nodeCount--;
    }

    //indexOf
    public int indexOf(int value) {
        Node current = first;
        int i = 0;
        while(current != null) {
            if(current.value == value) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    //contains
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return nodeCount;
    }

    public int[] toArray() {
        int[] array = new int[nodeCount];
        int i = 0;
        Node current = first;
        while(current != null) {
            array[i++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if(first == null) return;
        Node previousNode = first;//10
        Node currentNode = previousNode.next;//20
        while(currentNode != null) { //20 30
            Node nextNode = currentNode.next;//30 null
            currentNode.next = previousNode;//20->10 30->20
            previousNode = currentNode;//20 30
            currentNode = nextNode;//30 null
        }
        last = first;
        last.next = null;
        first = previousNode;
    }

    /*
    * Find the Kth node from the end in one pass
    * if the one pass is not present we can simply traversePreOrder the list and
    * find the size and then traversePreOrder the desired Kth node by traversing again
    * One pass means we shouldn't traversePreOrder the list again.
    * */

    public int getKthNodeFromTheEnd(int k) {
        if(first == null) {
            throw new IllegalStateException();
        }
        int distance = k-1;
        Node current = first;
        Node second = getSecondPointer(distance);
        System.out.println("Initial Current =>"+current.value);
        System.out.println("Initial Second =>"+second.value);
        while(second != last) {
            current = current.next;
            second = second.next;
            System.out.println("Loop Current =>"+current.value);
            System.out.println("Loop Second =>"+second.value);
        }
        return current.value;
    }

//    void printNthFromLast(int n)
//    {
//        int len = 0;
//        Node temp = first;
//
//        // 1) count the number of nodes in Linked List
//        while (temp != null) {
//            temp = temp.next;
//            len++;
//        }
//        // check if value of n is not more than length of
//        // the linked list
//        if (len < n)
//            return;
//
//        temp = first;
//
//        // 2) get the (len-n+1)th node from the beginning
//        System.out.println("length:"+len);
//        System.out.println("n:"+n);
//        System.out.println("loop limit:"+(len - n + 1));
//        for (int i = 1; i < len - 1; i++) {
//            System.out.println("loop:"+i);
//            temp = temp.next;
//        }
//
//        System.out.println(temp.value);
//    }

//    public int getLastNode(int n) {
//        Node fast = first;
//        Node slow = first;
//        int start = 1;
//        while (fast.next != null) {
//            fast = fast.next;
//            start++;
//            if (start > n) {
//                slow = slow.next;
//            }
//        }
//        return slow.value;
//    }

    private Node getSecondPointer(int distance) {
        Node current = first;
        while(distance > 0) {
            distance--;
            current = current.next;
            if(current == null) {
                throw new IllegalArgumentException();
            }
        }
        return current;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while(current != null) {
            if(current.next == node) return current;
            else {
                current = current.next;
            }
        }
        return null;
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
