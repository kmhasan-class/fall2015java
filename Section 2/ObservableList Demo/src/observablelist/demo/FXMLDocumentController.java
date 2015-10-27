/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observablelist.demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private ListView<String> namesList;
    private ObservableList<String> names;
    @FXML
    private ComboBox<String> namesComboBox;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        names = FXCollections.observableArrayList();
        namesList.setItems(names);
        namesComboBox.setItems(names);
    }    

    @FXML
    private void handleAddAction(ActionEvent event) {
        String name = nameField.getText();
        names.add(name);
    }
    
}
