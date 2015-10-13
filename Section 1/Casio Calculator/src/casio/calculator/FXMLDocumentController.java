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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    double number1;
    String operation;
    
    @FXML
    private TextField displayField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void handleOneAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "1";
        displayField.setText(newText);
    }

    @FXML
    private void handleDigitAction(ActionEvent event) {
        String oldText = displayField.getText();
        // We will talk about import and casting in next class
        Button b = (Button) event.getSource();
        String newText = oldText + b.getText();
        displayField.setText(newText);

    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        String oldText = displayField.getText();
        number1 = Double.parseDouble(oldText);
        operation = "ADD";
        displayField.setText("");
    }

    @FXML
    private void handleSubtractOperation(ActionEvent event) {
        String oldText = displayField.getText();
        number1 = Double.parseDouble(oldText);
        operation = "SUB";
        displayField.setText("");
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        String oldText = displayField.getText();
        double number2 = Double.parseDouble(oldText);
        double result = 0.0;
        // I'll explain why we use .equals instead of == later
        if (operation.equals("ADD"))
            result = number1 + number2;
        else if (operation.equals("SUB"))
            result = number1 - number2;
        displayField.setText("" + result);
    }
    
}
