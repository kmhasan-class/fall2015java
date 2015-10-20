/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.demo;

/**
 *
 * @author kmhasan
 */
public class BookDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book a = new Book("Java How to Program");
        a.addRating(5);
        a.addRating(4);
        System.out.printf("%f\n", a.getRating());
    }
    
}
