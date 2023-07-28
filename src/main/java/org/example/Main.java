package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NullPointerException, RuntimeException {
        try {
            MovieReader movieReader = new MovieReader("Dateien/movies.csv" , "Dateien/ratings.csv");
            Movie movie = movieReader.findMovie(UserService.getUserInput());
            if(movie != null) {
                System.out.println(String.format("Die Bewertung für den Film ist: %.2f", movie.getAverageRating()));
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}