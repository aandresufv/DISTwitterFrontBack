package org.vaadin.example;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.awt.*;
import java.util.Date;

public class Tweet {
    //id, nombre, mensaje, fecha
    private int id;
    private String nombre;
    private String mensaje;
    private Date fecha;

    public Tweet() {
    }

    public Tweet(int id, String nombre, String mensaje, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    //Metodo que devuelve la fecha con el formato dia/mes/año
    //public String getFechaFormateada(){
    //  return fecha.getDay()+"/"+fecha.getMonth()+"/"+fecha.getYear();
    //}
    public VerticalLayout getTweetLayout(){
        HorizontalLayout mensajeLayout = new HorizontalLayout();
        VerticalLayout layout = new VerticalLayout();
        HorizontalLayout nombreFecha = new HorizontalLayout();
        HorizontalLayout botones = new HorizontalLayout();

        H4 nombre = new H4(this.nombre);
        H2 mensaje = new H2(this.mensaje);
        H5 fecha = new H5(this.fecha.toString());

        nombreFecha.add(nombre, fecha);
        //Creamos un textField para el mensaje
        TextField mensajeEdit = new TextField();
        //Se oculta el textField
        mensajeEdit.setVisible(false);
        mensajeEdit.setValue(this.mensaje);
        mensajeLayout.add(mensaje, mensajeEdit);

        //Boton de eliminar tweet
        Button eliminar = new Button("Eliminar");
        TwitterService service = new TwitterService();
        eliminar.addClickListener(e -> {
            try {
                service.deleteTweet(this.id);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            layout.setVisible(false);
        });
        //Boton de editar tweet

        //Boton de guardar tweet
        Button guardar = new Button("Guardar");
        guardar.addClickListener(e -> {
            try {
                mensaje.setVisible(true);
                mensajeEdit.setVisible(false);
                guardar.setVisible(false);
                Date fechaactual = new Date();
                Tweet tweet = new Tweet(this.id, this.nombre, mensajeEdit.getValue(), fechaactual);
                service.editTweet(tweet);
                UI.getCurrent().getPage().reload();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Button editar = new Button("Editar");
        editar.addClickListener(e -> {
            try {
                mensaje.setVisible(false);
                mensajeEdit.setVisible(true);
                guardar.setVisible(true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        guardar.setVisible(false);
        botones.add(editar,eliminar,guardar);
        layout.add(nombreFecha, mensajeLayout, botones);
        return layout;
    }
}
