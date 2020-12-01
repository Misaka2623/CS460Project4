package bean;

import java.sql.Date;
import java.util.Objects;

public class Warehouse {
    private long warehouseId;
    private long supplierId;
    private long productId;
    private Date incomingDate;
    private double purchasePrice;
    private int amount;

    public Warehouse() {
    }

    public Warehouse(long warehouseId, long supplierId, long productId, Date incomingDate, double purchasePrice,
                     int amount) {
        this.warehouseId = warehouseId;
        this.supplierId = supplierId;
        this.productId = productId;
        this.incomingDate = incomingDate;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId);
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
        return warehouseId == warehouse.warehouseId;
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

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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
