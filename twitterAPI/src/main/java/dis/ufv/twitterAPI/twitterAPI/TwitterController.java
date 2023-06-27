package dis.ufv.twitterAPI.twitterAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TwitterController {
    ArrayList<Tweet> listaTweets = new ArrayList<>();
    @GetMapping("/tweets")
    public ArrayList<Tweet> getTweets(){
        return new LectorJSON().LeerJSON("./src/main/resources/tweets.json");
    }
    //Metodo que escribe un tweet en el fichero JSON y si no existe lo crea
    @PostMapping("/tweet")
    public void postTweet(@RequestBody String stringtweet) {
        //Indicador de que se ha recibido el tweet
        System.out.println("Tweet recibido");
        //Se añade el tweet al ArrayList convirtiendo el String en un objeto Tweet
        Tweet tweet = new GsonBuilder().setDateFormat("dd-MM-yyyy").create().fromJson(stringtweet, Tweet.class);
        //Se le asigna un id aleatorio al tweet de 6 digitos
        tweet.setId((int) (Math.random() * 999999 + 100000));
        listaTweets.add(tweet);
        //Se escriben los tweets del arraylist en el fichero JSON
        new LectorJSON().escribirJSON("./src/main/resources/tweets.json", listaTweets);
    }
    @GetMapping("/tweet/{id}")
    public Tweet getTweetById(@PathVariable int id){
        //Se lee el fichero JSON y se carga en un arraylist
        listaTweets = new LectorJSON().LeerJSON("./src/main/resources/tweets.json");
        //Se busca el tweet por su id
        for (Tweet tweet: listaTweets) {
            if (tweet.getId() == id){
                return tweet;
            }
        }
        return null;
    }
    @DeleteMapping("/deletetweet/{id}")
    public void deleteTweetById(@PathVariable int id){
        //Se lee el fichero JSON y se carga en un arraylist
        listaTweets = new LectorJSON().LeerJSON("./src/main/resources/tweets.json");
        //Se busca el tweet por su id
        for (Tweet tweet: listaTweets) {
            if (tweet.getId() == id){
                //Se elimina el tweet del arraylist
                listaTweets.remove(tweet);
                //Se escriben los tweets del arraylist en el fichero JSON
                new LectorJSON().escribirJSON("./src/main/resources/tweets.json", listaTweets);
                return;
            }
        }
    }
}
