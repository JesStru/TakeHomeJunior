package org.example;

public class Rating {
    private final int userId;
    private final int movieId;
    private final double rating;
    private final String timestamp;

    public Rating(int userId, int movieId, double rating, String timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public double getRating() {
        return this.rating;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}
