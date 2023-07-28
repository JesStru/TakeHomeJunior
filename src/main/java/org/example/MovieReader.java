package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

public class MovieReader {
    private HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieReader() {
    }

    public MovieReader(String movieFile, String ratingFile) throws FileNotFoundException, IOException {
        loadMovies(movieFile);
        loadRatings(ratingFile);
    }

    public void loadMovies(String filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String entry = br.readLine(); // skip first entry with indecators
            while ((entry = br.readLine()) != null) {
                String[] values = entry.split(",");
                this.movieList.put(Integer.valueOf(values[0]), new Movie(Integer.valueOf(values[0]),
                        values[1], new ArrayList<>(Arrays.asList(values[2].split("|")))));
            }
        }
    }

    public void loadRatings(String filename) throws FileNotFoundException, IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String entry = br.readLine(); // skip first entry with indecators
            while((entry = br.readLine()) != null) {
                String[] values = entry.split(",");
                this.movieList.get(Integer.valueOf(values[1])).addRating(
                    new Rating(Integer.valueOf(values[0]), Integer.valueOf(values[1]), 
                    Double.parseDouble(values[2]), values[3]));
            }
        }
    }

    public Movie findMovie(String movieId) {
        if (movieId != null && this.movieList.containsKey(Integer.valueOf(movieId)) && Pattern.matches("[0-9]*", movieId)) {
            Movie movie = this.movieList.get(Integer.valueOf(movieId));
            System.out.println(String.format("Es wurde der Film: %s ausgewählt.", movie.getMovieTitle()));
            return movie;
        }
        return null;
    }
}
