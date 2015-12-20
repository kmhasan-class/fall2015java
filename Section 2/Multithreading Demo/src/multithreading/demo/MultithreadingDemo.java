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
        /*
         Printer a = new Printer("A");
         Printer b = new Printer("B");
         Printer c = new Printer("C");
         a.start();
         b.start();
         c.start();
         */
        // [2, 100000]
        PrimeTester testA = new PrimeTester(2, 25000);
        PrimeTester testB = new PrimeTester(25001, 50000);
        PrimeTester testC = new PrimeTester(50001, 75000);
        PrimeTester testD = new PrimeTester(75001, 100000);
        testA.start();
        testB.start();
        testC.start();
        testD.start();

        // NOTE TO SELF: talk about Runnable in next class
        try {
            testA.join();
            testB.join();
            testC.join();
            testD.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultithreadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        int countA = testA.getResult();
        int countB = testB.getResult();
        int countC = testC.getResult();
        int countD = testD.getResult();
        int total = countA + countB + countC + countD;
        System.out.printf("There are %d primes in the range [2, 100000]\n", total);
    }

}
