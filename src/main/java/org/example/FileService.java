package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

public class FileService {
    // Attributes
    private final String COMMA_DELIMITER = ",";
    private HashMap<Integer, Movie> movieList = new HashMap<>();
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    // Default constructor
    public FileService() {
    }

    // Constructors
    public FileService(String movieFile, String ratingFile) {
        loadMovies(movieFile);
        loadRatings(ratingFile);
    }

    // Methods
    /**
     * Provide the <b>filename</b> parameter as the UNC path to the input file,
     * then the method will load the movies from the specified file.<br>
     * The program will terminate if any exception occurs during file reading.<br>
     * <i>The first entry of the file will be skipped because, in a CSV, the first line is typically reserved
     * for headers or indicators, and not actual data.</i>
     *
     * @param filename The UNC (Universal Naming Convention) path of the file to load the movies from.
     */
    public void loadMovies(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String entry = br.readLine();
            while ((entry = br.readLine()) != null) {
                String[] values = entry.split(COMMA_DELIMITER);
                this.movieList.put(Integer.valueOf(values[0]), new Movie(Integer.parseInt(values[0]),
                        values[1], new ArrayList<>(Arrays.asList(values[2].split("|")))));
            }
        } catch (IOException e) {
            logger.severe(e.toString());
            System.exit(1);
        }
    }

    /**
     * Provide the <b>filename</b> parameter as the UNC path to the input file,
     * then the method will load the movie ratings from the specified file.<br>
     * The program will terminate if any exception occurs during file reading.<br>
     * <i>The first entry of the file will be skipped because, in a CSV, the first line is typically reserved
     * for headers or indicators, and not actual data.</i>
     *
     * @param filename The UNC (Universal Naming Convention) path of the file to load the movie ratings from.
     */
    public void loadRatings(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String entry = br.readLine();
            while ((entry = br.readLine()) != null) {
                String[] values = entry.split(COMMA_DELIMITER);
                this.movieList.get(Integer.valueOf(values[1])).addRating(
                        new Rating(Integer.parseInt(values[0]), Double.parseDouble(values[2]),
                                new Timestamp(Integer.parseInt(values[3]))));
            }
        } catch (IOException e) {
            logger.severe(e.toString());
            System.exit(1);
        }
    }

    /**
     * Searches for a movie with the specified movie ID in a list of movies.
     *
     * @param movieId The ID of the movie to search for (as a String).
     * @return The Movie object representing the found movie, or null if no movie with the given ID is found.
     */
    public Movie findMovie(String movieId) {
        if (movieId != null && this.movieList.containsKey(Integer.valueOf(movieId))) {
            Movie movie = this.movieList.get(Integer.valueOf(movieId));
            System.out.printf("Es wurde der Film: %s ausgewählt.%n", movie.getMovieTitle());
            return movie;
        }
        return null;
    }
}
