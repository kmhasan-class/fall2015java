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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label clockLabel;
    private Timeline timeline;
    @FXML
    private Canvas clockCanvas;
    private double angle = 90;
    
    // Timeline
    // KeyFrame
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
            clockLabel.setText(formatter.format(date));
            
            GraphicsContext gc = clockCanvas.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 350, 350);
            gc.setFill(Color.RED);
            gc.fillOval(350 / 2 - 150, 350 / 2 - 150, 300, 300);
            gc.setFill(Color.WHITE);
            gc.fillOval(350 / 2 - 275 / 2, 350 / 2 - 275 / 2, 275, 275);
            
            SimpleDateFormat secondFormatter = new SimpleDateFormat("ss");
            int seconds = Integer.parseInt(secondFormatter.format(date));
            
            double radius = 100;
            double theta = (seconds * 6) * Math.PI / 180;
            double x = 350 / 2 + radius * Math.cos(theta);
            double y = 350 / 2 - radius * Math.sin(theta);
            gc.strokeLine(350 / 2, 350 / 2, x, y);
            angle = angle - 6;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
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
