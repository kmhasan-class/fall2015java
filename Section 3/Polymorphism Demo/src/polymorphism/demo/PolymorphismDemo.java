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
public class PolymorphismDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TriangleDrawer triangle = new TriangleDrawer(4);
//        RectangleDrawer rectangle = new RectangleDrawer(4, 6);
//        triangle.draw();
//        rectangle.draw();
        ShapeDrawer array[] = new ShapeDrawer[3];
        array[0] = new TriangleDrawer(4);
        array[1] = new RectangleDrawer(4, 6);
        array[2] = new RectangleDrawer(2, 3);
        
//        for (int i = 0; i < array.length; i++)
//            array[i].draw();
        
        // ENHANCED FOR LOOP
        // Refence: Head First Java Chapter 5
        // Quiz on Sunday/Tuesday on HFJ Chpts 5, 8
        for (ShapeDrawer shape: array)
            shape.draw();
        
        int intArray[] = {4, 2, 1, 5, 32, 2};
        int sum = 0;
        for (int i = 0; i < intArray.length; i++)
            sum = sum + intArray[i];
        System.out.printf("Sum: %d\n", sum);
        
        sum = 0;
        for (int x: intArray)
            sum = sum + x;
        System.out.printf("Sum: %d\n", sum);
    }
    
}
