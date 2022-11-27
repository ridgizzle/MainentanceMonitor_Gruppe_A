package fhtw.bic.maintenancemonitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class CheckHTTPResponse {

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

