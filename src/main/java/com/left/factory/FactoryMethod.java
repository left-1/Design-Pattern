package com.left.factory;

/**
 * 工厂方法模式
 */
public class FactoryMethod {

    public static void main(String[] args) {
        CreateProduct createProduct = new CreateProductB();
        Product product = createProduct.createProduct();
        product.method();
    }

}

interface CreateProduct {
    Product createProduct();
}

class CreateProductA implements CreateProduct {

    @Override
    public Product createProduct() {
        return new ProductA();
    }

}

class CreateProductB implements CreateProduct {

    @Override
    public Product createProduct() {
        return new ProductB();
    }

}
