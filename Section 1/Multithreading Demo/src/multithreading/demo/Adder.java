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
// HOMEWORK: do this with Runnable
public class Adder extends Thread {
    private int startNumber;
    private int endNumber;
    private int result;
    
    public int getStartNumber() {
        return startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public Adder(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }
    
    public int add() {
        int sum = 0;
        for (int i = startNumber; i <= endNumber; i++)
            sum = sum + i;
        return sum;
    }
    
    
    @Override
    public void run() {
        result = add();
        // We are enforcing a 1 second delay for demonstration purpose
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Adder.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Done adding %d -> %d: %d\n", startNumber, endNumber, result);
    }

    public int getResult() {
        return result;
    }
}
