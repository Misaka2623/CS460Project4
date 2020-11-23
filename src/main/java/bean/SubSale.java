package bean;

import java.util.Objects;

public class SubSale {
    private int ssid;
    private int pid;
    private int sid;
    private double price;
    private int amount;

    @Override
    public int hashCode() {
        return Objects.hash(ssid);
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
        return ssid == subSale.ssid;
    }

    @Override
    public String toString() {
        return "SubSale{" +
                "ssid=" + ssid +
                ", pid=" + pid +
                ", sid=" + sid +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int getSsid() {
        return ssid;
    }

    public void setSsid(int ssid) {
        this.ssid = ssid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
