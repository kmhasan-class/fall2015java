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
public class TriangleDrawer extends ShapeDrawer implements NamePrinter {
    private int rows;

    public TriangleDrawer(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }
    
    @Override
    public void draw() {
        printName();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++)
                System.out.printf("*");
            System.out.printf("\n");
        }
    }

    @Override
    public void printName() {
        System.out.printf("Triangle\n");
    }
}
