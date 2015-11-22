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
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
//            String query = "insert into FoodItem values(142, 'Calamari Fries', 'Appetizer', 'Fried squid', 350);";
//            statement.executeUpdate(query);
            String query = "select * from FoodItem;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int itemCode = resultSet.getInt("itemCode");
                String itemName = resultSet.getString("itemName");
                double price = resultSet.getDouble("price");
                System.out.printf("%d %s %.2f\n", itemCode, itemName, price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConsoleDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
