/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

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
        printerA.print();
        printerB.print();
        printerC.print();
    }
    
}
