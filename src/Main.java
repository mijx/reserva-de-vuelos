import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;


// Pahola Jiménez / 8-1049-596
//
//Estephanie Pérez / 20-14-9466
//
//Miguel Arrocha / 8-1015-642
//
//Samuel Añorve / 8-1048-1842
//
//1IL122

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Creacion de objeto sistema
        SistemaEGP sistema = new SistemaEGP();
        //Creacion de 20 asientos
        for (int i = 1; i <= 20; i++) {
            Asiento asiento = new Asiento(String.valueOf(i), true);
            sistema.getAsientos().add(asiento);
        }
        //inicializacion de variables que controlan los bloques de codigo
        int opcion = 0;
        boolean exit = true;
        do {
            try {
                //Menu de opciones
                System.out.println("\nSISTEMA DE RESERVA");
                System.out.println("\t1. Mostrar puestos");
                System.out.println("\t2. Reservar un puesto");
                System.out.println("\t3. Cancelar una reserva");
                System.out.println("\t4. Salir y generar reporte");
                System.out.println("Seleccione una opcion: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        //Invocacion de metodo MostrarAsientos
                        sistema.MostrarAsientos();
                        break;
                    case 2:
                        //Reserva requiere nombre y numero de asiento
                        System.out.println("Ingrese su nombre: ");
                        String nombre = br.readLine();
                        System.out.println("Ingrese el puesto que desea reservar (del #1 al #20): ");
                        String numero = br.readLine();
                        //Precaucion para evitar asientos que no existen
                        if ((Integer.parseInt(numero) < 0) && (Integer.parseInt(numero) > 20)) {
                            System.out.println("El numero de asiento no existe");
                            break;
                        }
                        //Creacion de un objeto Reserva
                        Reserva reserva = new Reserva(nombre, numero, LocalTime.now());
                        //Invocacion de metodo reservar, si a true significa que la reservacion fue exitosa
                        if (sistema.reservar(reserva)) {
                            System.out.println("Reserva realizada correctamente");
                            System.out.println("Cliente: " + nombre);
                            System.out.println("Numero de puesto: " + numero);
                        } else {
                            System.out.println("Lo sentimos el asiento no esta disponible o no existe");
                        }
                        break;
                    case 3:
                        //Similar al anterior
                        System.out.println("Ingrese su nombre: ");
                        String nombre2 = br.readLine();
                        System.out.println("Ingrese el numero de asiento: ");
                        String numero2 = br.readLine();
                        //Nombre y numero utilizados para localizar y eliminar
                        //Metodo cancelar invocado, si da true, eliminacion fue exitosa
                        if (sistema.cancelar(nombre2, numero2)) {
                            System.out.println("Reserva cancelada exitosamente");
                        } else {
                            System.out.println("No se encontro una reserva con ese nombre");
                        }
                        break;
                    case 4:
                        System.out.println("Gracias por elegir nuestro Sistema. Cerrando...");
                        //Metodo crearReporte invocado, archivo de texto generado
                        sistema.crearReporte();
                        //Bucle terminado
                        exit = false;
                        break;
                    default:
                        System.out.println("Opcion no existe. Intente de Nuevo");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: formato de número incorrecto.");
            } catch (IOException e) {
                System.out.println("Error en la entrada o salida de datos.");
            } catch (Exception e) {
                System.out.println("Error general.");
            }
        } while (exit);
    }
}
