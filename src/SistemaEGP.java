import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalTime;
import java.io.FileWriter;


public class SistemaEGP {

    //Listas para almacenar los asientos, las reservas, las cancelaciones y las transacciones totales
    private ArrayList<Asiento> asientos;
    private ArrayList<Cancelacion> cancelaciones;
    private ArrayList<Reserva> reservas;
    private ArrayList<Reserva> historial;

    //Metodo Constructor
    public SistemaEGP() {
        this.asientos = new ArrayList<>();
        this.cancelaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    //Getters y Setters
    public ArrayList<Asiento> getAsientos() { return asientos; }

    public void setAsientos(ArrayList<Asiento> asientos) { this.asientos = asientos; }

    public ArrayList<Cancelacion> getCancelaciones() { return cancelaciones; }

    public void setCancelaciones(ArrayList<Cancelacion> cancelaciones) { this.cancelaciones = cancelaciones; }

    public ArrayList<Reserva> getReservas() { return reservas; }

    public void setReservas(ArrayList<Reserva> reservas) { this.reservas = reservas; }

    public ArrayList<Reserva> getHistorial() { return historial; }

    public void setHistorial(ArrayList<Reserva> historial) { this.historial = historial; }

    //Metodo reservar
    public boolean reservar(Reserva reserva) {
        //For continua hasta que llega al tamaño de la list asientos
        for (int i = 0; i < asientos.size(); i++) {
            //Objeto Asiento temporal contiene el valor del elemento de la lista asientos i
            Asiento asiento = asientos.get(i);
            //Es true si el numero de asiento es igual al numero introducido para la reserva
            if (asiento.getNumero().equals(reserva.getNumAsiento())) {
                //Verifica que el asiento esta disponible
                if (asiento.estaOcupado()) {
                    //Cambia el asiento a no disponible y añade la reserva a la lista oficial y al historial
                    asiento.ocupar();
                    reservas.add(reserva);
                    historial.add(reserva);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void MostrarAsientos() {
        System.out.println("\n\t\tASIENTOS DISPONIBLES Y OCUPADOS");
        //For continua hasta recorrer el tamaño de la lista asientos
        //En la pantalla se ve como una larga lista de cada asiento y su estado
        for (int i = 0; i < asientos.size(); i++) {
            //Crea objeto temporal asiento con el valor del elemento i de asientos
            Asiento asiento = asientos.get(i);
            System.out.println("\nAsiento: " + asiento.getNumero());
            //Revisa si el asiento esta disponible o no e informa al usuario
            if (asiento.estaOcupado()) { System.out.println("Estado: Disponible"); }
            else { System.out.println("Estado: Ocupado"); }
        }
    }

    //Metodo cancelar
    public boolean cancelar(String nombre, String numero) {
        //For continua hasta recorrer el tamaño de la lista reservas
        for (int i = 0; i < reservas.size(); i++) {
            //Objeto temporal reserva contiene el valor del elemento i de reservas
            Reserva reserva = reservas.get(i);
            //Es true si el nombre y numeros introducidos son iguales al de una reserva existentes
            //Si es true entonces se recorre hasta encontrar el objeto asiento correspondiente
            if (reserva.getNombre().equalsIgnoreCase(nombre) && reserva.getNumAsiento().equals(numero)) {
                //For continua hasta recorrer el tamaño de la lista asientos
                for (int j = 0; j < asientos.size(); j++) {
                    //Objeto temporal asiento contiene el valor del elemento j de asientos
                    Asiento asiento = asientos.get(j);
                    //Es true si el numero introducido es igual al numero del asiento
                    if (asiento.getNumero().equals(numero)) {
                        //Hace que el asiento sea disponible
                        asiento.liberar();
                        break;
                    }
                }
                //Crea un objeto cancelacion con los datos de la reserva a ser eliminada y la hora actual
                Cancelacion cancelacion = new Cancelacion(
                        reserva.getNombre(),
                        reserva.getNumAsiento(),
                        LocalTime.now()
                );
                //Se añade la cancelacion a la lista
                cancelaciones.add(cancelacion);
                //Se elimina la reserva
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    //Metodo crearReporte
    public void crearReporte() {
        try {
            //Crea un nuevo archivo de texto
            FileWriter archivo = new FileWriter("reporte_EGP.txt");
            archivo.write("===== RESERVAS =====\n\n");
            //For continua hasta recorrer el tamaño de la lista historial
            for (int i = 0; i < historial.size(); i++) {
                //Escribe cada reserva realizada durante la sesion y sus datos, sin importar si esta eliminada o no
                Reserva reserva = historial.get(i);
                archivo.write("\nNombre: " + reserva.getNombre() + "\n");
                archivo.write("Puesto reservado: " + reserva.getNumAsiento() + "\n");
                archivo.write("Hora de reserva: " + reserva.getHoraReserva() + "\n");
            }
            archivo.write("\n===== CANCELACIONES =====\n\n");
            //For continua hasta recorrer el tamaño de la lista cancelaciones
            for (int i = 0; i < cancelaciones.size(); i++) {
                //Escribe cada cancelacion realizada durante la sesion y sus datos
                Cancelacion cancelacion = cancelaciones.get(i);
                archivo.write("\nNombre: " + cancelacion.getNombre() + "\n");
                archivo.write("Puesto cancelado: " + cancelacion.getNumAsiento() + "\n");
                archivo.write("Hora de cancelacion: " + cancelacion.getHoraCancelacion() + "\n");
            }
            archivo.close();
            System.out.println("Reporte creado exitosamente");
        } catch (IOException e) {
            System.out.println("Error al crear el reporte.");
        }
    }
}

