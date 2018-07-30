/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author iqbael17
 */
public class MyConnection {

    private Connection connect;

    public Connection getConnection() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServiceName("XE");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setDatabaseName("HR");
            ods.setUser("System");
            ods.setPassword("goce2256");
            connect = ods.getConnection();
            connect.createStatement()
                    .execute("alter session set " + "current_schema=hr");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
