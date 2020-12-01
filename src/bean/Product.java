package bean;

import java.util.Objects;

public class Product {
    private long productId;
    private String name;
    private double retailPrice;
    private long categoryId;
    private double membershipDiscount;

    public Product() {
    }

    public Product(long productId, String name, double retailPrice, long categoryId, double membershipDiscount) {
        this.productId = productId;
        this.name = name;
        this.retailPrice = retailPrice;
        this.categoryId = categoryId;
        this.membershipDiscount = membershipDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", retailPrice=" + retailPrice +
                ", categoryId=" + categoryId +
                ", membershipDiscount=" + membershipDiscount +
                '}';
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public double getMembershipDiscount() {
        return membershipDiscount;
    }

    public void setMembershipDiscount(double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }
}
