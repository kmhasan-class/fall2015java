/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dxball.game;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author kmhasan
 */
public class Ball {

    private double ballX;
    private double ballY;
    private double ballRadius;
    private double vX;
    private double vY;

    public Ball(double ballX, double ballY, double ballRadius, double vX, double vY) {
        this.ballX = ballX;
        this.ballY = ballY;
        this.ballRadius = ballRadius;
        this.vX = vX;
        this.vY = vY;
    }

    public double getBallX() {
        return ballX;
    }

    public double getBallY() {
        return ballY;
    }

    public double getBallRadius() {
        return ballRadius;
    }

    public double getvX() {
        return vX;
    }

    public double getvY() {
        return vY;
    }

    public void updateBall(double dt) {
        ballX = ballX + vX * dt;
        ballY = ballY + vY * dt;
    }

    public boolean isColliding(Ball b) {
        Ball a = this;
        double dx = a.ballX - b.ballX;
        double dy = a.ballY - b.ballY;
        double d = Math.sqrt(dx * dx + dy * dy);
        if (d <= a.ballRadius + b.ballRadius) {
            return true;
        } else {
            return false;
        }
    }

    public void flipVX() {
        vX = -vX;
    }

    public void flipVY() {
        vY = -vY;
    }

    public void drawBall(GraphicsContext gc) {
        gc.strokeOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);
    }

    public void checkWallCollision(double width, double height) {
        if (ballX + ballRadius >= width || ballX - ballRadius <= 0) {
            flipVX();
        }
        if (ballY + ballRadius >= height || ballY - ballRadius <= 0) {
            flipVY();
        }

    }
}
