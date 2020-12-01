package bean;

import java.util.Objects;

public class SubSale {
    private long subSaleId;
    private long productId;
    private long saleId;
    private double price;
    private int amount;

    public SubSale() {
    }

    public SubSale(long subSaleId, long productId, long saleId, double price, int amount) {
        this.subSaleId = subSaleId;
        this.productId = productId;
        this.saleId = saleId;
        this.price = price;
        this.amount = amount;
    }

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
                "subSaleId=" + subSaleId +
                ", productId=" + productId +
                ", saleId=" + saleId +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public long getSubSaleId() {
        return subSaleId;
    }

    public void setSubSaleId(long subSaleId) {
        this.subSaleId = subSaleId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
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
