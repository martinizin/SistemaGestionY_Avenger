import javax.swing.*;

public class YoungAvenger {
    public int codigo;
    public String nombre;
    public String poder;
    public String nivelHabilidad;
    public int misionActiva;
    public int tamanio;
    public NodoAvengers inicio;

    // Constructor con todos los datos


    public YoungAvenger(int codigo, String nombre, String poder, String nivelHabilidad, int misionActiva, int tamanio, NodoAvengers inicio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poder = poder;
        this.nivelHabilidad = nivelHabilidad;
        this.misionActiva = misionActiva;
        this.tamanio = tamanio;
        this.inicio = inicio;
    }

    // Constructor vacío para usar en la clase GUI
    public YoungAvenger() {
        this.inicio = null;
        this.tamanio = 0;
    }

    public void agregarAvenger(YoungAvenger dato) {
        NodoAvengers nuevo = new NodoAvengers(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoAvengers actual = inicio;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
        tamanio++;
    }

    public int buscarAvenger(int codigo) {
        NodoAvengers actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato.codigo == codigo) {
                return posicion;
            }
            actual = actual.sig;
            posicion++;
        }
        return -1;
    }

    public void mostrarAvenger(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía!");
        } else {
            StringBuilder listaStr = new StringBuilder();
            NodoAvengers actual = inicio;
            while (actual != null) {
                listaStr.append("Código: ").append(actual.dato.codigo)
                        .append(", Nombre: ").append(actual.dato.nombre)
                        .append(", Poder: ").append(actual.dato.poder)
                        .append(", Nivel: ").append(actual.dato.nivelHabilidad)
                        .append(", Misión Activa: ").append(actual.dato.misionActiva)
                        .append("\n");
                actual = actual.sig;
            }
            textArea.setText(listaStr.toString());
        }
    }

    public void ordenarAvengers() {
        if (inicio == null || inicio.sig == null) {
            return;
        }
        NodoAvengers actual = inicio;
        NodoAvengers siguiente;
        YoungAvenger temp;
        while (actual != null) {
            siguiente = actual.sig;
            while (siguiente != null) {
                if (actual.dato.codigo > siguiente.dato.codigo) {
                    temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                }
                siguiente = siguiente.sig;
            }
            actual = actual.sig;
        }
    }

    public void avengersConPoder(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía!");
        } else {
            StringBuilder listaStr = new StringBuilder();
            NodoAvengers actual = inicio;
            while (actual != null) {
                if (!actual.dato.poder.isEmpty()) {
                    listaStr.append("Código: ").append(actual.dato.codigo)
                            .append(", Nombre: ").append(actual.dato.nombre)
                            .append(", Poder: ").append(actual.dato.poder)
                            .append("\n");
                }
                actual = actual.sig;
            }
            textArea.setText(listaStr.toString());
        }
    }

    public void avengersSinPoder(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía!");
        } else {
            StringBuilder listaStr = new StringBuilder();
            NodoAvengers actual = inicio;
            while (actual != null) {
                if (actual.dato.poder.isEmpty()) {
                    listaStr.append("Código: ").append(actual.dato.codigo)
                            .append(", Nombre: ").append(actual.dato.nombre)
                            .append("\n");
                }
                actual = actual.sig;
            }
            textArea.setText(listaStr.toString());
        }
    }
    public int calcularMisionesActivas() {
        int contador = 0;
        NodoAvengers actual = inicio;  // asumiendo que 'inicio' es el primer nodo de la lista de Avengers
        while (actual != null) {
            if (actual.dato.misionActiva != 0) {
                contador++;  // Contamos Avengers con misión activa diferente de 0
            }
            actual = actual.sig;  // Pasamos al siguiente Avenger en la lista
        }
        return contador;  // Retorna el número de Avengers con misiones activas
    }



}
