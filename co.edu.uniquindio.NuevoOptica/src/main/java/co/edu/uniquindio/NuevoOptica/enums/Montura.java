package co.edu.uniquindio.NuevoOptica.enums;

public enum Montura {
    TITANIO("Titanio", 200000),
    ALUMINIO("Aluminio", 100000),
    ACERO_INOXIDABLE("Acero inoxidable", 50000),
    PLASTICO("Plástico", 25000),
    ACETATO("Acetato", 12500);
    private final String nombre;
    private final float precio;

    Montura(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }
}
