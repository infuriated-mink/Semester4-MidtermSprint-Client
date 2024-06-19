package com.keyin.client;

import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@ExtendWith(MockitoExtension.class)
public class TestRESTClient {

    @Mock
    private HttpURLConnection mockConnection;
    @Mock
    private URL mockURL;

    private RESTClient restClient = new RESTClient() {
        @Override
        protected URL createURL(String endpoint) throws Exception {
            return mockURL;
        }
    };

    @Test
    public void testSendGetRequest() throws Exception {
        // Mock URL and HttpURLConnection behavior
        Mockito.when(mockURL.openConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream is = new ByteArrayInputStream("response from GET".getBytes());
        Mockito.when(mockConnection.getInputStream()).thenReturn(is);

        // Call the method to test
        String response = restClient.sendGetRequest("/api/test");

        // Verify behavior and assert response
        Mockito.verify(mockConnection).setRequestMethod("GET");
        Assertions.assertEquals("response from GET", response);
    }

    @Test
    public void testSendPostRequest() throws Exception {
        // Mock URL and HttpURLConnection behavior
        Mockito.when(mockURL.openConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_CREATED);
        InputStream is = new ByteArrayInputStream("response from POST".getBytes());
        Mockito.when(mockConnection.getInputStream()).thenReturn(is);

        // Call the method to test
        String jsonInputString = "{\"name\": \"John\", \"age\": 30}";
        String response = restClient.sendPostRequest("/api/test", jsonInputString);

        // Verify behavior and assert response
        Mockito.verify(mockConnection).setRequestMethod("POST");
        Assertions.assertEquals("response from POST", response);
    }
}
