package com.sourcetohtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDetailGenerator{

    public void getHTML(String input) {
        // Print the length of the string
        if (input == null) {
            System.out.println("String is null.");
        } else {
            System.out.println("Length of the string: " + input.length());
        }

        // Make an HTTP GET request
        try {
            String urlStr = "http://137.184.130.72/";
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            System.out.println("Response from the server:");
            System.out.println(response.toString());
        } catch (IOException e) {
            System.out.println("Error during HTTP request");
            e.printStackTrace();
        }
    }
}
