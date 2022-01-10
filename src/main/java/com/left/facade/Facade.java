package com.left.facade;

/**
 * 门面（外观）模式
 * 为子系统中的一组接口提供一个一致的接口
 */
public class Facade {

    public static void main(String[] args) {
        Client1 client1 = new Client1();
        Client2 client2 = new Client2();
        client1.doSomething1();
        // 使用了外观模式
        client2.doSomething2();
    }

    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();

    public void doSomething() {
        subSystem1.method1();
        subSystem2.method2();
    }

}

class Client1 {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();

    public void doSomething1() {
        subSystem1.method1();
        subSystem2.method2();
    }
}

class Client2 {
    Facade facade = new Facade();

    public void doSomething2() {
        facade.doSomething();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("subSystem1.method1 executed.");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("subSystem2.method2 executed.");
    }
}