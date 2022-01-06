package com.left.singleton;

/**
 * 懒汉式
 * 虽然达到按需初始化的目的，但有线程不安全的问题
 * 可以通过给 getInstance 方法加 synchronized 来解决，但效率会下降
 */
public class Lazy {

    private static Lazy INSTANCE;

    private Lazy() {}

    public synchronized static Lazy getInstance() {
        if (INSTANCE == null) {
            // 增加发生概率
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Lazy.getInstance().hashCode());
            }).start();
        }
    }

}
