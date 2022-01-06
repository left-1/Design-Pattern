package com.left.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个实例，由 JVM 保证线程安全
 * 缺点是不管有没有用到，都会实例化对象
 */
public class Hunger {

    private static final Hunger INSTANCE = new Hunger();

    private Hunger() {}

    public static Hunger getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Hunger instance1 = Hunger.getInstance();
        Hunger instance2 = Hunger.getInstance();
        System.out.println(instance1 == instance2);
    }

}
