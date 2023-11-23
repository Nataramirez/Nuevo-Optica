package co.edu.uniquindio.NuevoOptica.model;

import co.edu.uniquindio.NuevoOptica.enums.Filtro;
import co.edu.uniquindio.NuevoOptica.enums.Montura;

import java.util.UUID;

public class Lente {
    private String id;
    private Diagnostico diagnostico;
    private Montura montura;
    private Filtro filtro;
    private DetalleVenta detalleVenta;
    Optica ownedByOptica;

    public Lente(){}
    public Lente(Diagnostico diagnostico, Montura montura, Filtro filtro) {
        this.diagnostico = diagnostico;
        this.montura = montura;
        this.filtro = filtro;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Montura getMontura() {
        return montura;
    }

    public void setMontura(Montura montura) {
        this.montura = montura;
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public Optica getOwnedByOptica() {
        return ownedByOptica;
    }

    public void setOwnedByOptica(Optica ownedByOptica) {
        this.ownedByOptica = ownedByOptica;
    }

    @Override
    public String toString() {
        return "Lente{" +
                "id='" + id + '\'' +
                ", diagnostico=" + diagnostico +
                ", montura=" + montura +
                ", filtro=" + filtro +
                '}';
    }
}
