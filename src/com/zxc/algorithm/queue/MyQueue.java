package com.zxc.algorithm.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环阻塞并发队列
 *
 * @author ZRM
 * @date 2019-09-10
 */
public class MyQueue {

    private int headIndex;

    private int tailIndex;

    private int capacity;

    private int currentSize;

    private int[] elements;

    private Lock lock = new ReentrantLock(false);

    private Condition addCondition = lock.newCondition();

    private Condition dequeueCondition = lock.newCondition();

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    private boolean isEmpty() {
        return this.currentSize == 0;
    }

    private boolean isFull() {
        return this.currentSize == this.capacity;
    }

    private boolean add(int element) throws InterruptedException {
        this.lock.lock();
        try {
            while (this.isFull()) this.addCondition.await();
            elements[this.tailIndex] = element;
            this.tailIndex = (this.tailIndex + 1) % this.capacity;
            this.currentSize++;
            this.dequeueCondition.signal();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    /**
     * 阻塞队列出队操作
     *
     * @return 出队元素
     * @throws InterruptedException
     */
    private Integer dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (this.isEmpty()) this.dequeueCondition.await();
            int result = this.elements[this.headIndex];
            this.elements[this.headIndex] = 0;
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.currentSize--;
            this.addCondition.signal();
            return result;
        } finally {
            this.lock.unlock();
        }
    }

    public Integer parallelDequeue() {
        AtomicInteger atomicInteger = new AtomicInteger(this.headIndex);
        while (true) {
            int result = this.elements[this.headIndex];
            if (atomicInteger.compareAndSet(this.headIndex, (this.headIndex + 1) % this.capacity)) {
                this.headIndex = (this.headIndex + 1) % this.capacity;
                this.currentSize--;
                return result;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyQueue myQueue = new MyQueue(2);
        myQueue.add(2);
        myQueue.add(4);
        new Thread(() -> {
            try {
                System.out.println("休眠2秒");
                Thread.sleep(2000);
                System.out.println("休眠完毕");
                System.out.println(myQueue.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("要阻塞了");
        myQueue.add(3);
        System.out.println("阻塞完毕");
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
    }
}
