package dis.ufv.twitterAPI.twitterAPI;

public class Tweet {
    // nombre, mensaje, fecha
    private String nombre;
    private String mensaje;
    private String fecha;

    public Tweet(String nombre, String mensaje, String fecha) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
