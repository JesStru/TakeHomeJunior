package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class UserService {
    // Default constructor
    public UserService() {
    }

    // Methods
    public static String getUserInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        do {
            System.out.println("Bitte geben Sie die Filmnummer ein, zu der Sie eine Bewertung wünschen");
            userInput = input.readLine();
            // ?-? im Test bei "keiner" als Input liest die readLine() Methode einen null Wert
            if(userInput == null) {
                return null;
            }
        } while (userInput == null || !Pattern.matches("[0-9]+", userInput));
        return userInput;
    }
}