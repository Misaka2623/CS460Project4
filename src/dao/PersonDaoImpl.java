package dao;

import bean.Person;

public class PersonDaoImpl extends BaseDao implements PersonDao {
    @Override
    public long insert(Person person){
        // return personId
        person.setPersonId(generateId());
        long person_id = person.getPersonId();
        String first_name = person.getFirstName();
        String last_name = person.getLastName();
        Gender gender = person.getGender();
        Date birthday = person.getBirthday();
        long address_id = person.getAddressId();
        String phone = person.getPhone();

        if( first_name == null || last_name  == null || gender == null)
            return -1;

        //TODO: Person object and Date object
        String query = String.format("INSERT INTO person VALUES (%d,%s,%s,%s,%s,%s,%s)", person_id, first_name, last_name, gender, birthday, address_id, phone);
        ResultSet answer = executeSql(query);

        return person.getPersonId();
    }
}
