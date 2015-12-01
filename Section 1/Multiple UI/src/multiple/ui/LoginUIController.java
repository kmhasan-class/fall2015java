/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class LoginUIController implements Initializable {

    @FXML
    private ComboBox<String> accountTypeComboBox;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private ObservableList<String> accountTypes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountTypes = FXCollections.observableArrayList();
        accountTypes.add("Waiter");
        accountTypes.add("Manager");
        accountTypeComboBox.setItems(accountTypes);
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        try {
            String DB_URL = "jdbc:mysql://172.17.0.119/fall2015db";
            String DB_USER = "cse2015fall2015";
            String DB_PASS = "fall2015";

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String accountType = accountTypeComboBox.getSelectionModel().getSelectedItem();
            String query = "select * from User where username='" + username + "' and password=md5('" + password + "');";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                accountType = resultSet.getString("accountType");
                System.out.printf("Login successful\n");
                System.out.printf("Logging in as a %s\n", accountType);

                Parent root = null;

                if (accountType.equals("Waiter")) {
                    root = FXMLLoader.load(getClass().getResource("WaiterUI.fxml"));
                } else if (accountType.equals("Manager")) {
                    root = FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));
                }
                Scene scene = new Scene(root);

                MultipleUI.getStage().setScene(scene);
                MultipleUI.getStage().show();
            } else {
                System.out.printf("Login failed\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
