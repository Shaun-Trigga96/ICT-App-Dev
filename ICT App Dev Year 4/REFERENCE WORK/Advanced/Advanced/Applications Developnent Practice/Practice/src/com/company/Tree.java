package com.company;

public class Tree {
    private static class Node {
        private int value;
        private Node lChild;
        private Node rChild;
        public Node( int v, Node l, Node r) {
            value = v;
            lChild = l;
            rChild = r;
        }
        public Node( int v ) {
            value = v;
            lChild = null;
            rChild = null;
        }
    }
    private Node root;
    public Tree() {
        root = null;
    }

}
