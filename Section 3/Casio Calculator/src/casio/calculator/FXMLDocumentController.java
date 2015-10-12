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
    double firstOperand;
    double secondOperand;
    String operation;
    
    @FXML
    private TextField displayField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDigitAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String digit = button.getText();
        String oldText = displayField.getText();
        String newText = oldText + digit;
        displayField.setText(newText);
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        firstOperand = Double.parseDouble(displayField.getText());
        operation = "ADD";
        displayField.setText("");
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        double result = 0.0;
        secondOperand = Double.parseDouble(displayField.getText());
        // if (operation == "ADD") // THIS IS WRONG
        if (operation.equals("ADD"))
            result = firstOperand + secondOperand;
        else if (operation.equals("SUB"))
            result = firstOperand - secondOperand;
        displayField.setText("" + result);
    }

    @FXML
    private void handleSubtractAction(ActionEvent event) {
        firstOperand = Double.parseDouble(displayField.getText());
        operation = "SUB";
        displayField.setText("");
    }
    
}
