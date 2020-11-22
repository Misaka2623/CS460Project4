package bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

public class Sale {
    private int saleId;
    private Date date;
    private String paymentMethod;
    private double totalPrice;
    private int mid;
    private int[] subSales;

    @Override
    public int hashCode() {
        return Objects.hash(saleId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sale)) {
            return false;
        }
        Sale sale = (Sale) o;
        return saleId == sale.saleId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalPrice=" + totalPrice +
                ", mid=" + mid +
                ", subSales=" + Arrays.toString(subSales) +
                '}';
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int[] getSubSales() {
        return subSales;
    }

    public void setSubSales(int[] subSales) {
        this.subSales = subSales;
    }
}
