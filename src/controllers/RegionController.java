/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import entities.Region;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author iqbael17
 */
public class RegionController {

    private final RegionDAO regionDAO;

    public RegionController(Connection connection) {
        this.regionDAO = new RegionDAO(connection);
    }

    public boolean save(String regionId, String regionName) {
        return this.regionDAO.insert(new Region(Integer.parseInt(regionId), regionName));
    }

    public boolean edit(String regionId, String regionName) {
        return this.regionDAO.update(new Region(Integer.parseInt(regionId), regionName));
    }

    public boolean drop(String regionId) {
        return this.regionDAO.delete(Integer.parseInt(regionId));
    }

    public List<Object[]> binding() {
        return this.regionDAO.getAll();
    }

    public List<Object[]> bindingSort(String category, String sort) {
        return this.regionDAO.getAllSort(category, sort);
    }

    public List<Object[]> find(String category, String data) {
        return this.regionDAO.search(category, data);
    }

    public Object findById(String regionId) {
        return this.regionDAO.getById(Integer.parseInt(regionId));
    }

    public String getAutoId() {
        return this.regionDAO.getAutoId();

    }
}
