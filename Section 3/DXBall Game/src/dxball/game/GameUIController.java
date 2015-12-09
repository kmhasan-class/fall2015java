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
public class GameUIController implements Initializable {

    @FXML
    private Canvas gameCanvas;

    private double ballX;
    private double ballY;
    private double ballRadius;
    
    private double paddleX;
    private double paddleY;
    private double paddleWidth;
    private double paddleHeight;

    private double vX;
    private double vY;
    private double dt;
    
    private double pX;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ballRadius = 50;
        ballX = gameCanvas.getWidth() / 2;
        ballY = gameCanvas.getHeight() / 2;

        paddleWidth = 200;
        paddleHeight = 40;
        paddleX = gameCanvas.getWidth() / 2 - paddleWidth / 2;
        paddleY = gameCanvas.getHeight() - paddleHeight;
        
        pX = 0;
        vX = 100;
        vY = 40;
        dt = 1.0 / 30.0;

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(dt), event -> {
            GraphicsContext gc = gameCanvas.getGraphicsContext2D();
            // clear the scene
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
            // draw the walls
            gc.strokeRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
            // draw the paddle
            gc.strokeRect(paddleX, paddleY, paddleWidth, paddleHeight);
            // draw the ball
            gc.strokeOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);
            ballX = ballX + vX * dt;
            ballY = ballY + vY * dt;
            paddleX = paddleX + pX * dt;
            
            if (ballX + ballRadius >= gameCanvas.getWidth() || ballX <= ballRadius)
                vX = -vX;
            if (ballY + ballRadius >= gameCanvas.getHeight() || ballY <= ballRadius)
                vY = -vY;
            if (paddleX + paddleWidth >= gameCanvas.getWidth()
                    || paddleX <= 0)
                pX = 0;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void handleMouseMoved(MouseEvent event) {
        double mouseX = event.getX();
        double dx = mouseX - paddleX;
        double t = 2;
        pX = dx / t;
    }

}
