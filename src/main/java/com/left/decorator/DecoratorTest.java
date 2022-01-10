package com.left.decorator;

/**
 * 装饰者模式
 * 在不改变原有对象的基础上，将功能附加到对象上
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Component component = new DecoratorComponent2(new DecoratorComponent(new ConcreteComponent()));
        component.operation();
    }

}

interface Component {
    void operation();
}
class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照");
    }

}
abstract class Decorator implements Component {
    Component component;
}
class DecoratorComponent extends Decorator {

    public DecoratorComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        component.operation();
    }

}
class DecoratorComponent2 extends Decorator {

    public DecoratorComponent2(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("滤镜");
        component.operation();
    }

}
