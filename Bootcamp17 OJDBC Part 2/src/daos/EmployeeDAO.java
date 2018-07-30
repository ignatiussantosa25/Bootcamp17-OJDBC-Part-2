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
    
    /**
     * fungsi insert ke dalam tabel employee
     * @param employee 
     * @return 
     */
    public boolean insert(Employee employee) {

        return this.fdao.executeDML("insert into employees values (" + employee.getEmployeeId() + ",'" + employee.getFirstName() + "','" + employee.getLastName()
                + "','" + employee.getEmail() + "','" + employee.getPhoneNumber() + "','" + employee.getHireDate()
                + "','" + employee.getEmpjobId().getJobId() + "'," + employee.getSalary()
                + "," + employee.getCommissionPct() + "," + employee.getEmpmanagerId()
                + "," + employee.getEmpdepartmentId().getDepartmentId() + ")");
    }

    /**
     * fungsi update pada tabel employee
     * @param employee
     * @return 
     */
    public boolean update(Employee employee) {

        return this.fdao.executeDML("Update employees Set first_name='" + employee.getFirstName() + "', last_name ='" + employee.getLastName()
                + "', email = '" + employee.getEmail() + "', phone_number = '" + employee.getPhoneNumber() + "', hire_date = '"
                + employee.getHireDate() + "', job_id = '" + employee.getEmpjobId().getJobId() + "', salary = "
                + employee.getSalary() + ",commission_pct = " + employee.getCommissionPct() + ", manager_id = " + employee.getEmpmanagerId() + ", department_id = "
                + employee.getEmpdepartmentId().getManagerId() + " where employee_id = " + employee.getEmployeeId());
    }

    /**
     * fungsi delete pada tabel employee dengan parameter employeeid
     * @param employeeId
     * @return 
     */
    public boolean delete(int employeeId) {

        return this.fdao.executeDML("delete from employees where employee_id = " + employeeId);
    }
/**
 * fungsi menampilkan data employee
 * @return 
 */
    public List<Object[]> getAlldata() {

        return this.fdao.getAll("select * from employees");
    }
/**
 * fungsi menampilkan data employee
 * @param category sebagai parameter kolom pada nama tabel database
 * @param sort sebagai asc atau desc
 * @return 
 */
    public List<Object[]> getAllSort(String category, String sort) {

        return this.fdao.getAll("select * from employees order by " + category + " " + sort);
    }

    /**
     * fungsi pencarian data
     * @param category sebagai nama kolom yang dicari
     * @param data sebagai datanya yang dicari
     * @return 
     */
    public List<Object[]> find(String category, String data) {

        return this.fdao.getAll("select * from employees where " + category + " like '%" + data + "%'");
    
    }

    /**
     * menampilkan data berdasarkan id employee
     * @param employeeId sebagai parameter berdasarkan employee id
     * @return 
     */
    public Object getById(int employeeId) {

        return this.fdao.getDataByID("select * from employees where employee_id = " + employeeId);
    }
    /**
     * mendapatkan kd otomatis pada kolom employee_id 
     * @return 
     */
    public String getAutoId(){
   
        return this.fdao.getAutoID("select max(employee_id)+1 as MAX_ID from employees");
    }

}
