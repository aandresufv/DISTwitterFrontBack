package org.vaadin.example;
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
}
