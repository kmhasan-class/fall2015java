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
public class Movie {
    private String movieName;
    private String releaseDate;
    private String directorsName;
    private int totalRating;
    private int totalVotes;
    
    public Movie(String name, String date, String director) {
        movieName = name;
        releaseDate = date;
        directorsName = director;
        totalRating = 0;
        totalVotes = 0;
    }
    
    public void addRating(int rating) {
        totalRating = totalRating + rating;
        totalVotes = totalVotes + 1;
    }
    
    public double getRating() {
        return ((double) totalRating) / totalVotes;
    }
    
    public String getMovieName() {
        return movieName;
    }
}
