package bean;

import java.sql.Date;
import java.util.Objects;

public class Sale {
    private long saleId;
    private Date date;
    private String paymentMethod;
    private double totalPrice;
    private long memberId;

    public Sale() {
    }

    public Sale(long saleId, Date date, String paymentMethod, double totalPrice, long memberId) {
        this.saleId = saleId;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
        this.memberId = memberId;
    }

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
                ", memberId=" + memberId +
                '}';
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
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

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
