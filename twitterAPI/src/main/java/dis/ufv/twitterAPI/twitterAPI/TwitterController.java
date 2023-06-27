package dis.ufv.twitterAPI.twitterAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TwitterController {

    Tweets listaTweets = new Tweets();
    @GetMapping("/tweets")
    public ArrayList<Tweet> getTweets(){
        return new LectorJSON().LeerJSON("./src/main/resources/tweets.json");
    }
    //Metodo que escribe un tweet en el fichero JSON y si no existe lo crea
    @PostMapping("/tweet")
    public void postTweet(@RequestBody String stringtweet) {
        //Se añade el tweet al ArrayList convirtiendo el String en un objeto Tweet
        Tweet tweet = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create().fromJson(stringtweet, Tweet.class);
        //Se le asigna un id aleatorio al tweet de 6 digitos
        tweet.setId((int) (Math.random() * 999999 + 100000));
        listaTweets.addTweet(tweet);
    }
    @GetMapping("/tweet/{id}")
    public Tweet getTweetById(@PathVariable int id){
        return listaTweets.getTweetById(id);
    }
}
