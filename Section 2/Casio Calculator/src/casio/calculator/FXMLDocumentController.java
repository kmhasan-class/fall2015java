/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casio.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField displayField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleTwoAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "2";
        displayField.setText(newText);
    }

    @FXML
    private void handleFourAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "4";
        displayField.setText(newText);
    }

    @FXML
    private void handleDigitAction(ActionEvent event) {
        // Got to explain import, casting, objects
        Button b = (Button) event.getSource();
        String oldText = displayField.getText();
        String newText = oldText + b.getText();
        displayField.setText(newText);
    }
    
}
