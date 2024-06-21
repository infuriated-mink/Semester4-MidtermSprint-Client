package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class HTTPRestCLIApplicationTest {

    private HTTPRestCLIApplication cliApp;
    private RESTClient restClientMock;

    @BeforeEach
    void setUp() {
        restClientMock = Mockito.mock(RESTClient.class);
        cliApp = new HTTPRestCLIApplication() {
            {
                this.restClient = restClientMock;
            }
        };
    }

    @Test
    void testListEventsAtVenue() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Events Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listEventsAtVenue();
        verify(restClientMock, times(1)).sendGetRequest("/events?venueId=1");
    }

    @Test
    void testListAttendeesForEvent() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Attendees Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listAttendeesForEvent();
        verify(restClientMock, times(1)).sendGetRequest("/attendees?event=1");
    }

    @Test
    void testListSpeakersForEvent() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Speakers Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listSpeakersForEvent();
        verify(restClientMock, times(1)).sendGetRequest("/events_speakers?eventId=1");
    }

    @Test
    void testListEventsForSpecificDate() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Events Response");

        String input = "2023-06-21\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listEventsForSpecificDate();
        verify(restClientMock, times(1)).sendGetRequest("/events?date=2023-06-21");
    }
}