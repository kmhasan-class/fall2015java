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
    @FXML
    private Canvas drawingCanvas;
    double lastX = -1;
    double lastY = -1;
    Paint drawingColor;
    @FXML
    private ColorPicker colorPicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        drawingColor = colorPicker.getValue();
        /*
        gc.strokeLine(100, 100, 100, 400);
        gc.strokeLine(0, 0, 100, 100);
        gc.strokeLine(0, 0, 600, 0);
        gc.strokeRect(200, 200, 100, 50);
        gc.strokeOval(200, 200, 100, 50);
        gc.strokeRect(20, 30, 100, 50);
        gc.strokeText("Hello World", 20, 40);
        */
        /*
        double WIDTH = 600;
        double HEIGHT = 400;
        double RADIUS = 50;
        
        gc.strokeLine(0, 200, 600, 200);
        gc.strokeLine(300, 0, 300, 400);
        for (RADIUS = 50; RADIUS <= 2000; RADIUS += 5)
            gc.strokeOval(WIDTH / 2 - RADIUS, HEIGHT / 2 - RADIUS, RADIUS * 2, RADIUS * 2);
                */
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        double currentX = event.getX();
        double currentY = event.getY();
        
        if (event.isShiftDown()) {
            lastX = -1;
            lastY = -1;
            return;
        }
        
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        if (lastX >= 0 && lastY >= 0)
            gc.strokeLine(lastX, lastY, currentX, currentY);
        lastX = currentX;
        lastY = currentY;
    }

    @FXML
    private void handleMouseDragAction(MouseEvent event) {
        double radius = 50;
        double x = event.getX() - radius / 2;
        double y = event.getY() - radius / 2;
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setFill(drawingColor);
        gc.fillOval(x, y, radius, radius);
    }

    @FXML
    private void handleColorSelection(ActionEvent event) {
        drawingColor = colorPicker.getValue();
    }
    
}
