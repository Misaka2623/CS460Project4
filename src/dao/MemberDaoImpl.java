package dao;

import bean.Member;

public class MemberDaoImpl extends BaseDao implements MemberDao {
    
    @Override
    public boolean checkUsernameAndPassword(String username, String password){
        String query = String.format("SELECT * FROM member WHERE username='%s' AND password='%s'", username, password);
        ResultSet answer = executeSql(query);
        if(answer != null)
            return true;
        return false;
    }

    @Override

    public boolean containsUsername(String username){
        String query = String.format("SELECT * FROM member WHERE username='%s'", username);
        ResultSet answer = executeSql(query);
        if(answer != null)
            return true;
        return false;
    }

    @Override

    public long insert(Member member){
        member.setMemberId(generateId());
        long member_id = member.getMemberId();
        String username = member.getUsername();
        String password = member.getPassword();
        long person_id = member.getPersonId();
        int reward = member.getReward();
        int super_ember = member.getSuperMember();

        String query = String.format("INSERT INTO member VALUES (%d,%s,%s,%s,%s,%s,%s)", member_id, username, password, person_id, reward, super_ember);
        ResultSet answer = executeSql(query); 
        return member.getMemberId();
    }

    @Override

    public long getMemberIdByUsername(String username){
        // if username exist then return member id 
        // otherwise return -1;
        String query = String.format("SELECT member_id FROM member WHERE username='%s'", username);
        if(answer != null){
            return answer.getLong("member_id");
        }
        return -1;
    }

    @Override

    public boolean isSuperMember(long memberId){
        String query = String.format("SELECT * FROM member WHERE member_id=%d AND super_ember = 1 ", memberId);
        ResultSet answer = executeSql(query);
        if(answer != null)
            return true;
        return false; 
    }

    @Override

    public void joinSuperMember(long memberId){
        String query = String.format("UPDATE member SET super_ember = 1 WHERE member_id=%d", memberId);
        ResultSet answer = executeSql(query);
        if(answer != null)
            return answer;
        return none;  
    }

}
