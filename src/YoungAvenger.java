import javax.swing.*;

public class YoungAvenger {
    public int codigo;
    public String nombre;
    public String poder;
    public String nivelHabilidad;
    public int misionActiva;
    public int tamanio;
    public Nodo inicio;

    public YoungAvenger(int codigo, String nombre, String poder, String nivelHabilidad, int misionActiva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poder = poder;
        this.nivelHabilidad = nivelHabilidad;
        this.misionActiva = misionActiva;
        this.tamanio= 0;
        this.inicio=null;
    }

    public int getMisionActiva() {
        return misionActiva;
    }

    public String getNivelHabilidad() {
        return nivelHabilidad;
    }

    public String getPoder() {
        return poder;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void agregarAvenger(YoungAvenger dato, JTextArea textArea){
        Nodo nuevo= new Nodo(dato);
        if (inicio==null){
            inicio=nuevo;
        } else{
            Nodo actual = inicio;
            while(actual.sig != null){
                actual= actual.sig;

            }
            actual.sig=nuevo;
        }
        tamanio++;
    }
    public int buscarAvenger(YoungAvenger dato, JTextArea textArea){
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {

            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.sig;
            posicion++;
        }
        return -1;
    }

    public int ordenarAvenger(YoungAvenger dato){
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {

            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.sig;
            posicion++;
        }
        return -1;
    }
public void mostrarAvenger(JTextArea textArea){
    if (inicio == null) {
        textArea.setText("La lista está vacía!");
    } else {
        StringBuilder listaStr = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null) {
            listaStr.append(actual.dato).append("\n");
            actual = actual.sig;
        }
        textArea.setText((listaStr.toString()));
    }

}
}

