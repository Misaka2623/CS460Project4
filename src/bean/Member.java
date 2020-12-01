package bean;

import java.util.Objects;

public class Member {
    private long memberId;
    private String username;
    private String password;
    private long personId;
    private int reward;

    public Member() {
    }

    public Member(long memberId, String username, String password, long personId, int reward) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.personId = personId;
        this.reward = reward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personId=" + personId +
                ", reward=" + reward +
                '}';
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
