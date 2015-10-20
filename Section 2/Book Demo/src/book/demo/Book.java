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
public class Book {
    private String bookName;
    private String publicationDate;
    private String publishersName;
    private String authorsNames;
    private int editionNumber;
    private int totalRating;
    private int totalVotes;
    
    public Book() {
        bookName = "";
        totalRating = 0;
        totalVotes = 0;
    }
    
    public Book(String name) {
        bookName = name;
        totalRating = 0;
        totalVotes = 0;
    }
    
    public double getRating() {
        return ((double) totalRating) / totalVotes;
    }
    
    public void addRating(int rating) {
        totalRating = totalRating + rating;
        totalVotes = totalVotes + 1;
    }
}
