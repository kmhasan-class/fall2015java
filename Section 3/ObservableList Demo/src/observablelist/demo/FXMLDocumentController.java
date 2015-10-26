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
    private TextField countryNameField;
    @FXML
    private ListView<String> countryList;
//    ArrayList<String> countries;
    ObservableList<String> countries;
    @FXML
    private ComboBox<String> countryComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        countries = new ArrayList<>();
        countries = FXCollections.observableArrayList();
        countryList.setItems(countries);
        countryComboBox.setItems(countries);
    }    

    @FXML
    private void handleAddAction(ActionEvent event) {
        String country = countryNameField.getText();
        countries.add(country);
        countryNameField.setText("");
//        System.out.printf("-------\n");
//        for (int i = 0; i < countries.size(); i++)
//            System.out.printf("%s\n", countries.get(i));
    }

    @FXML
    private void handleComboAction(ActionEvent event) {
        String country = countryComboBox.getSelectionModel().getSelectedItem();
        System.out.printf("%s\n", country);
    }
    
}
