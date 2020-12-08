package dao;

import com.sun.istack.internal.localization.NullLocalizable;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    public long insert(Employee employee){
        return 0.0
    }

    public boolean delete(long employeeId){
        return true;
    }

    public  List<Employee> getAll(){
        return null;
    }
}