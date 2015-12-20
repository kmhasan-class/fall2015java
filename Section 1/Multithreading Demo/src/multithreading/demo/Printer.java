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
public class Printer implements Runnable {
    private String prefix;
    
    public Printer(String prefix) {
        this.prefix = prefix;
    }
    
    public void print() {
        for (int i = 0; i < 10000; i++)
            System.out.printf("%s %4d\n", prefix, i);
    }
    
    @Override
    public void run() {
        print();
    }
}
