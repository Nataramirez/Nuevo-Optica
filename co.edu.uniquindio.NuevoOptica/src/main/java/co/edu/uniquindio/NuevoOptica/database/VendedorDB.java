package co.edu.uniquindio.NuevoOptica.database;

public enum VendedorDB {
    VENDENDOR_1("Nicolás Upegui", "1098123456", 1200000, 0),
    VENDEDOR_2("Jerónimo Osorio", "1099123456", 1200000, 0),
    VENDEDOR_3("Augusto Álvarez", "1001123456", 1200000, 0),
    VENDEDOR_4("Camilo Marulanda", "1002123456", 1200000, 0);

    private String nombre;
    private String documento;
    private float salario;
    private float comision;

    VendedorDB(String nombre, String documento, float salario, float comision) {
        this.nombre = nombre;
        this.documento = documento;
        this.salario = salario;
        this.comision = comision;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public float getSalario() {
        return salario;
    }

    public float getComision() {
        return comision;
    }
}
