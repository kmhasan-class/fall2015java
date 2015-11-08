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
        // POLYMORPHISM
        ShapeDrawer array[] = new ShapeDrawer[4];
        array[0] = new TriangleDrawer(4);
        array[1] = new SquareDrawer(2);
        array[2] = new TriangleDrawer(3);
        array[3] = new SquareDrawer(5);
        /*
        for (int i = 0; i < array.length; i++)
            array[i].draw();
        */
        // ENHANCED FOR LOOP
        // Read Head First Java Chapter 5 (Page 149)
        // Quiz 2 (HFJ Chapters 5, 8) next Sunday, Tuesday
        for (ShapeDrawer s: array)
            s.draw();
        
        String names[] = {"Rakib", "Hasan", "Ashiq"};
        for (int i = 0; i < names.length; i++)
            System.out.printf("%s\n", names[i]);
        
        for (String n: names)
            System.out.printf("%s\n", n);
        
        int values[] = {4, 2, 1, 4, 5, 6};
        int sum = 0;
        for (int i = 0; i < values.length; i++)
            sum = sum + values[i];
        System.out.printf("Sum %d\n", sum);
        
        sum = 0;
        for (int t: values)
            sum = sum + t;
        System.out.printf("Sum %d\n", sum);
    }
}
