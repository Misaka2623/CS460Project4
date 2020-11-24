package bean;

import java.util.Objects;

public class SubSale {
    private int subSaleId;
    private int productId;
    private int saleId;
    private double price;
    private int amount;

    @Override
    public int hashCode() {
        return Objects.hash(subSaleId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubSale)) {
            return false;
        }
        SubSale subSale = (SubSale) o;
        return subSaleId == subSale.subSaleId;
    }

    @Override
    public String toString() {
        return "SubSale{" +
                "ssid=" + subSaleId +
                ", pid=" + productId +
                ", sid=" + saleId +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int getSubSaleId() {
        return subSaleId;
    }

    public void setSubSaleId(int subSaleId) {
        this.subSaleId = subSaleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
