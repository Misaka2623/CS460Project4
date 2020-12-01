package bean;

import lombok.Data;

@Data
public class SubSale {
    private long subSaleId;
    private long productId;
    private long saleId;
    private double price;
    private int amount;
}
