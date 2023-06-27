package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Date;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MainView(@Autowired TwitterService service) {
        VerticalLayout cabezera = new VerticalLayout();
        VerticalLayout cuerpo = new VerticalLayout();
        //Se crea un formulario para añadir un nuevo tweet
        TextField datos = new TextField("Tweet");
        datos.addThemeName("bordered");
        Button boton1 = new Button("Añadir tweet",
                e -> {
                    Tweet tweet = new Tweet();
                    tweet.setNombre("Pepe");
                    tweet.setMensaje(datos.getValue());
                    //Se añade con la fecha actual
                    tweet.setFecha(new Date());
                    datos.clear();
                    try {
                        service.postTweet(tweet);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Notification.show("Tweet añadido");
                    //Se refresca la página para que se vea el nuevo tweet
                    UI.getCurrent().getPage().reload();
                });
      ArrayList<Tweet> listaTweets = new ArrayList<>();
      try {
          listaTweets = service.leeTweets();
      } catch (Exception e) {
          e.printStackTrace();
      }
      cabezera.add(datos, boton1);
      //Bucle que añade todos los tweets al layout cuerpo
        for (Tweet tweet : listaTweets) {
            cuerpo.add(tweet.getTweetLayout());
        }

        add(cabezera, cuerpo);

    }

}
