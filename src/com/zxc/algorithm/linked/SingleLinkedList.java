package com.zxc.algorithm.linked;

import com.zxc.algorithm.linked.support.Node;

/**
 * 单链表
 *
 * @author ZRM
 * @date 2019-08-23
 */
public class SingleLinkedList {

    private Node first;

    private Node tail;

    public void add(int data) {
        Node addNode = new Node(data, null);
        if (first == null) {
            first = addNode;
            tail = addNode;
        } else {
            if (first == tail) {
                tail = addNode;
                first.next = tail;
            } else {
                tail.next = addNode;
                tail = addNode;
            }
        }
    }

    public void reverse() {
        if (first == tail) {
            return;
        } else {
            reverseRecursive(first);
        }
    }

    /**
     * 反转单链表
     * 时间复杂度 O(n)
     *
     * @param node 反转链表的头部
     */
    private void reverseRecursive(Node node) {
        if (node.next == null) {
            first = node;
            return;
        } else {
            reverseRecursive(node.next);
            node.next.next = node;
            tail = node;
        }
        tail.next = null;
    }

    /**
     * 获取尾节点
     * 时间复杂度 O(n)
     *
     * @return 尾节点
     */
    private Node getTail() {
        Node node = first;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public Boolean isCurcle() {
        return this.getMeetNode() != null;
    }

    /**
     * 链表求环相遇节点
     * 最差时间复杂度O(n)
     *
     * @return 相遇节点
     */
    private Node getMeetNode() {
        if (first == null || first == tail) {
            return null;
        }
        Node p1 = first;
        Node p2 = first.next;
        if (p2.next != null) {
            p2 = p2.next;
        } else {
            return null;
        }
        while (p2 != null && p2.next != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                break;
            }
        }
        return null;
    }

    /**
     * 查询环入口节点
     * 最差时间复杂度 O(n)
     *
     * @return 环入口节点
     */
    public Node getStart() {
        Node meetNode = this.getMeetNode();
        if (meetNode != null) {
            Node p1 = first;
            Node p2 = meetNode;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
        return null;
    }

    /**
     * 删除倒数第{@code index}个节点
     * 时间复杂度 O(n)
     *
     * @param index 倒数第index个节点
     */
    public void remove(int index) {
        Node p1 = this.first;
        Node p2 = this.first;
        Node p2Pre = p2;
        int p1MoveIndex = 0;
        while (p1.next != null) {
            p1 = p1.next;
            p1MoveIndex ++;
            if (p1MoveIndex >= index) {
                p2Pre = p2;
                p2 = p2.next;
            }
        }
        p2Pre.next = p2.next;
        p2.next = null;
    }

    /**
     * 合并有序链表
     * 时间复杂度 O(m + n)
     *
     * @param node 待合并链表的头节点
     */
    public void mergeSortedNodeList(Node node) {
        Node localNode = this.first;
        Node nowNode;
        if (localNode.data > node.data) {
            nowNode = node;
            node = node.next;
        } else {
            nowNode = localNode;
            localNode = localNode.next;
        }
        this.first = nowNode;
        while (localNode != null || node != null) {
            if (localNode == null) {
                nowNode.next = node;
                node = node.next;
            } else if (node == null) {
                nowNode.next = localNode;
                localNode = localNode.next;
            } else {
                if (localNode.data > node.data) {
                    nowNode.next = node;
                    node = node.next;
                } else {
                    nowNode.next = localNode;
                    localNode = localNode.next;
                }
            }
            nowNode = nowNode.next;
        }
        this.tail = this.getTail();
    }

    private void sort() {
        this.sort(first, tail);
    }

    private void sort2() {
        this.sort2(first, tail);
    }

    private void sort(Node one, Node last) {
        if (one == last) {
            return;
        }
        Node p1 = one;
        Node p2 = p1.next;
        while (p2 != last) {
            if (p2.data < one.data) {
                p1 = p1.next;
                exchange(p1, p2);
            }
            p2 = p2.next;
        }
        if (last.data < p1.next.data) {
            exchange(last, p1.next);
            p1 = p1.next;
        }
        if (p1.data < one.data) {
            exchange(p1, one);
        }
        sort(one, p1);
        sort(p1.next, last);
    }

    private void sort2(Node one, Node last) {
        if (one == last || one.next.data == last.data) {
            return;
        }
        Node p1 = one;
        Node p2 = one;
        Node p3 = one.next;
        while (p3 != last) {
            if (p3.data < one.data) {
                p1 = p1.next;
                p2 = p2.next;
                exchange(p3, p1);
            } else if (p3.data == one.data) {
                p2 = p2.next;
                exchange(p2, p3);
            }
            p3 = p3.next;
        }
        if (p3.data < one.data) {
            exchange(p3, p1);
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.data > one.data) {
            exchange(p1, one);
        }
        sort2(one, p1);
        sort2(p2.next, last);
    }

    private void exchange(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(7);
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(8);
        list2.add(10);
        list.mergeSortedNodeList(list2.first);
        list.remove(2);
        System.out.println(list);
    }

}
