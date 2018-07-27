/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import entities.Region;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Ignatius
 */
public class RegionController {

    public RegionDAO rdao;
    
    public RegionController(Connection connection) {
        this.rdao = new RegionDAO(connection);
    }
    
    public boolean save(String regionId, String regionName){
        return this.rdao.insert(new Region(Integer.parseInt(regionId), regionName));
    }
    
    public boolean edit(String regionId, String regionName){
        return this.rdao.update(new Region(Integer.parseInt(regionId), regionName));
    }
    
    public boolean drop(int regionId){
        return this.rdao.delete(regionId);
    }
    
    public List<Object[]> binding(){
        return this.rdao.getAll();
    }
    
    public List<Object[]> bindingSort(String category, String sort){
        return this.rdao.getAllSort(category, sort);
    }
    
    public List<Object[]> find(String category, String data){
        return this.rdao.search(category, data);
    }
    
    public Object findById(String regionId){
        return this.rdao.getById(Integer.parseInt(regionId));
    }
    
    public String getAutoId(){
        return this.rdao.getAutoId();
    }
}
