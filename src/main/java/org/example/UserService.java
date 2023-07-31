package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class UserService {
    // Default constructor
    public UserService() {
    }

    // Methods
    /**
     * Asks the user for an input and reads the input stream, returning the input as an Integer.<br>
     * If the input is not a valid Integer, the method will return null.
     *
     * @return The Integer value representing the user input, or null if the input is not a valid Integer.
     */
    public static String getUserInput() {
        String userInput = "";
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Bitte geben Sie die Movie ID ein, zu der Sie eine Bewertung wünschen");
            userInput = input.readLine();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.warning(e.toString());
        }
        return Pattern.matches("[0-9]+", userInput) ? userInput : null;
    }
}