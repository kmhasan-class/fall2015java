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

    private double paddleX;
    private double paddleY;
    private double paddleWidth;
    private double paddleHeight;
    private double targetX;

    private double pX;

    private double dt;

    private GraphicsContext gc;

    private Ball balls[];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dt = 0.01;
        paddleHeight = 20;
        paddleWidth = 120;

        pX = 0;

        canvasWidth = gameCanvas.getWidth();
        canvasHeight = gameCanvas.getHeight();

        balls = new Ball[3];
        balls[0] = new Ball(50, 50, 30, 100, 50);
        balls[1] = new Ball(150, 50, 40, 150, 50);
        balls[2] = new Ball(200, 250, 50, 50, 30);

        paddleX = canvasWidth / 2 - paddleWidth / 2;
        paddleY = canvasHeight - paddleHeight;
        targetX = paddleX;

        gc = gameCanvas.getGraphicsContext2D();
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(dt), event -> {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, canvasWidth, canvasHeight);
            gc.strokeRect(0, 0, canvasWidth, canvasHeight);

            for (Ball ball : balls) {
                ball.drawBall(gc);
                ball.checkWallCollision(gameCanvas.getWidth(), gameCanvas.getHeight());
                ball.updateBall(dt);
            }
            
            for (int i = 0; i < balls.length; i++)
                for (int j = i + 1; j < balls.length; j++)
                    if (balls[i].isColliding(balls[j]))
                        ;
                        //balls[i].swapVectors(balls[j]);
            
            gc.strokeRect(paddleX, paddleY, paddleWidth, paddleHeight);

            if (Math.abs(targetX - paddleX) < 1) {
                pX = 0;
            }

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
