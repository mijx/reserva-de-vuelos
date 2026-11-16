import java.time.LocalTime;

public class Cancelacion extends Transaccion {
    //Atributo de Cancelacion, hora en que se realiza la cancelacion
    private LocalTime horaCancelacion;

    //Metodo Constructor
    public Cancelacion(String nombre, String numAsiento, LocalTime horaCancelacion) {
        super(nombre, numAsiento, "Cancelación");
        this.horaCancelacion = horaCancelacion;
    }

    //Getter y Setter
    public LocalTime getHoraCancelacion() { return horaCancelacion; }
    public void setHoraCancelacion(LocalTime horaCancelacion) { this.horaCancelacion = horaCancelacion; }
}
