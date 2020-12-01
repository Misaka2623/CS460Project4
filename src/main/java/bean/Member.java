package bean;

import lombok.Data;

@Data
public class Member {
    private long memberId;
    private String username;
    private String password;
    private long personId;
    private int reward;
}
