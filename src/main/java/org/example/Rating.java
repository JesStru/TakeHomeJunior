package org.example;

import java.sql.Timestamp;

public class Rating {
    // Attributes
    private final int userId;
    private final double rating;
    private final Timestamp timestamp; //timestamp

    // Constructor
    public Rating(int userId, double rating, Timestamp timestamp) {
        this.userId = userId;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    // Getter & Setter
    public int getUserId() {
        return this.userId;
    }

    public double getRating() {
        return this.rating;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }
}
