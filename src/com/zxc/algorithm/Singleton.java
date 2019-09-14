package com.zxc.algorithm;

/**
 * 单例模式
 *
 * @author ZRM
 * @date 2019-08-23
 */
public class Singleton {

    private Singleton() {
    }

    /**
     * 饿汉
     */
    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    /**
     * 懒汉
     */
    private static Singleton singleton2;

    public static Singleton getSingleton2() {
        if (singleton2 == null) {
            synchronized (Singleton.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton();
                }
            }
        }
        return singleton2;
    }

    /**
     * 饿汉 + 懒汉
     */
    private static class SingletonInner{

        private static Singleton singleton = new Singleton();

    }

    public static Singleton getInstance3() {
        return SingletonInner.singleton;
    }
}
