package org.example;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        FileService fileService = new FileService("Dateien/movies.csv", "Dateien/ratings.csv");
        Movie movie = fileService.findMovie(UserService.getUserInput());
        if (movie != null) {
            System.out.printf("Die Bewertung für den Film ist: %.2f%n", movie.getAverageRating());
        }
    }
}