/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Region;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Ignatius
 */
public class RegionDAO {

    private final FunctionDAO fdao;

    public RegionDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }

    public boolean insert(Region region) {
        return this.fdao.executeDML("INSERT INTO Regions VALUES("
                + region.getRegionId() + ",'" + region.getRegionName() + "')");
    }

    public boolean update(Region region) {
        return this.fdao.executeDML("UPDATE Regions SET region_name='"
                + region.getRegionName() + "' WHERE region_id=" + region.getRegionId());
    }

    public boolean delete(int regionId) {
        return this.fdao.executeDML("DELETE FROM Regions WHERE region_id=" + regionId);
    }

    public List<Object[]> getAll() {
        return this.fdao.getAll("SELECT * FROM Regions");
    }

    public List<Object[]> getAllSort(String category, String sort) {
        return this.fdao.getAll("SELECT * FROM Regions ORDER BY " + category + " " + sort);
    }

    public List<Object[]> search(String category, String data) {
        return this.fdao.getAll("SELECT * FROM Regions WHERE " + category + " LIKE '%" + data + "%'");
    }
    
    public Object getById(int regionId){
        return this.fdao.getDataByID("SELECT * FROM Regions WHERE region_id="+regionId);
    }
    
    public String getAutoId(){
        return this.fdao.getAutoID("SELECT MAX(region_id)+1 AS MAXID FROM Regions");
    }
}
