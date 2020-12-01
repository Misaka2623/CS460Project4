package bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Person {
    private long personId;
    private String firstName;
    private String lastName;
    private int gender;
    private Date date;
    private long addressId;
    private String phone;
}
