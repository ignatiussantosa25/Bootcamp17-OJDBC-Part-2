/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MyConnection;

/**
 *
 * @author Ignatius
 */
public class FunctionDAO implements InterfaceDAO {

    public Connection connection;

    public FunctionDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Execute query: DML such as INSERT, UPDATE, or DELETE
     *
     * @param query - query for DML
     * @return boolean
     */
    @Override
    public boolean executeDML(String query) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Execute query SELECT can use to show all datas, or search data, and
     * sorting by category
     *
     * @param query - query for view datas
     * @return List datas from table
     */
    @Override
    public List<Object[]> getAll(String query) {
        List<Object[]> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int column = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Object item[] = new Object[column];
                for (int i = 0; i < column; i++) {
                    item[i] = resultSet.getObject(i + 1);
                }
                datas.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * Execute get data by id from user input
     *
     * @param query - query with id input from user
     * @return Object from table
     */
    @Override
    public Object[] getDataByID(String query) {
        Object[] data = null;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int column = resultSet.getMetaData().getColumnCount();
            data = new Object[column];
            while (resultSet.next()) {
                for (int i = 0; i < column; i++) {
                    data[i] = resultSet.getObject(i+1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /**
     * Function for generate ID automatically
     *
     * @param query - query for get auto id
     * @return String auto id that must be unique
     */
    @Override
    public String getAutoID(String query) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
