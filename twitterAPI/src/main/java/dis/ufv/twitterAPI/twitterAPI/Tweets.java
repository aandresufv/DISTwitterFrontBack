package dis.ufv.twitterAPI.twitterAPI;

import java.util.ArrayList;

public class Tweets {

    public ArrayList<Tweet> tweets;

    public Tweets() {
    }

    public Tweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
    //Metodo que printa por pantalla todos los tweets
    public void printTweets(){
        for (Tweet tweet: tweets) {
            System.out.println("Nombre: "+tweet.getNombre());
            System.out.println("Mensaje: "+tweet.getMensaje());
            System.out.println("Fecha: "+tweet.getFechaFormateada());
            System.out.println("-------------------------------");
        }
    }
    //Metodo que añade al ArrayList un tweet
    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }
    //Metodo que devuelve un tweet por su id
    public Tweet getTweetById(int id){
        for (Tweet tweet: tweets) {
            if (tweet.getId() == id){
                return tweet;
            }
        }
        return null;
    }
}
