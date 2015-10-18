/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.demo;

/**
 *
 * @author kmhasan
 */
public class MovieDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Movie a = new Movie("Avatar", "2009/06/05", "James Cameron");
        a.addRating(5);
        a.addRating(4);
        a.addRating(4);
        System.out.printf("%s's rating: %.2f\n", a.getMovieName(), a.getRating());
    }

}
