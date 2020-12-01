package bean;

import java.util.Objects;

public class Employee {
    private long employeeId;
    private long personId;
    private double salary;
    private long groupId;

    public Employee() {
    }

    public Employee(long employeeId, long personId, double salary, long groupId) {
        this.employeeId = employeeId;
        this.personId = personId;
        this.salary = salary;
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", personId=" + personId +
                ", salary=" + salary +
                ", groupId=" + groupId +
                '}';
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
