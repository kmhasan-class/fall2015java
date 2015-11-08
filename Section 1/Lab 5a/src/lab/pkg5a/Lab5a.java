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
        Number a = new ComplexNumber(4, 5);
        Number b = new ComplexNumber(3, 2);
        Number c = a.add(b);
        System.out.printf("%s\n", c);
    }
    
}
