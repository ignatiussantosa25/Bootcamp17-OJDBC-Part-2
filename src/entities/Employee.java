/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Ignatius
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Job empjobId;
    private int salary;
    private double commissionPct;
    private Employee empmanagerId;
    private Department empdepartmentId;

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate, Job empjobId, int salary, double commissionPct, Employee empmanagerId, Department empdepartmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.empjobId = empjobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.empmanagerId = empmanagerId;
        this.empdepartmentId = empdepartmentId;
    }

    
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getEmpjobId() {
        return empjobId;
    }

    public void setEmpjobId(Job empjobId) {
        this.empjobId = empjobId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employee getEmpmanagerId() {
        return empmanagerId;
    }

    public void setEmpmanagerId(Employee empmanagerId) {
        this.empmanagerId = empmanagerId;
    }

    public Department getEmpdepartmentId() {
        return empdepartmentId;
    }

    public void setEmpdepartmentId(Department empdepartmentId) {
        this.empdepartmentId = empdepartmentId;
    }

   
}
