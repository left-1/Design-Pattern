package com.left.adapter;

/**
 * 适配器模式-对象
 * 将一个类的接口转换成希望的一个接口，使原本由于接口不兼容而不能一起工作的类可以工作
 */
public class ByObject {

    public static void main(String[] args) {
        ObjectAdaptee adaptee = new ObjectAdaptee();
        ObjectAdapter adapter = new ObjectAdapter(adaptee);
        adapter.output5();
    }

}

class ObjectAdaptee {
    public int output220() {
        return 220;
    }
}
interface ObjectTarger {
    int output5();
}
class ObjectAdapter implements ObjectTarger {

    private ObjectAdaptee adaptee;

    public ObjectAdapter(ObjectAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5() {
        int output220 = adaptee.output220();
        System.out.println(String.format("原始电压：%dV -> 输出电压：%dV", output220, 5));
        return 5;
    }
}
