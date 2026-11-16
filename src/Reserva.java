import java.time.LocalTime;

public class Reserva extends Transaccion {
    //Atributo de Reserva, tiempo en que se realiza la reserva
    private LocalTime horaReserva;

    //Metodo Constructor
    public Reserva(String nombre, String numAsiento, LocalTime horaReserva) {
        super(nombre, numAsiento, "Reserva");
        this.horaReserva = horaReserva;
    }

    //Getter y Setter
    public LocalTime getHoraReserva() { return horaReserva; }
    public void setHoraReserva(LocalTime horaReserva) { this.horaReserva = horaReserva; }
}
