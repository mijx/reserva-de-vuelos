public class Asiento {
    //Atributos de Asiento, numero de asiento y su disponibilidad
    private String numero;
    private boolean disponible;

    //Metodo Constructor
    public Asiento(String numero, boolean disponible) {
        this.numero = numero;
        this.disponible = disponible;
    }

    //Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Revisa si esta ocupado o no
    public boolean estaOcupado(){
        return getDisponible();
    }
    //Cambia el estado a ocupado
    public void ocupar(){
        setDisponible(false);
    }
    //Cambia el estado a libre
    public void liberar(){
        setDisponible(true);
    }
}
