package bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Member2 {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int gender;
    private Date birthday;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
}
