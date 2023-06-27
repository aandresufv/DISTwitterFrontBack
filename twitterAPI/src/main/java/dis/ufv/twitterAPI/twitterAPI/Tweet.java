package dis.ufv.twitterAPI.twitterAPI;
import java.util.Date;

public class Tweet {
    // nombre, mensaje, fecha
    private String nombre;
    private String mensaje;
    private Date fecha;

    public Tweet() {
    }

    public Tweet(String nombre, String mensaje, Date fecha) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    //Metodo que devuelve la fecha con el formato dia/mes/año
    public String getFechaFormateada(){
        return fecha.getDay()+"/"+fecha.getMonth()+"/"+fecha.getYear();
    }
}
