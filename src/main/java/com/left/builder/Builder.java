package com.left.builder;

/**
 * 建造者模式
 * 将一个复杂对象的创建与他的表示分离，使得同样的构建过程可以创建不同的表示
 */
public class Builder {

    public static void main(String[] args) {
//        Product product = new Product();
//        product.setProductName("p");
//        product.setCompanyName("c");
//        product.setPart1("p1");
//        product.setPart2("p2");
        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Direct direct = new Direct(defaultConcreteProductBuilder);
        Product product = direct.makeProduct("p", "c", "p1", "p2");
        System.out.println(product);
    }

}

interface ProductBuilder {
    void builderProductName(String productName);
    void builderCompanyName(String companyName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    Product builder();
}

class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public Product builder() {
        System.out.println("default builder");
        return new Product(this.productName, this.companyName, this.part1, this.part2);
    }
}
class Direct {

    private ProductBuilder builder;

    public Direct(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2) {
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPart1(part1);
        builder.builderPart2(part2);

        Product product = this.builder.builder();
        return product;
    }

}

class Product {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;

    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }

}
