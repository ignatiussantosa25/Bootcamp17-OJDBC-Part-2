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
 * @author budiarti
 */
public class CountryDAO{
    
    private final FunctionDAO functionDAO;


    public CountryDAO(Connection connection) {
        this.functionDAO = new FunctionDAO(connection);//instance
    }
    
    public boolean insert(Country country){
        return this.functionDAO.executeDML("INSERT INTO COUNTRIES VALUES('"
                + country.getCountryId()+"','"+country.getCountryName()+"',"+country.getRegion().getRegionId()+")");
    }
    public boolean update(Country country){
        return this.functionDAO.executeDML("UPDATE COUNTRIES SET country_name= '"+country.getCountryName()
                +"', region_id = "+country.getRegion().getRegionId()+" WHERE country_id = '"+country.getCountryId()+"'");
    }
    public boolean delete(String countryId) {
        return this.functionDAO.executeDML("DELETE FROM COUNTRIES WHERE country_id='"+countryId+"'");
    }

    public List<Object[]> getAll() {
        return this.functionDAO.getAll("SELECT * FROM COUNTRIES");
    }

    public List<Object[]> getAllSort(String category, String sort) {
        return this.functionDAO.getAll("SELECT * FROM COUNTRIES ORDER BY " + category + " " + sort);
    }

    public List<Object[]> search(String category, String data) {
        return this.functionDAO.getAll("SELECT c.country_id, c.country_name, r.region_name "
                + "FROM countries c join regions r on c.region_id=r.region_id  WHERE REGEXP_LIKE("+category+", '"+data+"','i')");
    }
    
    public Object getById(String countryId){
        return this.functionDAO.getDataByID("SELECT * FROM COUNTRIES WHERE country_id= '"+countryId+"'");
    }  
}
