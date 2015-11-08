/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg5a;

/**
 *
 * @author kmhasan
 */
public class Lab5a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Number a = new ComplexNumber(3, 2);
        Number b = new ComplexNumber(4, -3);
        Number c = a.multiply(b);
        
        Number x = new RationalNumber(3, 4);
        Number y = new RationalNumber(8, 5);
        Number z = x.add(y);
        System.out.printf("%s\n", z);
    }
    
}
