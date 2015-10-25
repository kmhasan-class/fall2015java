/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.demo.lab.pkg4a;

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
    private TextField productIDField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField productCategoryField;
    @FXML
    private TextField unitPriceField;
    private Product products[];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        products = new Product[100];
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        int id = Integer.parseInt(productIDField.getText());
        String name = productNameField.getText();
        String category = productCategoryField.getText();
        double price = Double.parseDouble(unitPriceField.getText());
        
        Product p = new Product(id, name, category, price);
        
        try {
            RandomAccessFile output = new RandomAccessFile("product.txt", "rw");
            output.seek(output.length());
            output.writeBytes(p.getId() + "\n");
            output.writeBytes(p.getName() + "\n");
            output.writeBytes(p.getCategory() + "\n");
            output.writeBytes(p.getPrice() + "\n");
            
            productIDField.setText("");
            productNameField.setText("");
            productCategoryField.setText("");
            unitPriceField.setText("");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLoadAction(ActionEvent event) {
        try {
            RandomAccessFile input = new RandomAccessFile("product.txt", "r");
            String line;
            
            for (int i = 0; ; i++) {
                line = input.readLine();
                if (line == null)
                    break;
                int id = Integer.parseInt(line);
                line = input.readLine();
                String name = line;
                line = input.readLine();
                String category = line;
                line = input.readLine();
                double price = Double.parseDouble(line);

                Product p = new Product(id, name, category, price);
                products[i] = p;
            }
            productIDField.setText(products[1].getId() + "");
            productNameField.setText(products[1].getName());
            productCategoryField.setText(products[1].getCategory());
            unitPriceField.setText(products[1].getPrice() + "");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleNewAction(ActionEvent event) {
        productIDField.setText("");
        productNameField.setText("");
        productCategoryField.setText("");
        unitPriceField.setText("");
    }

    @FXML
    private void handlePreviousAction(ActionEvent event) {
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
    }
    
}
