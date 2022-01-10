package com.left.prototype;

/**
 * 原型模式
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("baseName");
        Product original = new Product("p", "c", "p1", "p2", baseInfo);
        System.out.println("original:" + original);
        Product clone = original.clone();
        System.out.println("clone:" + clone);

        original.getBaseInfo().setBaseName("newBaseName");
        System.out.println("original:" + original);
        System.out.println("clone:" + clone);

    }

}

class BaseInfo implements Cloneable {

    private String baseName;

    public BaseInfo(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "hashcode='" + this.hashCode() + '\'' +
                "baseName='" + baseName + '\'' +
                '}';
    }
}

class Product implements Cloneable {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private BaseInfo baseInfo;

    public Product() {
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        Product clone = (Product) super.clone();
        BaseInfo baseInfo = this.baseInfo.clone();
        clone.setBaseInfo(baseInfo);
        return clone;
    }

    public Product(String productName, String companyName, String part1, String part2, BaseInfo baseInfo) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.baseInfo = baseInfo;
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

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "hashcode='" + this.hashCode() + '\'' +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
