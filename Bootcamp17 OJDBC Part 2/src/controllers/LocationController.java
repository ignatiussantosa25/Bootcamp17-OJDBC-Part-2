/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import daos.LocationDAO;
import entities.Country;
import entities.Location;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author misbah alkhafadh
 */
public class LocationController {

//    private final LocationDAO ldao;
    public LocationDAO locationDAO;
    private CountryDAO cdao;

    public LocationController() {
        this.locationDAO = new LocationDAO();
    }
    
    public LocationController(Connection connection){
        this.locationDAO = new LocationDAO(connection);
        this.cdao = new CountryDAO(connection);
    }
    
    /**
     * Fungsi untuk menyimpan data 
     * @param locationId identitas dari table lokasi 
     * @param stretAddress alamat jalan table lokasi 
     * @param postalCode kode pos table lokasi 
     * @param city nama kota 
     * @param stateProvince provinsi
     * @param countryId
     * @return 
     */
    public boolean save(String locationId, String stretAddress, String postalCode, String city, String stateProvince, String countryId){
        Object[] object = (Object[])this.locationDAO.getById(Integer.parseInt(locationId));
        Country country= new Country(Integer.parseInt(object[0].toString()), (String)object[1], (String)object[2], (String)object[3], (String)object[4]);
        return this.locationDAO.insert(new Location(Integer.parseInt(locationId), stretAddress, postalCode, city, stateProvince, country));
    }
    
    /**
     * Fungsi yang digunakan untuk mengubah data 
     * @param locationId identitas dari table lokasi 
     * @param stretAddress alamat 
     * @param postalCode kode pos
     * @param city nama kota 
     * @param stateProvince provinsi 
     * @param country negara
     * @return 
     */
    public boolean edit(String locationId, String stretAddress, String postalCode, String city, String stateProvince, String country){
//        Country country = (Country) this.cdao.getById(country);
        return this.locationDAO.update(new Location(Integer.parseInt(locationId), stretAddress, postalCode, city, stateProvince, new Country (countryId)), "");
//        return this.locationDAO.update(new Location(locationId, stretAddress, postalCode, city, stateProvince, 
//                new Country(Integer.parseInt(country), "")));
    }
    
    public boolean drop(String locatioId){
        return this.locationDAO.delete(Integer.parseInt(locatioId));
    }
    
    /**
     * Fungsi untuk menampilkan data 
     * @return 
     */
    public List<Object[]> binding(){
        return this.locationDAO.getAll();
    }
    
    /**
     * Fungsi untuk menampilakn data yang telah di pilih
     * @param category parameter untuk menentukan category yang dicari
     * @param sort parameter untuk menyeleksi sesuai category
     * @return 
     */
    public List<Object[]> bindingSort(String category, String sort){
        return this.locationDAO.getAllSort(category, sort);
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data 
     * @param category parameter untuk menentukan category yang dicari
     * @param data 
     * @return 
     */
    public List<Object[]> find(String category, String data){
        return this.locationDAO.search(category, data);
    }
    
    /**
     * fungsi yang digunakan untuk mencari data sesuai ID
     * @param locationId 
     * @return 
     */
    public Object findById(String locationId){
        return this.locationDAO.getById(Integer.parseInt(locationId));
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan ID secara otomatis 
     * @return 
     */
    public String getAutoId(){
        return this.locationDAO.getAutoId();
    }
}