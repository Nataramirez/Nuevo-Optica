package co.edu.uniquindio.NuevoOptica.database;

public enum ClienteDB {
    CLIENTE_1("Cecilia Perez","1206254846","320310310",
            "cecilia@mail.com", 38),
    CLIENTE_2("Víctor Romero","1238070113","320310311",
            "victor@mail.com", 35),
    CLIENTE_3("Oscar Flores","1212647432", "320310312",
            "oscar@mail.com", 29),
    CLIENTE_4("Nicolás Alvarez","1236897833", "320310313",
            "nicolas@mail.com", 45),
    CLIENTE_5("Martín Herrera","1230481593", "320310314",
            "martin@mail.com", 26);

    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private int edad;

    ClienteDB(String nombre, String documento, String telefono, String correo, int edad){
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }
}
