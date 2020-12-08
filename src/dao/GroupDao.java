package dao;

import bean.Group;

import java.util.List;

public interface GroupDao {
    long insert(Group group);

    boolean delete(long groupId);

    List<Group> getAll();
}
