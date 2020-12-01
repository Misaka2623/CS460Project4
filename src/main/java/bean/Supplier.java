package bean;

import lombok.Data;

@Data
public class Supplier {
    private long supplierId;
    private String name;
    private long addressId;
    private long contactPerson;
}
