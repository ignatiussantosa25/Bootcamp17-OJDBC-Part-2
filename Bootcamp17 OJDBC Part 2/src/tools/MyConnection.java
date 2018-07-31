/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Ignatius
 */
public class MyConnection {

    private Connection connect;

    /**
     * Function for connect to oracle database with schema was HR, driver type:
     * thin, and service name: XE
     *
     * @return Connection - sql connection
     */
    public Connection getConnection() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            ods.setUser("system");
            ods.setPassword("misbah10");
            connect = ods.getConnection();
            connect.createStatement()
                    .execute("alter session set "
                            + "current_schema=hr");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connect;
    }
}
