package dis.ufv.twitterAPI.twitterAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LectorJSON {
    public ArrayList<Tweet> LeerJSON(String fichero){
        try {
            FileReader reader = new FileReader(fichero);
            ArrayList<Tweet> listaTweets = new GsonBuilder().setDateFormat("dd-MM-yyyy").create().fromJson(reader, new TypeToken<ArrayList<Tweet>>(){}.getType());
            System.out.println("Lista de tweets cargada");
            return listaTweets;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al leer el fichero JSON");
            return null;
        }
    }
    //Metodo que escribe en un fichero JSON y si el JSON no existe lo crea
    public void escribirJSON(String fichero, ArrayList<Tweet> listaTweets){
        try {
            Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
            String json = gson.toJson(listaTweets);
            Files.write(Paths.get(fichero), json.getBytes());
            System.out.println("Fichero JSON escrito");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al escribir en el fichero JSON");
        }
    }
}
