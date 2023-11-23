package co.edu.uniquindio.NuevoOptica.enums;

public enum ProblemaVisual {
    MIOPIA("Miopia", 100000), ASTIGMATISMO("Astigmatismo", 150000);
    private String nombre;
    private double precio;

    ProblemaVisual(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
