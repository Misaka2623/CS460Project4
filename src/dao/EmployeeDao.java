package dao;

import bean.Employee;

import java.util.List;

public interface EmployeeDao {
    long insert(Employee employee);

    boolean delete(long employeeId);

    List<Employee> getAll();
}
