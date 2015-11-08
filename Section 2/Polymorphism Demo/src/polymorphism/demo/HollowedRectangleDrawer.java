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
public class HollowedRectangleDrawer extends RectangleDrawer {

    public HollowedRectangleDrawer(int rows, int cols) {
        super(rows, cols);
    }
    
    public void draw() {
        System.out.printf("Hollowed Rectangle\n");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++)
                if (i == 1 || i == rows || j == 1 || j == cols)
                    System.out.printf("*");
                else System.out.printf(" ");
            System.out.printf("\n");
        }
    }
}
