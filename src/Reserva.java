import java.time.LocalTime;

public class Reserva extends Transaccion {
    private LocalTime horaReserva;

    public Reserva(String nombre, String numAsiento, LocalTime horaReserva) {
        super(nombre, numAsiento, "Reserva");
        this.horaReserva = horaReserva;
    }

    public LocalTime getHoraReserva() { return horaReserva; }
    public void setHoraReserva(LocalTime horaReserva) { this.horaReserva = horaReserva; }
}
