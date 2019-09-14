package com.zxc.algorithm;

/**
 * 平衡二叉树实现
 *
 * @author ZRM
 * @date 2019-08-22
 */
public class BalancedBinaryTree<T extends Comparable> {

    private static final Node NON_NODE = null;

    private static class Node<T extends Comparable> {

        public Node(T data, Node left, Node right, Node parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        T data;
        Node left;
        Node right;
        Node parent;
    }

    private Node root;

    public void add(T data) {
        if (root == null) {
            root = new Node(data, NON_NODE, NON_NODE, NON_NODE);
        } else {
            this.add(root, data);
        }
    }

    private void add(Node node, T data) {
        int compareResult = node.data.compareTo(data);
        Node addNode = new Node(data, NON_NODE, NON_NODE, NON_NODE);
        if (node.left == NON_NODE) {
            node.left = addNode;
            addNode.parent = node;
            if (compareResult < 0) {
                this.exchange(node, addNode);
            }
        } else if (node.left != NON_NODE && node.right == NON_NODE) {
            node.right = addNode;
            addNode.parent = node;
            if (compareResult > 0) {
                this.exchange(node, node.right);
                compareResult = node.left.data.compareTo(data);
                if (compareResult > 0) {
                    this.exchange(node, node.left);
                }
            }
        } else {
            if (node.left.data.compareTo(data) > 0) {
                this.add(node.left, data);
            } else if (node.right.data.compareTo(data) < 0) {
                this.add(node.right, data);
            } else if (node.left.data.compareTo(data) < 0 && node.data.compareTo(data) > 0) {
                if (node.left.right == NON_NODE) {
                    node.left.right = addNode;
                    addNode.parent = node.left;
                } else {

                }
            }
        }
    }

    private void exchange(Node<T> node1, Node<T> node2) {
        T data = node1.data;
        node1.data = node2.data;
        node2.data = data;
    }

    private void roll(Node node) {
        Node parent = node.parent;
        if (parent == NON_NODE) {
            return;
        } else {
            Node grandParent = parent.parent;
            if (parent.left.data.compareTo(node.data) == 0) {

            }
        }
    }

}
