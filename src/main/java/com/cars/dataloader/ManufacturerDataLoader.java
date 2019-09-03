/*
 * Created on 31-May-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cars.dataloader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cars.Manufacturer;
import com.cars.logging.Logger;

/**
 * @author v023094
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ManufacturerDataLoader {
    
    Statement statement = null;
    ResultSet resultSet = null;
    
    public List<Manufacturer> getManufacturers() {
        
        Manufacturer manufacturer = null;
        List manufacturers = new ArrayList();
        
        try (Connection connection = Constants.getDBConnection()) {
            String sql = "SELECT MANUFACTURER_ID, NAME, WEB, EMAIL, LOGO FROM MANUFACTURER ORDER BY NAME";
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setManufacturerId(resultSet.getInt("MANUFACTURER_ID"));
                manufacturer.setName(resultSet.getString("NAME"));
                manufacturer.setWeb(resultSet.getString("WEB"));
                manufacturer.setEmail(resultSet.getString("EMAIL"));
                manufacturer.setLogo(resultSet.getString("LOGO"));
                manufacturers.add(manufacturer);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(Exception e){
            Logger.log(e);
        }
        
        return manufacturers;
    }
    
    public Manufacturer getManufacturer(int manufacturerId) {
        
        Manufacturer manufacturer = null;
        
        try (Connection connection = Constants.getDBConnection()) {
            String sql = "SELECT MANUFACTURER_ID, NAME, WEB, EMAIL, LOGO FROM MANUFACTURER WHERE MANUFACTURER_ID = "+manufacturerId;
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                manufacturer = new Manufacturer();
                manufacturer.setManufacturerId(resultSet.getInt("MANUFACTURER_ID"));
                manufacturer.setName(resultSet.getString("NAME"));
                manufacturer.setWeb(resultSet.getString("WEB"));
                manufacturer.setEmail(resultSet.getString("EMAIL"));
                manufacturer.setLogo(resultSet.getString("LOGO"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(Exception e){
            Logger.log(e);
        }
        
        return manufacturer;
    }
    
}