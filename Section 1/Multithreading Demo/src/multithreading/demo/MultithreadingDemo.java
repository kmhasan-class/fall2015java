/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class MultithreadingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Printer printerA = new Printer("A");
        Printer printerB = new Printer("B");
        Printer printerC = new Printer("C");
        new Thread(printerA).start();
        new Thread(printerB).start();
        new Thread(printerC).start();

        Adder a = new Adder(1, 2500);
        Adder b = new Adder(2501, 5000);
        Adder c = new Adder(5001, 7500);
        Adder d = new Adder(7501, 10000);
        a.start();
        b.start();
        c.start();
        d.start();
        
        try {
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultithreadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int aResult = a.getResult();
        int bResult = b.getResult();
        int cResult = c.getResult();
        int dResult = d.getResult();
        int result = aResult + bResult + cResult + dResult;
        System.out.printf("Sum of series: %d\n", result);
    }
}
