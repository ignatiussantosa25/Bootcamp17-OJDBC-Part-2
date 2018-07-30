/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.JobDAO;
import daos.DepartmentDAO;
import entities.Department;
import entities.Employee;
import entities.Job;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author iqbael17
 */
public class EmployeeController {

    private final EmployeeDAO edao;
    private final JobDAO jdao;
    private final DepartmentDAO ddao;
//    private final Job job;
//    private final Employee employe;
//    private final Department department;

    public EmployeeController(Connection connection) {
        this.edao = new EmployeeDAO(connection);
        this.ddao = new DepartmentDAO(connection);
        this.jdao = new JobDAO(connection);
    }

    public boolean save(String employeeId, String firstName, String LastName, String email, String phoneNumber,
            String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {
        Employee employee = (Employee) this.edao.getById(Integer.parseInt(employeeId));
        Department department = (Department) this.ddao.getById(Integer.parseInt(departmentId));
        Job job = (Job) this.jdao.getById(Integer.parseInt(jobId));

        return this.edao.insert(new Employee(Integer.parseInt(employeeId), firstName, LastName, email, phoneNumber,
                java.sql.Date.valueOf(hireDate), job, Integer.parseInt(salary), Double.parseDouble(commissionPct),
                employee, department));
    }

    public boolean edit(String employeeId, String firstName, String LastName, String email, String phoneNumber,
            String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {

        Employee employee = (Employee) this.edao.getById(Integer.parseInt(employeeId));
        Department department = (Department) this.ddao.getById(Integer.parseInt(departmentId));
        Job job = (Job) this.jdao.getById(Integer.parseInt(jobId));
        return this.edao.update(new Employee(Integer.parseInt(employeeId), firstName, LastName, email, phoneNumber,
                java.sql.Date.valueOf(hireDate), job, Integer.parseInt(salary), Double.parseDouble(commissionPct),
                employee, department));
    }

    public boolean drop(int employeId) {
        return this.edao.delete(employeId);
    }

    public List<Object[]> binding() {
        return this.edao.getAlldata();
    }

    public List<Object[]> bindingSort(String category, String sort) {
        return this.edao.getAllSort(category, sort);
    }

    public List<Object[]> find(String category, String data) {
        return this.edao.find(category, data);
    }

    public Object findById(String employeeId) {
        return this.edao.getById(Integer.parseInt(employeeId));
    }

    public String getAutoId() {
        return this.edao.getAutoId();
    }

}
