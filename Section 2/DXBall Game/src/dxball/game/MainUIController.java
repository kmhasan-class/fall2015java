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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class MainUIController implements Initializable {

    @FXML
    private Canvas canvas;

    private double ball1X;
    private double ball1Y;
    private double ball1Radius;

    private double ball2X;
    private double ball2Y;
    private double ball2Radius;
    
    private double paddleX;
    private double paddleY;
    private double paddleWidth;
    private double paddleHeight;

    private double v1X;
    private double v1Y;
    private double v2X;
    private double v2Y;
    private double vPX;
    private double dt;

    boolean isVisible1;
    boolean isVisible2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isVisible1 = true;
        isVisible2 = true;
        
        v1X = 150;
        v1Y = 70;
        v2X = 100;
        v2Y = 80;
        vPX = 0.0;
        dt = 1.0 / 30.0;

        ball1Radius = 100;
        ball1X = canvas.getWidth() / 2;
        ball1Y = canvas.getHeight() / 2;

        ball2Radius = 100;
        ball2X = 200;
        ball2Y = 200;
        
        paddleWidth = 200;
        paddleHeight = 40;
        paddleX = canvas.getWidth() / 2;
        paddleY = canvas.getHeight() - paddleHeight / 2;

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(dt), event -> {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Image image = new Image("/face_front.jpg", 600, 600, false, true);
            gc.drawImage(image, 100, 100);
            // draw the walls
            gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
            // draw the ball
            gc.setFill(Color.BLUE);
            if (isVisible1)
                gc.fillOval(ball1X - ball1Radius, ball1Y - ball1Radius, ball1Radius * 2, ball1Radius * 2);
            gc.setFill(Color.RED);
            if (isVisible2)
                gc.fillOval(ball2X - ball2Radius, ball2Y - ball2Radius, ball2Radius * 2, ball2Radius * 2);
            gc.setFill(Color.GREEN);
            gc.fillRect(paddleX - paddleWidth / 2, paddleY - paddleHeight / 2, paddleWidth, paddleHeight);
            
            if (ball1X + ball1Radius >= canvas.getWidth() || ball1X < ball1Radius)
                v1X = -v1X;
            if (ball1Y + ball1Radius >= canvas.getHeight() || ball1Y < ball1Radius)
                v1Y = -v1Y;
            if (ball2X + ball2Radius >= canvas.getWidth() || ball2X < ball2Radius)
                v2X = -v2X;
            if (ball2Y + ball2Radius >= canvas.getHeight() || ball2Y < ball2Radius)
                v2Y = -v2Y;
            if (paddleX + paddleWidth / 2 >= canvas.getWidth()) {
                vPX = 0;
                paddleX = canvas.getWidth() - paddleWidth / 2 - 1;
            }
            if (paddleX - paddleWidth / 2 <= 0) {
                vPX = 0;
                paddleX = 0 + paddleWidth / 2 + 1;
            }
            
            double dx = ball1X - ball2X;
            double dy = ball1Y - ball2Y;
            double d = Math.sqrt(dx*dx + dy*dy);
            double r1 = ball1Radius;
            double r2 = ball2Radius;
            if (r1 + r2 >= d && isVisible1 && isVisible2) {
                double tX = v1X;
                double tY = v1Y;
                v1X = v2X;
                v1Y = v2Y;
                v2X = tX;
                v2Y = tY;
            }
            ball1X = ball1X + v1X * dt;
            ball1Y = ball1Y + v1Y * dt;

            ball2X = ball2X + v2X * dt;
            ball2Y = ball2Y + v2Y * dt;
            
            paddleX = paddleX + vPX * dt;
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void handleMouseMoved(MouseEvent event) {
        double mouseX = event.getX();
        double dx = mouseX - paddleX;
        vPX = dx / 2;
    }

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();
        
        double dx = ball1X - mouseX;
        double dy = ball1Y - mouseY;
        double d = Math.sqrt(dx * dx + dy * dy);
        
        if (d <= ball1Radius)
            isVisible1 = false;

        dx = ball2X - mouseX;
        dy = ball2Y - mouseY;
        d = Math.sqrt(dx * dx + dy * dy);
        
        if (d <= ball2Radius)
            isVisible2 = false;
    }

}
