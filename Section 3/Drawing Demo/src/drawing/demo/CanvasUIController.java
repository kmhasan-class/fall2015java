/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author kmhasan
 */
public class CanvasUIController implements Initializable {
    private double lastX = 0;
    private double lastY = 0;
    private Paint fillColor = null;
    
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker colorPicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillColor = colorPicker.getValue();
//        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
//        gc.setFill(Color.BEIGE);
//        gc.fillRect(0, 0, 800, 600);
//        gc.strokeLine(400, 0, 400, 600);
//        gc.strokeLine(0, 300, 800, 300);
//        for (double x = 0; x < 800; x = x + 100)
//            gc.strokeLine(x, 0, x, 600);
//        for (double y = 0; y < 600; y = y + 100)
//            gc.strokeLine(0, y, 800, y);
//        gc.setStroke(Color.RED);
//        gc.setFill(Color.CHOCOLATE);
//        gc.strokeOval(400 - 100, 300 - 100, 200, 200);
//        gc.fillOval(400 - 100, 300 - 100, 200, 200);
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        double x = event.getX();
        double y = event.getY();
        gc.strokeLine(lastX, lastY, x, y);
        lastX = x;
        lastY = y;
    }

    @FXML
    private void handleMouseDragAction(MouseEvent event) {
        double radius = 25;
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        double x = event.getX() - radius / 2;
        double y = event.getY() - radius / 2;
        gc.setFill(fillColor);
        gc.fillOval(x, y, radius, radius);
    }

    @FXML
    private void handleColorPickAction(ActionEvent event) {
        fillColor = colorPicker.getValue();
    }
    
}
