package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");

        // Example URL - replace with the URL you want to request
        String url = "http://137.184.130.72/";

        try {
            String response = makeHttpGetRequest(url);
            System.out.println("Response from the server:");
            System.out.println(response);
        } catch (IOException e) {
            System.out.println("Error during HTTP request");
            e.printStackTrace();
        }
    }

    public static String makeHttpGetRequest(String urlStr) throws IOException {
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

        return response.toString();
    }
}
