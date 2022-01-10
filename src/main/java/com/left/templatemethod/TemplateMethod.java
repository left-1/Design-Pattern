package com.left.templatemethod;

/**
 * 模板方法模式
 * 定义一个操作的算法骨架，而将一些步骤延迟到子类中
 */
public class TemplateMethod {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.operation();
        NewSubClass newSubClass = new NewSubClass();
        newSubClass.operation();
    }

}

abstract class AbstractClass {
    public void operation() {
        // 算法骨架用打印日志代替
        System.out.println("Pre");
        templateMethod1();
        System.out.println("First method has finished");
        templateMethod2();
        System.out.println("Second method has finished");
    }

    abstract void templateMethod1();
    abstract void templateMethod2();
}
class SubClass extends AbstractClass {

    @Override
    void templateMethod1() {
        System.out.println("subclass template method");
    }

    @Override
    void templateMethod2() {
        System.out.println("subclass template method");
    }
}
class NewSubClass extends AbstractClass {

    @Override
    void templateMethod1() {
        System.out.println("new subclass template method");
    }

    @Override
    void templateMethod2() {
        System.out.println("new subclass template method");
    }
}