package utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHelper {
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static HttpResponse<?> queryService(String url)
            throws IOException, InterruptedException {

        HttpRequest httpRequest =
                HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(url))
                        .build();

        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
