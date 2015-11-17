/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.console.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class DatabaseConsoleDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        
        try {
            String query = "insert into FoodItem values(101, 'Thai Soup', 90);";
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection Succeeded");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConsoleDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
