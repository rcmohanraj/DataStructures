package com.rcmcode.algorithms.nonlinear.binarytree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        customBinaryTreeDemo();
    }

    private static void customBinaryTreeDemo() {
        CustomeBinaryTree tree = new CustomeBinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        //System.out.println(tree);
        //System.out.println(tree.find(10));
        //tree.traversePreOrder();
        System.out.println(tree.minimum());
        //System.out.println(tree.minimumBinarySearchTree());

    }
}
