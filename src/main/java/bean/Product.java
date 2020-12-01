package bean;

import lombok.Data;

@Data
public class Product {
    private long productId;
    private String name;
    private double retailPrice;
    private long categoryId;
    private double membershipDiscount;
    private int stockInfo;
}
