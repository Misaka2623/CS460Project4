package dao;

import bean.Person;

public class PersonDaoImpl extends BaseDao implements PersonDao {
    @Override
    public long insert(Person person) {
        return 0;
    }

    @Override
    protected String getTableName() {
        return null;
    }
}
