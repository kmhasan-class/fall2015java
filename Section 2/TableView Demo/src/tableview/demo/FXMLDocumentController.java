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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private TableView<FoodItem> itemTable;
    @FXML
    private TableColumn<FoodItem, Number> itemCodeColumn;
    @FXML
    private TableColumn<FoodItem, String> itemNameColumn;
    @FXML
    private ListView<FoodItem> itemList;
    private ObservableList<FoodItem> items;
    @FXML
    private TableColumn<FoodItem, String> categoryColumn;
    @FXML
    private TableColumn<FoodItem, Number> priceColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = FXCollections.observableArrayList();
        itemList.setItems(items);
        itemTable.setItems(items);
        
        itemNameColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getItemName()));
        itemCodeColumn.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getItemCode()));
        categoryColumn.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCategory()));
        priceColumn.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getPrice()));
        
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            String query = "select * from FoodItem;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int itemCode = resultSet.getInt("itemCode");
                String name = resultSet.getString("itemName");
                String category = resultSet.getString("catagory");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                
                FoodItem item = new FoodItem(itemCode, name, category, description, price);
                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
