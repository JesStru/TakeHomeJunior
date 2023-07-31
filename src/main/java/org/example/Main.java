package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws RuntimeException {

        final String COMMA_DELIMITER = ",";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Dateien/movies.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(Arrays.asList(line.split(COMMA_DELIMITER)));
            }

            System.out.println("Bitte geben Sie die Filmnummer ein, zu der Sie eine Bewertung wünschen");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String movieId = reader.readLine();

            if (!movieId.isEmpty()) {
                String foundRecord = null;
                for (List<String> record : records) {
                    if (record.get(0).equals(movieId)) {
                        System.out.println("Es wurde der Film: " + record.get(1) + " ausgewählt.");
                        foundRecord = record.get(0);
                        break;
                    }
                }
                if (foundRecord != null) {
                    List<List<String>> records2 = new ArrayList<>();
                    try (BufferedReader br2 = new BufferedReader(new FileReader("Dateien/ratings.csv"))) {
                        double sum = 0;
                        int iterator = 0;
                        String line2;
                        while ((line2 = br2.readLine()) != null) {
                            records2.add(Arrays.asList(line2.split(COMMA_DELIMITER)));
                        }
                        for (List<String> record2 : records2) {
                            if (record2.get(1).equals(foundRecord)) {
                                sum = sum + Double.parseDouble(record2.get(2));
                                ++iterator;
                            }
                        }
                        System.out.printf("Die Bewertung für den Film ist: %.2f", (sum / iterator));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}