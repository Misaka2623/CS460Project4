package dao;

import com.sun.istack.internal.localization.NullLocalizable;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    public long insert(Employee employee){
        employee.setEmployeeId(generateId());
        if( employee.getPersonId() == null || employee.getSalary()  == null || employee.getGroupId() == null)
            return 0;

        ResultSet answer = executeSql("INSERT INTO \"employee\" VALUES (?,?,?,?)",
        employee.getEmployeeId(), employee.getPersonId(), employee.getSalary(), employee.getGroupId());

        return employee.setEmployeeId();
    }

    public boolean delete(long employeeId){
         //TODO: check if delete sucess
        int answer = executeUpdate("DELETE FROM employee WHERE employee_id = (?)", employeeId);
        if(answer == 0)
            return false;
        return true;
    }

    public  List<Employee> getAll(){
        //TODO: get all employees id
        List<employee> total = new List<Employee>();
        Result answer = executeSql("SELECT employee_id from employee")
        while(answer.next())
        {
            total.add(answer.getLong());
        }
        return total;
    }
}