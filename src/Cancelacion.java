import java.time.LocalTime;

public class Cancelacion extends Transaccion {
    private LocalTime horaCancelacion;

    public Cancelacion(String nombre, String numAsiento, LocalTime horaCancelacion) {
        super(nombre, numAsiento, "Cancelación");
        this.horaCancelacion = horaCancelacion;
    }

    public LocalTime getHoraCancelacion() { return horaCancelacion; }
    public void setHoraCancelacion(LocalTime horaCancelacion) { this.horaCancelacion = horaCancelacion; }
}
