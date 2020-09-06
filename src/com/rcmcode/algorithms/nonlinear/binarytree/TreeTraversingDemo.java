package com.rcmcode.algorithms.nonlinear.binarytree;

public class TreeTraversingDemo {

    public static void main(String[] args) {
        getSourceBinaryTree();
    }

    private static void getSourceBinaryTree() {
        CustomeBinaryTree tree = new CustomeBinaryTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(14);
        tree.insert(3);
        tree.insert(8);
        tree.insert(24);
        tree.insert(26);
        tree.insert(1);
//        System.out.println(tree);
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traversePostOrder();
//        System.out.println(tree.height());
        System.out.println(tree.minimum());
    }

}
