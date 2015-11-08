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
public class SquareDrawer extends ShapeDrawer {
    private int rows;

    public SquareDrawer(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }
    
    @Override
    public void draw() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++)
                System.out.printf("*");
            System.out.printf("\n");
        }        
    }
}
