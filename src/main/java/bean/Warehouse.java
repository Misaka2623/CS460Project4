package bean;

import java.sql.Date;
import java.util.Objects;

public class Warehouse {
    private int sid;
    private int pid;
    private Date incomingDate;
    private double purchasePrice;
    private int amount;

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Warehouse)) {
            return false;
        }
        Warehouse warehouse = (Warehouse) o;
        return sid == warehouse.sid;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "sid=" + sid +
                ", pid=" + pid +
                ", incomingDate=" + incomingDate +
                ", purchasePrice=" + purchasePrice +
                ", amount=" + amount +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(Date incomingDate) {
        this.incomingDate = incomingDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
