package co.edu.uniquindio.NuevoOptica.database;

import co.edu.uniquindio.NuevoOptica.enums.Filtro;
import co.edu.uniquindio.NuevoOptica.enums.Montura;

public enum LenteDB {
    LENTE_CLIENTE_1(DiagnosticoDB.DIAGNOSTICO_CLIENTE_1, Montura.ACETATO, Filtro.ANTIREFLEJO),
    LENTE_CLIENTE_2(DiagnosticoDB.DIAGNOSTICO_CLIENTE_2, Montura.ALUMINIO, Filtro.ESPEJADO),
    LENTE_CLIENTE_3(DiagnosticoDB.DIAGNOSTICO_CLIENTE_3, Montura.ACERO_INOXIDABLE, Filtro.HIDROFOBICO),
    LENTE_CLIENTE_4(DiagnosticoDB.DIAGNOSTICO_CLIENTE_4, Montura.PLASTICO, Filtro.COLORACION),
    LENTE_CLIENTE_5(DiagnosticoDB.DIAGNOSTICO_CLIENTE_5, Montura.TITANIO, Filtro.POLARIZADO);
    private DiagnosticoDB diagnosticoDB;
    private Montura montura;
    private Filtro filtro;

    LenteDB(DiagnosticoDB diagnosticoDB, Montura montura, Filtro filtro) {
        this.diagnosticoDB = diagnosticoDB;
        this.montura = montura;
        this.filtro = filtro;
    }

    public DiagnosticoDB getDiagnosticoDB() {
        return diagnosticoDB;
    }

    public Montura getMontura() {
        return montura;
    }

    public Filtro getFiltro() {
        return filtro;
    }
}
