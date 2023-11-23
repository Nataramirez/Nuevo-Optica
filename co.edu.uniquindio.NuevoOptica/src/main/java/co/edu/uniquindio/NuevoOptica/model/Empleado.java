package co.edu.uniquindio.NuevoOptica.model;

public abstract class Empleado {
    private String nombre;
    private String documento;
    private float salario;

    Optica ownedByOptica;

    public Empleado(){}

    public Empleado(String nombre, String documento, float salario){
        this.nombre = nombre;
        this.documento = documento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Optica getOwnedByOptica() {
        return ownedByOptica;
    }

    public void setOwnedByOptica(Optica ownedByOptica) {
        this.ownedByOptica = ownedByOptica;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre = '" + nombre + '\'' +
                ", documento = '" + documento + '\'' +
                ", salario = " + salario +
                '}';
    }
}
