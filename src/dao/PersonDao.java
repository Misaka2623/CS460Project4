package dao;

import bean.Person;

import java.util.List;

public interface PersonDao {
    /**
     * insert a line of specified person object into the table. some fields of the specified person might be empty.
     * the id field of the specified person is not filled, so to implement this method should find the appropriate id
     * of this person.
     *
     * @param person the person that should be inserted.
     * @return the id of the person.
     */
    long insert(Person person);

    boolean delete(long personId);

    List<Person> getAll();
}
