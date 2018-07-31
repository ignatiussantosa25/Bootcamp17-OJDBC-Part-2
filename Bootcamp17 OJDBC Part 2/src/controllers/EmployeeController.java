/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.JobDAO;
import daos.DepartmentDAO;
import daos.LocationDAO;
import entities.Department;
import entities.Employee;
import entities.Job;
import entities.Location;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author iqbael17
 */
public class EmployeeController {

    private Employee employee;
    private final EmployeeDAO edao;
    private final JobDAO jdao;
    private final DepartmentDAO ddao;
    
    private Location location;
    private final LocationDAO locationDAO;   

//    private final Job job;
//    private final Employee employe;
//    private final Department department;

    /**
     * 
     * @param connection to another classes daos
     */
    public EmployeeController(Connection connection) {
        this.edao = new EmployeeDAO(connection);
        this.ddao = new DepartmentDAO(connection);
        this.jdao = new JobDAO(connection);
        this.locationDAO  = new LocationDAO(connection);
    }

    /**
     * 
     * @param employeeId a variable from employees table
     * @param firstName
     * @param LastName
     * @param email
     * @param phoneNumber
     * @param hireDate
     * @param jobId
     * @param salary
     * @param commissionPct
     * @param managerId
     * @param departmentId
     * @return return variable values from employees
     */
    public boolean save(String employeeId, String firstName, String lastName, String email, String phoneNumber,
            String hireDate, String jobId,
            String salary, String commissionPct, String managerId, String departmentId) {
        
//        Employee employee = (Employee) this.edao.getById(Integer.parseInt(employeeId));
//        Department department = (Department) this.ddao.getById(Integer.parseInt(departmentId));
//        Job job = (Job) this.jdao.getById(Integer.parseInt(jobId));

        return this.edao.insert(new Employee(Integer.parseInt(employeeId), 
                firstName, 
                lastName, 
                email, 
                phoneNumber,
                java.sql.Date.valueOf(hireDate), 
                new Job(jobId, "", 0, 0),
               Integer.parseInt(salary), 
                Double.parseDouble(commissionPct),
                Integer.parseInt(managerId), 
                new Department(Integer.parseInt(departmentId), "", employee, location)));
    }
    
    /**
     * 
     * @param employeeId
     * @param firstName
     * @param LastName
     * @param email
     * @param phoneNumber
     * @param hireDate
     * @param jobId
     * @param salary
     * @param commissionPct
     * @param managerId
     * @param departmentId
     * @return return variable values from employees
     */
    
    public boolean edit(String employeeId, String firstName, String lastName, String email, String phoneNumber,
            String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {

////        Employee employee = (Employee) this.edao.getById(Integer.parseInt(employeeId));
//        Department department = (Department) this.ddao.getById(Integer.parseInt(departmentId));
//        Job job = (Job) this.jdao.getById(Integer.parseInt(jobId));
//        return this.edao.update(new Employee(Integer.parseInt(employeeId), firstName, LastName, email, phoneNumber,
//                java.sql.Date.valueOf(hireDate), job, Integer.parseInt(salary), Double.parseDouble(commissionPct),
//                Integer.parseInt(managerId), department));
        return this.edao.update(new Employee(Integer.parseInt(employeeId),
                firstName,
                lastName,
                email, 
                phoneNumber,
                java.sql.Date.valueOf(hireDate), 
                new Job(jobId, "", 0, 0),
                
                Integer.parseInt(salary), 
                Double.parseDouble(commissionPct),
                Integer.parseInt(managerId), 
                new Department(Integer.parseInt(departmentId), "", employee, location)));
    }
//
    /**
     * 
     * @param employeId a parameter will be deleted
     * @return id from table employee
     */
    public boolean drop(int employeId) {
        return this.edao.delete(employeId);
    }

    /**
     * 
     * @return object datas from employee table 
     */
    public List<Object[]> binding() {
        return this.edao.getAlldata();
    }

    /**
     * 
     * @param category for sort by category
     * @param sort type or sort (asc/desc)
     * @return an object datas from employee table
     */
    public List<Object[]> bindingSort(String category, String sort) {
        return this.edao.getAllSort(category, sort);
    }

    /**
     * 
     * @param category for search category
     * @param data a character which will be found
     * @return object data founded;
     */
    public List<Object[]> find(String category, String data) {
        return this.edao.find(category, data);
    }

    /**
     * 
     * @param employeeId a parameter for get data by id from employee table
     * @return data by id
     */
    public Object findById(String employeeId) {
        return this.edao.getById(Integer.parseInt(employeeId));
    }

    /**
     * 
     * @return auto generate id to makes increase
     */
    public String getAutoId() {
        return this.edao.getAutoId();
    }
    
}
