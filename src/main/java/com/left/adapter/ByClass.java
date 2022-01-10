package com.left.adapter;

/**
 * 适配器模式-类
 */
public class ByClass {

    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.output5();
    }

}

class ClassAdaptee {
    public int output220() {
        return 220;
    }
}
interface ClassTarger {
    int output5();
}
class ClassAdapter extends ClassAdaptee implements ObjectTarger {

    @Override
    public int output5() {
        int output220 = output220();
        System.out.println(String.format("原始电压：%dV -> 输出电压：%dV", output220, 5));
        return 5;
    }
}