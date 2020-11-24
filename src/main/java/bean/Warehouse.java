package bean;

import java.sql.Date;
import java.util.Objects;

public class Warehouse {
    private int warehouseId;
    private int supplierId;
    private int productId;
    private Date incomingDate;
    private double purchasePrice;
    private int amount;

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
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
        return supplierId == warehouse.supplierId;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", supplierId=" + supplierId +
                ", productId=" + productId +
                ", incomingDate=" + incomingDate +
                ", purchasePrice=" + purchasePrice +
                ", amount=" + amount +
                '}';
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
