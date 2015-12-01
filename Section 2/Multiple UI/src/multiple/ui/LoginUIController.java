/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class LoginUIController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.equals("kmh") && password.equals("abc123")) {
            try {
                System.out.printf("Login successful\n");
                Parent root = FXMLLoader.load(getClass().getResource("CalculatorUI.fxml"));
                
                Scene scene = new Scene(root);
                
                MultipleUI.getMainStage().setScene(scene);            
                MultipleUI.getMainStage().show();
            } catch (IOException ex) {
                Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else System.out.printf("Login failed\n");
    }
    
}
