package co.edu.uniquindio.NuevoOptica.model;

import co.edu.uniquindio.NuevoOptica.enums.GradoLente;
import co.edu.uniquindio.NuevoOptica.enums.ProblemaVisual;

import java.util.UUID;

public class Diagnostico {
    private String id;
    private GradoLente gradoLente;
    private ProblemaVisual problemaVisual;
    private Optometra optometra;
    private Cliente cliente;
    Optica ownedByOptica;

    public Diagnostico(){}
    public Diagnostico(GradoLente gradoLente, ProblemaVisual problemaVisual, Cliente cliente, Optometra optometra) {
        this.gradoLente = gradoLente;
        this.problemaVisual = problemaVisual;
        this.cliente = cliente;
        this.optometra = optometra;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public GradoLente getGradoLente() {
        return gradoLente;
    }

    public void setGradoLente(GradoLente gradoLente) {
        this.gradoLente = gradoLente;
    }

    public ProblemaVisual getProblemaVisual() {
        return problemaVisual;
    }

    public void setProblemaVisual(ProblemaVisual problemaVisual) {
        this.problemaVisual = problemaVisual;
    }

    public Optometra getOptometra() {
        return optometra;
    }

    public void setOptometra(Optometra optometra) {
        this.optometra = optometra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Optica getOwnedByOptica() {
        return ownedByOptica;
    }

    public void setOwnedByOptica(Optica ownedByOptica) {
        this.ownedByOptica = ownedByOptica;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id='" + id + '\'' +
                ", gradoLente=" + gradoLente +
                ", problemaVisual=" + problemaVisual +
                ", optometra=" + optometra +
                ", cliente=" + cliente +
                '}';
    }
}
