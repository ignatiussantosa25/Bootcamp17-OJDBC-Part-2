/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.RegionController;
import entities.Region;
import java.sql.Connection;

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

        System.out.println((char)48);
        System.out.println((char)57);
    }
}
