/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.console.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        String query = "insert into Customer values(553, 'Hasan Tareque', '3555');";
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection succeeded");
            
            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
            
            query = "select * from Customer";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customerId");
                String customerName = resultSet.getString("customerName");
                System.out.printf("%d %s\n", customerId, customerName);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConsoleDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
