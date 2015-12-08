/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg8b;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private TextField nField;
    @FXML
    private Slider nSlider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nSlider.setMin(3);
        nSlider.setMax(10);
    }

    @FXML
    private void handleNAction(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int n = Integer.parseInt(nField.getText());
        double radius = 150;
        double theta = Math.PI * 2 / n;
        for (int i = 0; i < n; i++) {
            double x1 = canvas.getWidth() / 2 + radius * Math.cos(theta * i);
            double y1 = canvas.getHeight() / 2 - radius * Math.sin(theta * i);
            double x2 = canvas.getWidth() / 2 + radius * Math.cos(theta * (i + 1));
            double y2 = canvas.getHeight() / 2 - radius * Math.sin(theta * (i + 1));
            gc.strokeLine(x1, y1, x2, y2);
        }
    }

    @FXML
    private void handleSliderAction(MouseEvent event) {
        int n = (int) nSlider.getValue();
        nField.setText("" + n);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double radius = 150;
        double theta = Math.PI * 2 / n;
        for (int i = 0; i < n; i++) {
            double x1 = canvas.getWidth() / 2 + radius * Math.cos(theta * i);
            double y1 = canvas.getHeight() / 2 - radius * Math.sin(theta * i);
            double x2 = canvas.getWidth() / 2 + radius * Math.cos(theta * (i + 1));
            double y2 = canvas.getHeight() / 2 - radius * Math.sin(theta * (i + 1));
            gc.strokeLine(x1, y1, x2, y2);
        }
    }

}
