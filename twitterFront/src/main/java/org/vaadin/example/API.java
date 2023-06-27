package org.vaadin.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private static final String urlPrefix = "http://localhost:8080/%s/%s";
    public String getTweets() throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "tweets","");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
    public String postTweet(Tweet tweet) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "tweet","");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(tweet.toString()))
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

}
