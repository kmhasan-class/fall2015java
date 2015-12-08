/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dxball.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class MainUIController implements Initializable {

    @FXML
    private Canvas gameCanvas;

    private double canvasWidth;
    private double canvasHeight;

    private double ballX;
    private double ballY;
    private double ballRadius;

    private double paddleX;
    private double paddleY;
    private double paddleWidth;
    private double paddleHeight;
    private double targetX;
    
    private double vX;
    private double vY;

    private double pX;
    
    private double dt;

    private GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dt = 0.01;
        ballRadius = 50;
        paddleHeight = 20;
        paddleWidth = 120;
        
        vX = 100;
        vY = 50;

        pX = 0;
        
        canvasWidth = gameCanvas.getWidth();
        canvasHeight = gameCanvas.getHeight();

        ballX = canvasWidth / 2 - ballRadius / 2;
        ballY = canvasHeight / 2 - ballRadius / 2;

        paddleX = canvasWidth / 2 - paddleWidth / 2;
        paddleY = canvasHeight - paddleHeight;
        targetX = paddleX;
        
        gc = gameCanvas.getGraphicsContext2D();
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(dt), event -> {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, canvasWidth, canvasHeight);
            gc.strokeRect(0, 0, canvasWidth, canvasHeight);
            gc.strokeOval(ballX, ballY, ballRadius, ballRadius);
            gc.strokeRect(paddleX, paddleY, paddleWidth, paddleHeight);
            
            if (ballX + ballRadius >= canvasWidth || ballX <= 0)
                vX = -vX;
            if (ballY + ballRadius >= canvasHeight || ballY <= 0)
                vY = -vY;
            if (Math.abs(targetX - paddleX) < 1)
                pX = 0;
            
            ballX = ballX + vX * dt;
            ballY = ballY + vY * dt;
            
            paddleX = paddleX + pX * dt;
            
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        targetX = event.getX();
        double dx = targetX - paddleX;
        double t = 2;
        pX = dx / t;
    }

}
