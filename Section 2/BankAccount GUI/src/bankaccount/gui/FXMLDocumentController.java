/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount.gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
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
    private TextField accountNumberField;
    @FXML
    private TextField accountNameField;
    @FXML
    private TextField openingBalanceField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        int number = Integer.parseInt(accountNumberField.getText());
        String name = accountNameField.getText();
        double balance = Double.parseDouble(openingBalanceField.getText());
        
        RandomAccessFile output;
        try {
            output = new RandomAccessFile("accounts.txt", "rw");
            output.writeBytes(number + "\n");
            output.writeBytes(name + "\n");
            output.writeBytes(balance + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
