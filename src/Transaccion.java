public class Transaccion {
    //Nimbre, numero de asinto y tipo de cada transaccion
    private String nombre;
    private String numAsiento;
    private String tipo;

    //Metodo constructor
    public Transaccion(String nombre, String numAsiento, String tipo) {
        this.nombre = nombre;
        this.numAsiento = numAsiento;
        this.tipo = tipo;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
