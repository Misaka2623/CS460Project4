package dao;

public class GroupDaoImpl extends BaseDao implements GroupDao {
    public long insert(Group group){
        group.setGroupId(generateId());
        if( group.getName() == null)
            return 0;

        ResultSet answer = executeSql("INSERT INTO \"group\" VALUES (?,?)",
        group.getGroupId(), group.getName());

        return  group.getGroupId() ;
    }

    public boolean delete(long groupId){
        int answer = executeUpdate("DELETE FROM \"group\"  WHERE group_id = (?)", groupId);
        if(answer == 0)
            return false;
        return true;
    }

    public List<Group> getAll(){
        List<Group> total = new List<Group>();
        Result answer = executeSql("SELECT * from \"group\" ");
        while(answer.next())
        {
            long id = answer.getLong();
            String namee = answer.getString();
            Category each = Category(id, names);
            total.add(each);
        }
        return total;
    }
}
