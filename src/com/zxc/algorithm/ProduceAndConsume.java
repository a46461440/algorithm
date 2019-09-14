package com.zxc.algorithm;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产消费者
 *
 * @author ZRM
 * @date 2019-08-23
 */
public class ProduceAndConsume {

    private Integer size;

    private AtomicInteger currentSize = new AtomicInteger(0);

    private LinkedList linkedList = new LinkedList();

    private Object object = new Object();

    private Lock lock = new ReentrantLock();

    private Condition putCondition = lock.newCondition();

    private Condition getCondition = lock.newCondition();

    public ProduceAndConsume(Integer size) {
        this.size = size;
    }

    public void put(Object o) throws InterruptedException {
        synchronized (this.object) {
            while (isFull()) {
                this.object.wait();
            }
            this.currentSize.incrementAndGet();
            linkedList.add(o);
            this.object.notifyAll();
        }
    }

    public void putWithCondition(Object o) throws InterruptedException {
        this.lock.lock();
        try {
            while (isFull()) {
                this.putCondition.await();;
            }
            this.linkedList.add(o);
            this.currentSize.incrementAndGet();
            this.getCondition.await();
        } finally {
            this.lock.unlock();
        }
    }

    public Object poll() throws InterruptedException {
        synchronized (this.object) {
            while (isEmpty()) {
                this.object.wait();
            }
            this.currentSize.decrementAndGet();
            this.object.notifyAll();
            return linkedList.pollFirst();
        }
    }

    public Object pollWithCondition() throws InterruptedException {
        this.lock.lock();
        try {
            while (this.isEmpty()) {
                this.getCondition.await();
            }
            this.putCondition.signal();
            this.currentSize.decrementAndGet();
            return this.linkedList.pollFirst();
        } finally {
            this.lock.unlock();
        }
    }

    private Boolean isFull() {
        return this.currentSize.get() >= this.size;
    }

    private Boolean isEmpty() {
        return this.currentSize.get() == 0;
    }

}
