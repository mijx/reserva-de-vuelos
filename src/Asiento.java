public class Asiento {
    private String numero;
    private boolean disponible;

    public Asiento(String numero, boolean disponible) {
        this.numero = numero;
        this.disponible = disponible;
    }

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

    public boolean estaOcupado(){
        return !getDisponible();
    }

    public void ocupar(){
        setDisponible(false);
    }

    public void liberar(){
        setDisponible(true);
    }



}
