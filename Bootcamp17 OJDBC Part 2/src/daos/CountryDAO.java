/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Country;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Ignatius
 */
public class CountryDAO {

    private final FunctionDAO fdao;

    public CountryDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }

    public boolean insert(Country country) {
        return this.fdao.executeDML("INSERT INTO Countries VALUES('"
                + country.getCountryId() + "','" + country.getCountryName() + "',"
                + country.getRegion().getRegionId() + ")");
    }

    public boolean update(Country country) {
        return this.fdao.executeDML("UPDATE Countries SET country_name"
                + "='" + country.getCountryName() + "', region_id="
                + country.getRegion().getRegionId() + " WHERE country_id='"
                + country.getCountryId() + "'");
    }

    public boolean delete(String countryId) {
        return this.fdao.executeDML("DELETE FROM Countries WHERE "
                + "country_id='" + countryId + "'");
    }

    public List<Object[]> getAll() {
        return this.fdao.getAll("SELECT c.country_id,c.country_name, "
                + " r.region_name FROM Countries c, Regions r "
                + "WHERE c.region_id=r.region_id");
    }

    public List<Object[]> getAllSort(String category, String sort) {
        return this.fdao.getAll("SELECT c.country_id,c.country_name, "
                + " r.region_name FROM Countries c, Regions r "
                + "WHERE c.region_id=r.region_id ORDER BY " + category
                + " " + sort);
    }

    public List<Object[]> search(String category, String data) {
        return this.fdao.getAll("SELECT * FROM Countries WHERE REGEXP_LIKE("+category+", '"+data+"','i')");
    }
    
    public Object[] getById(String countryId){
        return this.fdao.getDataByID("SELECT * FROM Countries WHERE "
                + "country_id='"+countryId+"'");
    }
}
