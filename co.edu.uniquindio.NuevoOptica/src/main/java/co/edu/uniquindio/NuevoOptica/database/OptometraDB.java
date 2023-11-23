package co.edu.uniquindio.NuevoOptica.database;

public enum OptometraDB {
    OPTOMETRA_1("Silvana Castro", "24572572", 3500000, "8:00am-4:00pm"),
    OPTOMETRA_2("Mario Calderon", "24572573", 3500000, "10:00am-6:00pm");
    private String nombre;
    private String documento;
    private float salario;
    private String horario;

    OptometraDB(String nombre, String documento, float salario, String horario) {
        this.nombre = nombre;
        this.documento = documento;
        this.salario = salario;
        this.horario = horario;
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

    public String getHorario() {
        return horario;
    }
}
