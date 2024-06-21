package com.keyin.client;

import com.keyin.http.client.RESTClient;

public class TestRESTClient extends RESTClient {

    @Override
    public String sendGetRequest(String endpoint) throws Exception {
        if (endpoint.contains("/api/events/venue/")) {
            return "Mocked Events Response for Venue";
        } else if (endpoint.contains("/api/attendees/event/")) {
            return "Mocked Attendees Response for Event";
        } else if (endpoint.contains("/api/events/attendee/")) {
            return "Mocked Events Response for Attendee";
        } else if (endpoint.contains("/api/speakers/event/")) {
            return "Mocked Speakers Response for Event";
        } else {
            return "Unknown Endpoint";
        }
    }

    @Override
    public String sendPostRequest(String endpoint, String jsonInputString) throws Exception {
        return "Mocked POST Response";
    }
}
