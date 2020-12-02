package dao;

public class MemberDaoImpl extends BaseDao implements MemberDao {
    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        return false;
    }

    @Override
    protected String getTableName() {
        return null;
    }
}
