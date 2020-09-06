package com.rcmcode.algorithms.nonlinear.binarytree;

public class CustomeBinaryTree {

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if(root == null) {
            root = node;
        } else {
            Node current = root;
            while(current != null) {
                if(value < current.value) {
                    if(current.left == null) {
                        current.left = node;
                        break;
                    }
                    current = current.left;
                } else {
                    if(current.right == null) {
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while(current != null) {
            if(value < current.value) {
                current = current.left;
            } else if(value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        System.out.println("Pre-Order Starts");
        traversePreOrder(root);
        System.out.println("Pre-Order Ends");
    }

    public void traverseInOrder() {
        System.out.println("In-Order Starts");
        traverseInOrder(root);
        System.out.println("In-Order Ends");
    }

    public void traversePostOrder() {
        System.out.println("Post-Order Starts");
        traversePostOrder(root);
        System.out.println("Post-Order Ends");
    }

    public int height() {
        return height(root);
    }

    public int minimum() {
        return min(root);
    }

    //Complexity is O(log n) as we are traversing only left child
    public int minimumBinarySearchTree() {
        if(root == null) throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while(current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    private int height(Node root) {
        if(root == null) return -1;
        if(isLeaf(root)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //Complexity is O(n) as we are traversing entire left and right child
    private int min(Node root) {
        boolean leaf = isLeaf(root);
        if(leaf) return root.value;
        if(root.left == null) {
            return root.value;
        }
        int leftMin = min(root.left);
        if(root.right == null) {
            return leftMin;
        }
        int rightMin = min(root.right);
        return Math.min(Math.min(leftMin, rightMin), root.value);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    //Root Left Right
    private void traversePreOrder(Node root) {
        if(root == null) return;
        System.out.print(root.getValue()+ ",");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    //Left Root Right
    private void traverseInOrder(Node root) {
        if(root == null) return;
        traverseInOrder(root.left);
        System.out.print(root.getValue()+ ",");
        traverseInOrder(root.right);
    }

    //Left Right Root
    private void traversePostOrder(Node root) {
        if(root == null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.getValue()+ ",");
    }

    @Override
    public String toString() {
        return "root="+root;
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[Value="+value + ",{ left="+left + ", right="+right+"]}";
            //return "[Value="+value+"]";
        }
    }

}
