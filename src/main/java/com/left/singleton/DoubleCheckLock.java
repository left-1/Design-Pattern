package com.left.singleton;

/**
 * 双重检查式，两次判断和加锁
 * 少了 volatile 小概率会有问题
 */
public class DoubleCheckLock {

    // 防止对象初始化指令重排序造成的异常
    private volatile static DoubleCheckLock INSTANCE;

    private DoubleCheckLock() {}

    public static DoubleCheckLock getInstance() {
        // 减少加锁
        if (INSTANCE == null) {
            synchronized (DoubleCheckLock.class) {
                // 防止线程切换导致单例失败
                if (INSTANCE == null) {
                    // 增加发生概率
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(DoubleCheckLock.getInstance().hashCode());
            }).start();
        }
    }

}
