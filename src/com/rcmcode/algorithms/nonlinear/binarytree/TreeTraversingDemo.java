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

        /*add this for making the Binary Search Tree as Binary Tree to verify
        isBinarySearchTree working correctly*/
        //tree.swapRoot();
        System.out.println(tree.isBinarySearchTree());
        //tree.nodesAtKdistance(2);
        tree.traverseLevelOrder();

        /*CustomeBinaryTree tree2 = new CustomeBinaryTree();
        tree2.insert(20);
        tree2.insert(10);
        tree2.insert(30);
        tree2.insert(14);
        tree2.insert(3);
        tree2.insert(8);
        tree2.insert(24);
        tree2.insert(6);
        tree2.insert(26);
        tree2.insert(1);
        System.out.println(tree.equals(tree2));
        */
//        System.out.println(tree);
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traversePostOrder();
//        System.out.println(tree.height());
        //System.out.println(tree2.minimum());
    }

}
