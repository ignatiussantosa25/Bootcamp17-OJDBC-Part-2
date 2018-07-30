/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Employee;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author iqbael17
 */
public class EmployeeDAO {

    private FunctionDAO fdao;

  

    public EmployeeDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }
    
    public boolean insert(Employee employee) {

        return this.fdao.executeDML("insert into employees values (" + employee.getEmployeeId() + ",'" + employee.getFirstName() + "','" + employee.getLastName()
                + "','" + employee.getEmail() + "','" + employee.getPhoneNumber() + "','" + employee.getHireDate()
                + "','" + employee.getEmpjobId().getJobId() + "'," + employee.getSalary()
                + "," + employee.getCommissionPct() + "," + employee.getEmpmanagerId()
                + "," + employee.getEmpdepartmentId().getDepartmentId() + ")");
    }

    public boolean update(Employee employee) {

        return this.fdao.executeDML("Update employees Set first_name='" + employee.getFirstName() + "', last_name ='" + employee.getLastName()
                + "', email = '" + employee.getEmail() + "', phone_number = '" + employee.getPhoneNumber() + "', hire_date = '"
                + employee.getHireDate() + "', job_id = '" + employee.getEmpjobId().getJobId() + "', salary = "
                + employee.getSalary() + ",commission_pct = " + employee.getCommissionPct() + ", manager_id = " + employee.getEmpmanagerId() + ", department_id = "
                + employee.getEmpdepartmentId().getManagerId() + " where employee_id = " + employee.getEmployeeId());
    }

    public boolean delete(int employeeId) {

        return this.fdao.executeDML("delete from employees where employee_id = " + employeeId);
    }

    public List<Object[]> getAlldata() {

        return this.fdao.getAll("select * from employees");
    }

    public List<Object[]> getAllSort(String category, String sort) {

        return this.fdao.getAll("select * from employees order by " + category + " " + sort);
    }

    public List<Object[]> find(String category, String data) {

        return this.fdao.getAll("select * from employees where " + category + " like '%" + data + "%'");
    
    }

    public Object getById(int employeeId) {

        return this.fdao.getDataByID("select * from employees where employee_id = " + employeeId);
    }
    
    public String getAutoId(){
   
        return this.fdao.getAutoID("select max(employee_id)+1 as MAX_ID from employees");
    }

}
