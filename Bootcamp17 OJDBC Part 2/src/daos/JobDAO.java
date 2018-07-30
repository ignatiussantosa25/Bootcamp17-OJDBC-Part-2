/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;

/**
 *
 * @author iqbael17
 */
public class JobDAO {

    private final FunctionDAO functionDAO;
  
    
    public JobDAO(Connection connection) {
        this.functionDAO = new FunctionDAO(connection);
    }
    public Object getById(int jobId) {
        return this.functionDAO.getDataByID("select * from Jobs where job_id = " + jobId);
    }
    
}
