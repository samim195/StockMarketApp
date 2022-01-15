package uk.stockfinder.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {
    private final String url;

    public HttpClientService(String url) {
        this.url = url;
    }

    public HttpResponse getRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
