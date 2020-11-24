package bean;

import java.util.Objects;

public class Product {
    private int productId;
    private String name;
    private double retailPrice;
    private String category;
    private double membershipDiscount;
    private String stockInfo;

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
                "pid=" + productId +
                ", name='" + name + '\'' +
                ", retailPrice=" + retailPrice +
                ", category='" + category + '\'' +
                ", membershipDiscount=" + membershipDiscount +
                ", stockInfo='" + stockInfo + '\'' +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMembershipDiscount() {
        return membershipDiscount;
    }

    public void setMembershipDiscount(double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public String getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(String stockInfo) {
        this.stockInfo = stockInfo;
    }
}
