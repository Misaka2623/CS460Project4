package bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Person {
    private long personId;
    private String firstName;
    private String lastName;
    /**
     * @see <a href="//en.wikipedia.org/wiki/ISO/IEC_5218>ISO_5218</a> for the number that refers a gender.
     */
    private int gender;
    private Date date;
    private long addressId;
    private String phone;
}
