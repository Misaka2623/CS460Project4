package dao;

import bean.Person;

public class PersonDaoImpl extends BaseDao implements PersonDao {
    @Override
    public long insert(Person person){
        // return personId
        person.setPersonId(generateId());

        if( person.getFirstName() == null || person.getLastName()  == null || person.getGender() == null)
            return -1;

        //TODO: Date object
        ResultSet answer = executeSql("INSERT INTO \"person\" VALUES (?,?,?,?,?,?,?)",
                person.getPersonId(), person.getFirstName(), person.getLastName(), person.getGender().getValue(), person.getBirthday(),
                person.getAddressId(), person.getPhone());

        return person.getPersonId();
    }
}
