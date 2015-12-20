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
public class PrimeTester extends Thread {
    int startNumber;
    int endNumber;
    private int result;
    
    public boolean isPrime(int number) {
        boolean prime = true;
        // try to figure out why divisor * divisor <= number will work
        for (int divisor = 2; divisor * divisor <= number; divisor++)
            if (number % divisor == 0)
                prime = false;
        return prime;
    }

    public PrimeTester() {
    }

    public PrimeTester(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }
    
    public int countPrimes() {
        int count = 0;
        for (int i = startNumber; i <= endNumber; i++)
            if (isPrime(i))
                count++;
        return count;
    }
    
    @Override
    public void run() {
        result = countPrimes();
    }

    public int getResult() {
        return result;
    }
    
    
}
