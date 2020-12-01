package bean;

import lombok.Data;

@Data
public class Address {
    private long addressId;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String postalCode;
}
