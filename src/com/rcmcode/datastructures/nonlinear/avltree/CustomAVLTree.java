package com.rcmcode.datastructures.nonlinear.avltree;

public class CustomAVLTree {

    private AVLNode root;

    public void insert(int value) {
        if(root == null)
            root = new AVLNode(value);
        else
            insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if(root == null) return new AVLNode(value);
        if(value < root.value)
            root.left = insert(root.left, value);
        else if(value > root.value) {
            root.right = insert(root.right, value);
        }

        setHeight(root);
        root = balance(root);
        return root;
    }

    /*
    * Case 1 (Right Heavy)
    * 10
    *   20  (left 0 and right 1 so diff = -1)
    *     30
    *
    * leftRotate(10)
    *    20
    * 10    30
    *
    *
    * Case 2 (Left Heavy)
    * 10
    *   30  (left 1 and right 0 so diff = 1) balanceFactor(root.right) > 0 means we should apply right and left rotate
    * 20
    *
    * rightRotate(30)
    * 10
    *   20
    *     30
    *
    * leftRotate(10)
    *    20
    * 10    30
    *
    * */

    private AVLNode balance(AVLNode root) {
        if(isLeftHeavy(root)) {
            System.out.println("Left Heavy:"+root.value);
            if(balanceFactor(root.left) < 0) {
                System.out.println("Left Rotate:"+root.left.value);
                root.left = rotateLeft(root.left);
            }
            System.out.println("Right Rotate:"+root.value);
            return rotateRight(root);
        } else if(isRightHeavy(root)) {
            System.out.println("Right Heavy:"+root.value);
            if(balanceFactor(root.right) > 0) {
                System.out.println("Right Rotate:"+root.right.value);
                root.right= rotateRight(root.right);
            }
            System.out.println("Left Rotate:"+root.value);
            return rotateLeft(root);
        }
        return root;
    }

    /*
    left height = 3,
    right height = 1
    then 3-1 = 2 so the node is left side heavy
    */
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    /*
    left height = 1,
    right height = 3
    then 1-3 = -2 so the node is right side heavy
    */
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }


    private class AVLNode {
        private int value;
        private int height;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value:"+this.value;
        }
    }
}
