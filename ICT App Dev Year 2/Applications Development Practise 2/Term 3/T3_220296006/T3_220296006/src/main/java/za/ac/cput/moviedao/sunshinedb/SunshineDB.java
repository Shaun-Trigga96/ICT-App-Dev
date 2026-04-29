/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.moviedao.sunshinedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CPUT
 */
public class SunshineDB {
	
	
    //Establish a connection to Derby Database
    public static Connection sunshineDerby() throws SQLException{
       
        String url = "jdbc:derby://localhost:1527/SunshineDB";
        String user = "administrator";
        String password = "password";
        
        return DriverManager.getConnection(url, user, password);
    
    }
	
}
