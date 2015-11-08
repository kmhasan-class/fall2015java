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
//        TriangleDrawer triangle = new TriangleDrawer(5);
//        RectangleDrawer rectangle = new RectangleDrawer(4, 5);
//        HollowedRectangleDrawer hollow = new HollowedRectangleDrawer(4, 5);
//        triangle.draw();
//        rectangle.draw();
//        hollow.draw();

        TriangleDrawer triangle = new TriangleDrawer(5);
        ShapeDrawer shape;
        
        ShapeDrawer array[] = new ShapeDrawer[4];
        array[0] = new TriangleDrawer(4);
        array[1] = new TriangleDrawer(3);
        array[2] = new TriangleDrawer(6);
        array[3] = new HollowedRectangleDrawer(5, 3);
        for (int i = 0; i < array.length; i++)
            array[i].draw();
        
        // ENHANCED FOR LOOP
        for (ShapeDrawer jodu: array)
            jodu.draw();
        
        String names[] = {"Hedayet", "Ishaque", "Tomal", "Shahriar", "Jami"};
        for (int i = 0; i < names.length; i++)
            System.out.printf("%s\n", names[i]);
        
        for (String n: names)
            System.out.printf("%s\n", n);
        
        int numbers[] = {5, 43, 2, 1, 5, 3, 5, 7};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum = sum + numbers[i];
        System.out.printf("Sum: %d\n", sum);
        
        sum = 0;
        for (int a: numbers)
            sum = sum + a;
        System.out.printf("%d\n", sum);
    }

    /*
    Triangle
    1 *
    2 **
    3 ***
    4 ****
    5 *****

    Rectangle
      1234
    1 ****
    2 ****
    3 ****
    
    Hollowed Rectangle
    *******
    *     *
    *******
    */
}
