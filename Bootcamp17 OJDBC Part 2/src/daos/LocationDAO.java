/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Location;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author misbah alkhafadh
 */
public class LocationDAO {
    private final FunctionDAO fdao;
    
    public LocationDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }

    public LocationDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * fungsi untuk memasukan data pada table lokasi
     * @param location parameter yang digunakan untuk menjalankan fungsi
     * @return 
     */
    public boolean insert(Location location ) {
        return this.fdao.executeDML("INSERT INTO Locations VALUES('"
                + location.getLocationId()+ "','" + location.getStreetAddress()+ "', '"+ location.getPostalCode() +"',"
                        + " '"+ location.getCity() +"', '"+location.getStateProvince()+"', '"+location.getCountryId().getCountryId()+"')");
    }

    /**
     * fungsi untuk mengupdate data table 
     * @param location parameter yang digunakan untuk menjalankan fungsi 
     * @return 
     */
    public boolean update(Location location) {
        return this.fdao.executeDML("UPDATE Locations SET street_address='"
                + location.getStreetAddress()+ "', postal_code='"+location.getPostalCode()+"', city='"+location.getCity()+"', "
                        + "state_province='"+location.getStateProvince()+"', country_id='"+location.getCountryId().getCountryId()+"' WHERE location_id=" + location.getLocationId());
    }

    /**
     * fungsi untuk menghapus data 
     * @param locationId parameter yang digunakan untuk menjalankan fungsi
     * @return 
     */
    public boolean delete(int locationId) {
        return this.fdao.executeDML("DELETE FROM Locations WHERE location_id=" + locationId);
    }

    /**
     * fungsi untuk menampilkan data pada table lokasi 
     * @return 
     */
    public List<Object[]> getAll() {
        return this.fdao.getAll("SELECT * FROM Locations");
    }

    /**
     * fungsi untuk menampilkan data sesuai dengan kategori data yang akan ditampilkan
     * @param category nama parameter yang digunakan untuk menampilkan data category 
     * @param sort nama parameter yang digunakan untuk menampilkan data yang telah di sort
     * @return 
     */
    public List<Object[]> getAllSort(String category, String sort) {
        return this.fdao.getAll("SELECT * FROM Locations ORDER BY " + category + " " + sort);
    }

    /**
     * fungsi untuk melakukan fungsi cari data 
     * @param category nama parameter yang digunakan untuk menampilkan data berkategori
     * @param data nama parameter untuk menampilkan data sesuai kategori
     * @return 
     */
    public List<Object[]> search(String category, String data) {
        return this.fdao.getAll("SELECT * FROM Locations WHERE " + category + " LIKE '%" + data + "%'");
    }
    
    /**
     * fungsi untuk menampilkan data berdasarkan ID
     * @param locationId nama parameter yang digunakan untuk melakukan fungsi memanggil data berdasarkan id
     * @return 
     */
    public Object getById(int locationId){
        return this.fdao.getDataByID("SELECT * FROM Locations WHERE location_id='"+locationId+"'");
    }
    
    /**
     * fungsi untuk membuat id secata otomatis ketika akan melakukan insert data bertype int
     * @return 
     */
    public String getAutoId(){
        return this.fdao.getAutoID("SELECT MAX(location_id)+1 AS MAXID FROM Locations");
    } 
}
