package fhtw.bic.maintenancemonitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.*;


/**
 * Test class for testing the maintenqanceMonitor Application
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class TestHTTPResponse {

    /**
     * tests if setting a status message works as expected
     *
     */
        @Test
        public void shouldPassIfStringMatchesNoPower() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/set?m=Service+checks:+No+power+until+5:00+pm"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.body()).contains("Service checks: No power until 5:00 pm");

        }

    /**
     * Tests if resetting the status message works as expected
     *
     */
        @Test
        public void shouldPassIfStringMatchesDefault() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/reset"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

           assertThat(response.body()).contains("Everything works as expected");

        }

    /**
     * Tests if Webiste changes the color of the body accordingly
     *
     */
    @Test
    public void shouldPassIfColorGreen() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/api/message/reset"))
                .GET()
                .build();
        HttpResponse<String> response =  HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        assertThat(response.body()).contains("body class=\"bodyOk\"");


    }

    /**
     * Testception - Negative test to test the test
     *
     */
        @Test
        public void shouldNotPassIfStringDoesNotMatchDefault() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/reset"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.body()).doesNotContain("Everything does not work as expected");

        }

    /**
     * Tests if body returns the current date and time, which should be the last status change
     *
     */
        @Test
        public void shouldPassIfDateMatchesNow() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/reset"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.body()).contains("last update: <span>" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        }


    /**
     * Testing the status message to be something different from specified
     *
     */
        @Test
        public void shouldPassIfStringMatchesRandomValue() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/set?m=Service+checks:+No+power+until+random+value"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.body()).contains("Service checks: No power until random value");

        }

    /**
     * Tests if Webiste changes the color of the body accordingly
     *
     */
        @Test
        public void shouldPassIfColorRed() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/set?m=Service+checks"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.body()).contains("body class=\"bodyError\"");


        }

    /**
     *
     * Tests a wrong API call - should return 404
     *
     */
        @Test
        public void shouldPassIfAPIwrong() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/message/se"))
                    .GET()
                    .build();
            HttpResponse<String> response =  HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.statusCode()).isEqualTo(404);

        }


    }

