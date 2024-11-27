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
}
