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
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author budiarti
 */
public class CountryController {//jembatan antara view dan dao
    
    private CountryDAO countryDAO;//tamabhkan contructor tak berparameter
    private RegionDAO rdao;

    
    public CountryController(Connection connection) {
        this.countryDAO = new CountryDAO(connection);
        this.rdao = new RegionDAO(connection);
    }

    /**
     * fungsi untuk menyimpan data
     * @param countryId
     * @param countryName
     * @param regionId
     * @return countryDAO.insert menambahkan data pada region
     */
    public boolean save(String countryId, String countryName, String region){
//        Region region1=(Region) this.rdao.getById(Integer.parseInt(region));
//        return this.countryDAO.insert(new Country(countryId, countryName, region1));
        return this.countryDAO.insert(new Country(countryId, countryName, 
                new Region(Integer.parseInt(region), "")));
    }
    
    /**
     * megubah data yg sudah tersimpan
     * @param countryId
     * @param countryName
     * @param region
     * @return countryDAO.udpate menambahkan data pada region
     */
    public boolean edit(String countryId, String countryName, String region){
//        Region region1=(Region) this.rdao.getById(Integer.parseInt(region));
//        return this.countryDAO.update(new Country(countryId, countryName, region1));
        return this.countryDAO.update(new Country(countryId, countryName, 
                new Region(Integer.parseInt(region), "")));
    }
    /**
     * 
     * @param countryId
     * @return countryDAO.delete menghapus data pada country
     */
    public boolean  drop(String countryId){
        return this.countryDAO.delete(countryId);
    }
    
    /**
     * 
     * @return countryDAO.getAll memanggil semua data dan disimpan pada list<object>
     */
    public List<Object[]> binding(){
        return this.countryDAO.getAll();
    }
    
    /**
     * 
     * @param category
     * @param sort
     * @return countryDAO.getAllSort memanggil semua data dan disimpan pada list<object> berdasarkan parameter tertentu
     */
    public  List<Object[]> bindingSort(String category, String sort){
        return this.countryDAO.getAllSort(category, sort);
    }
    
    /**
     * 
     * @param category
     * @param data
     * @return countryDAO.search melakukan pencarian data dan disimpan pada list<object> berdasarkan parameter tertentu
     */
    public List<Object[]> find(String category, String data){
        return this.countryDAO.search(category, data);
    }
    
    /**
     * 
     * @param countryId
     * @return countryDAO.getById melakukan pemanggilan data dan disimpan pada object berdasarkan parameter countryId
     */
    public Object findBy(String countryId){
        return this.countryDAO.getById(countryId);
    }
}
