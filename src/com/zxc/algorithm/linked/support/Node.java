package com.zxc.algorithm.linked.support;

/**
 * 单链表节点
 *
 * @author ZRM
 * @date 2019-09-09
 */
public class Node {

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int data;

    public Node next;
}
