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
    public void addGenre(String movieGenre) {
        this.movieGenres.add(movieGenre);
    }

    public void addRating(Rating movieRating) {
        this.movieRatings.add(movieRating);
    }

    public Double getAverageRating() {
        Double sum = 0.;
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

    public ArrayList<Rating> getMovieRating() {
        return this.movieRatings;
    }

    public void setMovieGenres(String movieGenre) {
        this.movieGenres.add(movieGenre);
    }

    public void setMovieRatings(ArrayList<Rating> movieRatings) {
        this.movieRatings = movieRatings;
    }
}
