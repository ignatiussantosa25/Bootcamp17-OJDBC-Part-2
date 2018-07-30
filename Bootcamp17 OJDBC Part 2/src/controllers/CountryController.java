/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import daos.RegionDAO;
import entities.Country;
import entities.Region;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Ignatius
 */
public class CountryController {

    private CountryDAO cdao;
    private RegionDAO rdao;

    public CountryController() {
    }

    public CountryController(Connection connection) {
        this.cdao = new CountryDAO(connection);
        this.rdao = new RegionDAO(connection);
    }
    
    public boolean save(String countryId, String countryName, String regionId){
        Object[] object = (Object[])this.rdao.getById(Integer.parseInt(regionId));
        Region region = new Region(Integer.parseInt(object[0].toString()), (String)object[1]);
        return this.cdao.insert(new Country(countryId, countryName,region));
    }
    
    public boolean edit(String countryId, String countryName, String regionId){
        return this.cdao.update(new Country(countryId, countryName,
                new Region(Integer.parseInt(regionId), "")));
    }
    
    public boolean drop(String countryId){
        return this.cdao.delete(countryId);
    }
    
    public List<Object[]> binding(){
        return this.cdao.getAll();
    }
    
    public List<Object[]> bindingSort(String category, String sort){
        return this.cdao.getAllSort(category, sort);
    }
    
    public List<Object[]> find(String category, String data){
        return this.cdao.search(category, data);
    }
    
    public Object findById(String countryId){
        return this.cdao.getById(countryId);
    }
}
