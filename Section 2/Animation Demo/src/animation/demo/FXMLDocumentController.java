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
    @FXML
    private Canvas clockCanvas;
    private double theta = Math.PI / 2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        TIMELINE
//        KEYFRAME
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
            clockLabel.setText(formatter.format(date));
            
            GraphicsContext gc = clockCanvas.getGraphicsContext2D();
            gc.strokeRect(0, 0, 600, 600);
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 600, 600);
            gc.setLineWidth(5);
//            gc.strokeLine(300, 0, 300, 600);
//            gc.strokeLine(0, 300, 600, 300);
            gc.strokeOval(50, 50, 500, 500);
            gc.strokeOval(25, 25, 550, 550);
            
            double second_radius = 200;
            double origin_x = 300;
            double origin_y = 300;
            double p_x = origin_x + second_radius * Math.cos(theta);
            double p_y = origin_y - second_radius * Math.sin(theta);
            gc.strokeLine(origin_x, origin_y, p_x, p_y);
            gc.setLineWidth(1);
            gc.strokeText("Hello Clock", p_x, p_y);
            theta = theta - Math.PI / 180 * 6;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }    
    
}
