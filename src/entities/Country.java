/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ignatius
 */
public class Country {
    
    private String countryId;
    private String countryName;
    public Region region;


    public Country() {
    }

    public Country(String countryId, String countryName, Region region) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.region = region;
    }  
    
    /**
     * @return the countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(Region region) {
        this.region = region;
    }
}
