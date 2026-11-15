import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double entrada;

        try {
            System.out.print("Ingrese la entrada: ");
            entrada = Double.parseDouble(br.readLine());

        } catch (NumberFormatException e) {
            System.out.println("Error: formato de número incorrecto.");
        } catch (IOException e) {
            System.out.println("Error en la entrada o salida de datos.");
        } catch (Exception e) {
            System.out.println("Error general.");
        }
    }
}
