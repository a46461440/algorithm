package com.zxc.algorithm.linked;

/**
 * 单链表回文判断
 *
 * @author ZRM
 * @date 2019-09-09
 */
public class FeedBack {

    private Node head;

    private Node tail;

    private int size;

    private static class Node {

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        Integer data;

        Node next;
    }

    private void add(Integer data) {
        Node addNode = new Node(data, null);
        if (head == null) {
            head = addNode;
            tail = addNode;
        } else {
            tail.next = addNode;
            tail = addNode;
        }
        size++;
    }

    public Boolean isBack() {
        Node middleNode = getMiddle();
        Boolean odd = size % 2 == 0;
        if (odd) {
            if (!middleNode.data.equals(middleNode.next.data)) {
                return Boolean.FALSE;
            }
        }
        if (!odd) {
            reverse(middleNode);
        } else {
            reverse(middleNode.next);
        }
        Node p1 = this.head;
        Node p2 = middleNode.next;
        if (odd) {
            p2 = p2.next;
        }
        Boolean flag = Boolean.TRUE;
        while (!p1.data.equals(middleNode.data)) {
            if (p1.data.equals(p2.data)) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                flag = Boolean.FALSE;
                break;
            }
        }

        reverse(middleNode);
        return flag;
    }

    private Node getMiddle() {
        Node p1 = this.head;
        if (p1.next == null || p1.next.next == null) {
            return p1;
        }
        Node p2 = this.head.next.next;
        while (true) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null || p2.next == null) {
                return p1;
            }
            p2 = p2.next;
        }
    }

    public void reverse(Node node) {
        Node nextNode = node.next;
        if (nextNode != null) {
            node.next = reverseRecursive(nextNode);
        }
    }

    private Node reverseRecursive(Node node) {
        Node nextNode = node.next;
        if (nextNode != null) {
            Node okNode = reverseRecursive(nextNode);
            node.next = null;
            getLast(okNode).next = node;
            return okNode;
        } else {
            return node;
        }
    }

    private Node getLast(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

}
