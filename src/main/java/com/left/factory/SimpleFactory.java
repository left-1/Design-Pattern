package com.left.factory;

/**
 * 简单工厂模式（不是设计模式）
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Product product = getProduct(0);
        product.method();
    }

    /**
     * 根据参数创建不同的产品
     * @param type
     * @return
     */
    public static Product createProduct(Integer type) {
        if (type == 0) {
            return new ProductA();
        } else if (type == 1) {
            return new ProductB();
        } else {
            return null;
        }
    }

    public static Product getProduct(Integer type) {
        Product product = createProduct(type);
        return product;
    }

}

class ProductA implements Product {

    public void method() {
        System.out.println("productA method");
    }

}

class ProductB implements Product {

    public void method() {
        System.out.println("productB method");
    }

}
