/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField timeField;
    private Timeline timeline;
    @FXML
    private Canvas clockCanvas;
    private double theta = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
            timeField.setText(formatter.format(date));
            
            GraphicsContext gc = clockCanvas.getGraphicsContext2D();
            gc.strokeLine(0, 200, 400, 200);
            gc.strokeLine(200, 0, 200, 400);
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 400, 400);
            gc.setStroke(Color.RED);
            gc.strokeOval(200 - 350 / 2, 200 - 350 / 2, 350, 350);
            
            double radius = 200;
            theta += Math.PI * 2 / 60;
            double x = radius * Math.cos(theta);
            double y = radius * Math.sin(theta);
            gc.setStroke(Color.BLUE);
            gc.strokeLine(200, 200, 200 + x, 200 + y);
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }    

    @FXML
    private void handleStopAction(ActionEvent event) {
        timeline.stop();
    }

    @FXML
    private void handleStartAction(ActionEvent event) {
        timeline.play();
    }
    
}
