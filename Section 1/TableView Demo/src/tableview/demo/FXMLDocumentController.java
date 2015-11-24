/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ListView<FoodItem> itemList;
    @FXML
    private TableView<FoodItem> itemTable;
    private ObservableList<FoodItem> items;
    @FXML
    private TableColumn<FoodItem, String> itemNameColumn;
    @FXML
    private TableColumn<FoodItem, Number> itemPriceColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = FXCollections.observableArrayList();
        itemList.setItems(items);
        itemTable.setItems(items);
        
        // Lambda Expression
        itemNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));
        itemPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            String query = "select * from FoodItem";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int code = resultSet.getInt("itemCode");
                String name = resultSet.getString("itemName");
                String category = resultSet.getString("catagory");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                
                FoodItem item = new FoodItem(code, name, category, description, price);
                items.add(item);
//                System.out.printf("%s %f\n", name, price);
            }
            
            for (FoodItem item: items)
                System.out.printf("%s\n", item);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
