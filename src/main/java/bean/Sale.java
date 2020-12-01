package bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Sale {
    private long saleId;
    private Date date;
    private String paymentMethod;
    private double totalPrice;
    private long memberId;
}
