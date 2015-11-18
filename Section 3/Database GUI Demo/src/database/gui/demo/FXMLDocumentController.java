/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.gui.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField customerIdField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField customerNameField;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddCustomerAction(ActionEvent event) {
        String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
        String DB_USER = "cse2015fall2015";
        String DB_PASS = "fall2015";
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            
            int customerId = Integer.parseInt(customerIdField.getText());
            String customerName = customerNameField.getText();
            String phone = phoneField.getText();
            
            String query = "insert into Customer values(" + customerId + ", '" + customerName + "', '" + phone + "');";
            
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
