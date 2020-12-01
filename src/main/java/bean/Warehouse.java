package bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Warehouse {
    private long warehouseId;
    private long supplierId;
    private long productId;
    private Date incomingDate;
    private double purchasePrice;
    private int amount;
}
