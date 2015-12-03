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

/**
 *
 * @author kmhasan
 */
public class CanvasUIController implements Initializable {
    private Color currentColor;
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker colorPicker;

    private void sawTooth() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                gc.strokeLine(0 + i * 100, 0 + j * 200, 50 + i * 100, 100 + j * 200);
                gc.strokeLine(50 + i * 100, 100, 100 + i * 100, 0);
            }
            for (int i = 0; i < 10; i++) {
                gc.strokeLine(0 + i * 100, -0 + 200 + j * 200, 50 + i * 100, -100 + 200 + j * 200);
                gc.strokeLine(50 + i * 100, -100 + 200 + j * 200, 100 + i * 100, -0 + 200 + j * 200);
            }
        }
    }
    
    private void sineCurve() {
        double XMAX = drawingCanvas.getWidth();
        double YMAX = drawingCanvas.getHeight();
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.strokeLine(0, YMAX / 2, XMAX, YMAX / 2);
        gc.strokeLine(XMAX / 2, 0, XMAX / 2, YMAX);
        
        double h = Math.PI / 200;
        for (double x1 = 0; x1 <= XMAX; x1 = x1 + h) {
            double y1 = Math.sin(x1 / 20) * 100 + YMAX / 2;
            double x2 = x1 + h;
            double y2 = Math.sin(x2 / 20) * 100 + YMAX / 2;
            gc.strokeLine(x1, y1, x2, y2);
        }
    }
    
    private void drawRectangles() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.strokeRect(0, 0, 1000, 600);
        gc.setFill(new Color(0.8f, 0.8f, 0f, 0.1f));
        gc.fillRect(0, 0, 1000, 600);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 50, 50);
        gc.fillRect(100, 0, 50, 50);
        gc.fillRect(200, 0, 50, 50);
        gc.fillRect(50, 50, 50, 50);
        gc.fillRect(150, 50, 50, 50);
        gc.fillRect(250, 50, 50, 50);
    }
    
    private void drawCircles() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.fillRect(50, 100, 600, 300);
        gc.setFill(Color.RED);
        gc.fillOval(50, 100, 300, 300);
    }
    
    private void concentricCircles() {
        double XMAX = drawingCanvas.getWidth();
        double YMAX = drawingCanvas.getHeight();
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.strokeLine(0, YMAX / 2, XMAX, YMAX / 2);
        gc.strokeLine(XMAX / 2, 0, XMAX / 2, YMAX);
        
        double radius = 50;
        int counter = 0;
        for (radius = 300; radius >= 50; radius -= 50, counter++) {
            if (counter % 2 == 0)
                gc.setFill(Color.BLACK);
            else gc.setFill(Color.WHITE);
            gc.fillOval(XMAX / 2 - radius, YMAX / 2 - radius, radius * 2, radius * 2);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        sawTooth();
//        sineCurve();
//        drawRectangles();
//        drawCircles();
//        concentricCircles();
    }

    @FXML
    private void handleMouseDraggedAction(MouseEvent event) {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        
        double radius = 100;
        double x = event.getX() - radius / 2;
        double y = event.getY() - radius / 2;
        gc.setFill(currentColor);
        gc.fillOval(x, y, radius, radius);
    }

    @FXML
    private void handleColorSelectionAction(ActionEvent event) {
        currentColor = colorPicker.getValue();
    }

}
