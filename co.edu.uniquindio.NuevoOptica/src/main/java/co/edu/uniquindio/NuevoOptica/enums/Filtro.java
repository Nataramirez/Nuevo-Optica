package co.edu.uniquindio.NuevoOptica.enums;

public enum Filtro {
    ANTIREFLEJO("Antireflejo", 200000),
    UV("uv", 40000),
    HIDROFOBICO("Hidrofobico", 80000),
    COLORACION("Coloración", 160000),
    ANTI_RAYAS("Anti-Rayas", 200000),
    FOTOCROMATICO("Fotocromatico", 300000),
    POLARIZADO("Polarzadoo", 350000),
    ESPEJADO("Espejado", 450000);

    private String nombre;
    private float precio;

    Filtro(String nombre, float precio) {
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
