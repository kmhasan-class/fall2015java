/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphism.demo;

/**
 *
 * @author kmhasan
 */
public class RectangleDrawer extends ShapeDrawer {
    private int rows;
    private int cols;

    public RectangleDrawer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    @Override
    public void draw() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++)
                System.out.printf("*");
            System.out.printf("\n");
        }
    }
}
