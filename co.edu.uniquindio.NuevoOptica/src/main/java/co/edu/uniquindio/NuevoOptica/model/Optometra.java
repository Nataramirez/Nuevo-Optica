package co.edu.uniquindio.NuevoOptica.model;

import java.util.ArrayList;
import java.util.List;

public class Optometra extends Empleado{
    private String horario;
    public List<Diagnostico> listaDiagnosticos = new ArrayList<>();

    public Optometra() {}

    public Optometra(String nombre, String documento, float salario, String horario) {
        super(nombre, documento, salario);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Diagnostico> getListaDiagnosticos() {
        return listaDiagnosticos;
    }

    public void setListaDiagnosticos(List<Diagnostico> listaDiagnosticos) {
        this.listaDiagnosticos = listaDiagnosticos;
    }

    @Override
    public String toString() {
        return "Optometra{" +
                "horario='" + horario + '\'' +
                "} " + super.toString();
    }
}
