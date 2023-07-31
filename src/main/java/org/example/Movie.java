package org.example;

import java.util.ArrayList;

public class Movie {
    // Attributes
    private final int movieId;
    private final String movieTitle;
    private ArrayList<String> movieGenres;
    private ArrayList<Rating> movieRatings;

    // Constructors
    public Movie(int movieId, String movieTitle, ArrayList<String> movieGenres) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenres = movieGenres;
        this.movieRatings = new ArrayList<>();
    }

    public Movie(int movieId, String movieTitle) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieRatings = new ArrayList<>();
    }

    // Methods
    /**
     * Adds a single genre to the movie.
     *
     * @param movieGenre The rating to be added to the movie (as a String).
     */
    public void addGenre(String movieGenre) {
        this.movieGenres.add(movieGenre);
    }

    /**
     * Adds a single rating to the movie.
     *
     * @param movieRating The rating to be added to the movie (as a Rating object).
     */
    public void addRating(Rating movieRating) {
        this.movieRatings.add(movieRating);
    }

    /**
     * Calculates and returns the average rating of the movie.<br>
     * The average rating is calculated as the sum of all ratings for the movie divided by the number of ratings.
     *
     * @return The average rating of the movie as a Double, or null if there are no ratings available.
     */
    public double getAverageRating() {
        double sum = 0;
        for (Rating rating : movieRatings) {
            sum += rating.getRating();
        }
        return sum / movieRatings.size();
    }

    // Getter & Setter
    public int getMovieId() {
        return this.movieId;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public ArrayList<String> getMovieGenres() {
        return this.movieGenres;
    }

    public void setMovieGenres(String movieGenre) {
        this.movieGenres.add(movieGenre);
    }

    public ArrayList<Rating> getMovieRating() {
        return this.movieRatings;
    }

    public void setMovieRatings(ArrayList<Rating> movieRatings) {
        this.movieRatings = movieRatings;
    }
}
