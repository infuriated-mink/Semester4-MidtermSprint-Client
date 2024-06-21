package com.keyin;

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
        verify(restClientMock, times(1)).sendGetRequest("/api/events/venue/1");
    }

    @Test
    void testListAttendeesForEvent() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Attendees Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listAttendeesForEvent();
        verify(restClientMock, times(1)).sendGetRequest("/api/attendees/event/1");
    }

    @Test
    void testListEventsForAttendee() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Events Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listEventsForAttendee();
        verify(restClientMock, times(1)).sendGetRequest("/api/events/attendee/1");
    }

    @Test
    void testListSpeakersForEvent() throws Exception {
        when(restClientMock.sendGetRequest(anyString())).thenReturn("Mocked Speakers Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listSpeakersForEvent();
        verify(restClientMock, times(1)).sendGetRequest("/api/speakers/event/1");
    }
}
