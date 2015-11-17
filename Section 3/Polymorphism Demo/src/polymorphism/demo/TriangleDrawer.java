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
public class TriangleDrawer extends ShapeDrawer {
    /*
    Triangle of 4 rows
    *
    **
    ***
    ****
    */
    
    private int rows;

    public TriangleDrawer(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }
    
    @Override
    public void draw() {
    /*
    Triangle of 4 rows
    1 *
    2 **
    3 ***
    4 ****
    */
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++)
                System.out.printf("*");
            System.out.printf("\n");
        }
    }
}
