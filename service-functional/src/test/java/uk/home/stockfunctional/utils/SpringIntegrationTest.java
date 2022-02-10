package uk.home.stockfunctional.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpringIntegrationTest {

    public static HttpResponse httpResponse;

    public static void executeGet(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

        httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
