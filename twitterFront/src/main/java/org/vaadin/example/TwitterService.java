package org.vaadin.example;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class TwitterService implements Serializable {

    public ArrayList<Tweet> leeTweets() throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        String resultsAPI = api.getTweets();
        Gson gson = new Gson();
        ArrayList<Tweet> lista = gson.fromJson(resultsAPI,new
                com.google.gson.reflect.TypeToken<ArrayList<Tweet>>(){}.getType());
        return lista;
    }
    public String postTweet(Tweet tweet) throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        return api.postTweet(tweet);
    }
    public String deleteTweet(int id) throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        return api.deleteTweet(id);
    }
    // Editar tweet, usa post y delete
public String editTweet(Tweet tweet) throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        int id = tweet.getId();
        api.deleteTweet(id);
        return api.postTweet(tweet);

    }

}
