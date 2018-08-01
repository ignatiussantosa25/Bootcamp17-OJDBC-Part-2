/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import entities.Country;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignatius
 */
public class ManualTester {

    public static void main(String[] args) {
        Connection connection = new MyConnection().getConnection();
        String regionId = "15";
        String regionName = "Tanjung Duren";
        RegionController regionController = new RegionController(connection);
//        System.out.println(regionController.save(regionId, regionName));
//        System.out.println(regionController.edit(regionId, regionName));
//        System.out.println(regionController.drop(Integer.parseInt(regionId)));
//        for (Region region : regionController.binding()) {
//            System.out.println(region.getRegionId()+" - "+region.getRegionName());
//        }
//        System.out.println("pakai sort");
//        regionController.binding("region_id", "desc").forEach((region) -> {
//            System.out.println(region.getRegionId()+" - "+region.getRegionName());
//        });
//        regionController.find("region_name", "a").forEach((region)->{
//            System.out.println(region.getRegionId()+" - "+region.getRegionName());
//        });
//        System.out.println(regionController.findById(9).getRegionName());
        
            //        System.out.println((char)48);
//        System.out.println((char)57);

//        List<Object[]> datas = new CountryController(connection).binding();
//        for (Object[] data : datas) {
//            for (Object object : data) {
//                System.out.print(object+" ");
//            }
//            System.out.println("");
//        }
//    }
    try {
        CallableStatement cs = connection
                .prepareCall("{CALL getAfectedRows(?,?)}");
        cs.setString(1, "Coba");
        cs.registerOutParameter(2, Types.INTEGER);
        cs.execute();
        int result = cs.getInt(2);
        System.out.println("Hasil : " +result+ " rows afected");
        } catch (SQLException ex) {
            Logger.getLogger(ManualTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
