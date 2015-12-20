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
public class Printer extends Thread {
    private String prefix;

    public Printer(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
    
    public void print() {
        for (int i = 1; i <= 100000; i++) {
            System.out.printf("%s %d\n", prefix, i);
        }
    }
    
    @Override
    public void run() {
        print();
    }
}
