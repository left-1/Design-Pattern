package com.left.singleton;

/**
 * 枚举式
 * 不仅通过 JVM 解决线程同步问题，还可以防止反射
 */
public enum ByEnum {

    INSTANCE;

}
