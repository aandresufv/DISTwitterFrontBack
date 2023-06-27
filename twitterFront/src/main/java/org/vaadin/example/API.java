package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

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
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
        JsonObject jsonObject = gson.toJsonTree(tweet).getAsJsonObject();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
    // Eliminar tweet
    public String deleteTweet(int id) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "deletetweet",id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .DELETE()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}
