package com.left.singleton;

/**
 * 静态内部类式
 * 由 JVM 保证单例
 * 加载外部类不会加载内部类，可以实现懒加载
 */
public class StaticInnerClass {

    private StaticInnerClass() {}

    private static class StaticInnerClassHolder {
        private static StaticInnerClass INSTANCE = new StaticInnerClass();

    }

    public static StaticInnerClass getInstance() {
        return StaticInnerClassHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(StaticInnerClass.getInstance().hashCode());
            }).start();
        }
    }

}
