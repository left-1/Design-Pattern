package com.left.builder;

/**
 * 建造者模式-Final属性
 */
public class FinalBuilder {

    public static void main(String[] args) {
        FinalProduct.ProductBuilder productBuilder = new FinalProduct.ProductBuilder();
        FinalProduct finalProduct = productBuilder.productName("product")
                .companyName("company")
                .part1("part1")
                .part2("part2")
                .build();
        System.out.println(finalProduct);
    }

}

class FinalProduct {

    private final String productName;
    private final String companyName;
    private final String part1;
    private final String part2;

    public FinalProduct(String productName, String companyName, String part1, String part2) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
    }

    static class ProductBuilder {
        private String productName;
        private String companyName;
        private String part1;
        private String part2;

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public ProductBuilder part1(String part1) {
            this.part1 = part1;
            return this;
        }

        public ProductBuilder part2(String part2) {
            this.part2 = part2;
            return this;
        }

        public FinalProduct build() {
            // 可以校验参数
            return new FinalProduct(this.productName, this.companyName, this.part1, this.productName);
        }

    }

    @Override
    public String toString() {
        return "FinalProduct{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }

}

