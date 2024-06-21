package com.keyin.http.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTClient {


    private static final String SERVER_URL = "http://localhost:8080";

    public String sendGetRequest(String endpoint) throws Exception {
        URL url = new URL(SERVER_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "GET request not worked";
        }
    }

    public String sendPostRequest(String endpoint, String jsonInputString) throws Exception {
        URL url = new URL(SERVER_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "POST request not worked";
        }
    }

    public String listEventsAtVenue(int venueId) throws Exception {
        return sendGetRequest("/api/events/venue/" + venueId);
    }

    public String listAttendeesForEvent(int eventId) throws Exception {
        return sendGetRequest("/api/attendees/event/" + eventId);
    }

    public String listEventsForAttendee(int attendeeId) throws Exception {
        return sendGetRequest("/api/events/attendee/" + attendeeId);
    }

    public String listSpeakersForEvent(int eventId) throws Exception {
        return sendGetRequest("/api/speakers/event/" + eventId);
    }
}
