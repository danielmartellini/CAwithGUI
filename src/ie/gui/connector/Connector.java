/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gui.connector;

import java.sql.*;

/**
 *
 * @author danie
 */
public class Connector {

    public static Connection connector() {
        java.sql.Connection connection = null;
        String dbServer = "jdbc:mysql://localhost:3306/ca";
        String user = "root";
        String password = "root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
                connection = DriverManager.getConnection(dbServer, user, password);
                return connection;
        }
        catch(Exception e){
            //returns null in case it doesn't connect to the database
            return null;
        }
        
    }
    
    }


       