/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import daos.EmployeeDAO;
import daos.LocationDAO;
import entities.Department;
import entities.Employee;
import entities.Location;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class DepartmentController {
    
    private final DepartmentDAO ddao;
    private final EmployeeDAO edao;
    private final LocationDAO ldao;
    
    
    public DepartmentController(Connection connection) {
        this.ddao = new DepartmentDAO(connection);
        this.edao = new EmployeeDAO(connection);
        this.ldao = new LocationDAO(connection);
    }   
    
    /**
     * Fungsi ini digunakan untuk menyimpan nilai yang ada pada parameter  
     * @param departmentId String
     * @param departmentName String
     * @param managerId String
     * @param locationId String
     * @return true/false
     */
    public boolean save(String departmentId, String departmentName, String managerId, String locationId){
        Employee employee = (Employee) this.edao.getById(Integer.parseInt(managerId));
        Location location = (Location) this.ldao.getById(Integer.parseInt(locationId));
        return this.ddao.insert(new Department(Integer.parseInt(departmentId), departmentName, employee, location));
    }
    
    /**
     * Fungsi ini digunakan untuk mengubah nilai atribut pada tabel Departments
     * @param departmentId String
     * @param departmentName String
     * @param managerId String
     * @param locationId String
     * @return true/false
     */
    public boolean edit(String departmentId, String departmentName, String managerId, String locationId){
        Employee employee = (Employee) this.edao.getById(Integer.parseInt(managerId));
        Location location = (Location) this.ldao.getById(Integer.parseInt(locationId));
        return this.ddao.update(new Department(Integer.parseInt(departmentId), departmentName, employee, location));
    }
    
    /**
     * Fungsi ini digunakan untuk menghapus data berdasarkan id department
     * @param departmentId Integer
     * @return true/false
     */
    public boolean drop(String locationId){
        return this.ddao.delete(Integer.parseInt(locationId));
    }
    
    /**
     * Fungsi ini digunakan untuk menampilkan semua data pada List Object
     * @return nilai semua data pada List Object
     */
    public List<Object[]> binding(){
        return this.ddao.getAll();
    }
    
    
    /**
     * Fungsi ini digunakan untuk menampilkan data yang telah di sortir berdasarkan category
     * @param category String
     * @param sort String
     * @return nilai data yang telah disortir berdasarkan category
     */
    public List<Object[]> bindingSort(String category, String sort){
        return this.ddao.getAllSort(category, sort);
    }
    
    /**
     * Fungsi ini digunakan untuk memanggil fungsi search pada DepartmentDAO
     * @param category String
     * @param data String
     * @return 
     */
    public List<Object[]> find(String category, String data){
        return this.ddao.search(category, data);
    }
    
    public Object findById(String locationId){
        return this.ddao.getById(Integer.parseInt(locationId));
    }
    
    public String getAutoId(){
        return this.ddao.getAutoId();
    }
}
