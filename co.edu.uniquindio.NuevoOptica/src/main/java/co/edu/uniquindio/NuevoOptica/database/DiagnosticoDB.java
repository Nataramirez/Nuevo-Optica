package co.edu.uniquindio.NuevoOptica.database;

import co.edu.uniquindio.NuevoOptica.enums.GradoLente;
import co.edu.uniquindio.NuevoOptica.enums.ProblemaVisual;

public enum DiagnosticoDB {
    DIAGNOSTICO_CLIENTE_1(ProblemaVisual.MIOPIA, GradoLente.GRADO_200),
    DIAGNOSTICO_CLIENTE_2(ProblemaVisual.ASTIGMATISMO, GradoLente.GRADO_025),
    DIAGNOSTICO_CLIENTE_3(ProblemaVisual.MIOPIA, GradoLente.GRADO_100),
    DIAGNOSTICO_CLIENTE_4(ProblemaVisual.MIOPIA, GradoLente.GRADO_025),
    DIAGNOSTICO_CLIENTE_5(ProblemaVisual.ASTIGMATISMO, GradoLente.GRADO_600);

    private ProblemaVisual problemaVisual;
    private GradoLente gradoLente;

    DiagnosticoDB(ProblemaVisual problemaVisual, GradoLente gradoLente) {
        this.problemaVisual = problemaVisual;
        this.gradoLente = gradoLente;
    }

    public ProblemaVisual getProblemaVisual() {
        return problemaVisual;
    }

    public GradoLente getGradoLente() {
        return gradoLente;
    }
}
