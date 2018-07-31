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

    private final RegionDAO rdao;
    
    public RegionController(Connection connection) {
        this.rdao = new RegionDAO(connection);
    }
    
    /**
     * Fungsi untuk melakukan insert data dengan parameter regionId dan regionName dengan return value boolean
     * @param regionId region_id yang ingin ditambahkan. String.
     * @param regionName region_name yang ingin ditambahkan. String
     * @return memanggil method insert dari class RegionDAO dengan parameter membuat instance dari kelas Region
     * dimana instance tersebut berisi regionId dan regionName
     */
    public boolean save(String regionId, String regionName){
        return this.rdao.insert(new Region(Integer.parseInt(regionId), regionName));
    }
    
    /**
     * Fungsi untuk melakukan update data dengan parameter regionId dan regionName dengan return value boolean
     * @param regionId region_id yang ingin diubah. String.
     * @param regionName region_name yang ingin diubah. String
     * @return memanggil method update dari class RegionDAO dengan parameter membuat instance dari kelas Region
     * dimana instance tersebut berisi regionId dan regionName
     */
    public boolean edit(String regionId, String regionName){
        return this.rdao.update(new Region(Integer.parseInt(regionId), regionName));
    }
    
    /**
     * Fungsi untuk menghapus data dari Regions
     * @param regionId id data yang ingin di hapus. String.
     * @return memanggil Fungsi delete dari class RegionDAO dengan parameter regionId
     */
    public boolean drop(String regionId){
        return this.rdao.delete(Integer.parseInt(regionId));
    }
    
    /**
     * Fungsi untuk menampilkan semua data
     * @return memanggil fungsi getAll dari class RegionDAO
     */
    public List<Object[]> binding(){
        return this.rdao.getAll();
    }
    
    /**
     * Fungsi untuk menampilkan semua data dengan terurut
     * @param category order by category. String.
     * @param sort tipe sortir
     * @return memanggil fungsi getAll dari class RegionDAO dengan parameter catogory dan sort
     */
    public List<Object[]> bindingSort(String category, String sort){
        return this.rdao.getAllSort(category, sort);
    }
    
    /**
     * Fungsi untuk menampilkan data tertentu
     * @param category pencarian data berdasarkan variabel ini. String.
     * @param data keyword pencarian. String.
     * @return memamnggil fungsi search dari class RegionDAO dengan parameter category dan data
     */
    public List<Object[]> find(String category, String data){
        return this.rdao.search(category, data);
    }
    
    /**
     * Fungsi untuk mrngambil data berdasarkan id
     * @param regionId id data yang ingin ditampilkan
     * @return memanggil fungsi getById dengan parameter regionId
     */
    public Object findById(String regionId){
        return this.rdao.getById(Integer.parseInt(regionId));
    }
    
    /**
     * Fungsi untuk generate otomatis id
     * @return memanggil method getAutoId dari class RegionDAO
     */
    public String getAutoId(){
        return this.rdao.getAutoId();
    }
}
