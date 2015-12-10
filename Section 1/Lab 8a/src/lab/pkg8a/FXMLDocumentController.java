/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg8a;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void handleNFieldAction(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int n = Integer.parseInt(nField.getText());
        double radius = 250;
        double theta = Math.PI * 2.0 / n;

        double x[] = new double[n];
        double y[] = new double[n];
        for (int i = 0; i < n; i++) {
            double x1 = radius * Math.cos(theta * i) + canvas.getWidth() / 2;
            double y1 = -radius * Math.sin(theta * i) + canvas.getHeight() / 2;

            double x2 = radius * Math.cos(theta * (i + 1)) + canvas.getWidth() / 2;
            double y2 = -radius * Math.sin(theta * (i + 1)) + canvas.getHeight() / 2;
            
            x[i] = x1;
            y[i] = y1;
            gc.strokeLine(x1, y1, x2, y2);
        }
        gc.setFill(Color.RED);
        gc.fillPolygon(x, y, n);
    }

}
