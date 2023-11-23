package co.edu.uniquindio.NuevoOptica;

import co.edu.uniquindio.NuevoOptica.database.*;
import co.edu.uniquindio.NuevoOptica.enums.*;
import co.edu.uniquindio.NuevoOptica.model.Diagnostico;
import co.edu.uniquindio.NuevoOptica.model.EntradaConsola;
import co.edu.uniquindio.NuevoOptica.model.Optica;

public class Main {
    public static void main(String[] args) {

        Optica optica = inicializarDatosPrueba();
        ejecutarAplicacion(optica);
    }

    /**
     * Método para la inicialización de datos de la aplicación
     *
     * @return
     */
    private static Optica inicializarDatosPrueba() {
        Optica optica = new Optica();
        for (ClienteDB cliente : ClienteDB.values()) {
            optica.crearUsuario(
                    cliente.getNombre(),
                    cliente.getDocumento(),
                    cliente.getTelefono(),
                    cliente.getCorreo(),
                    cliente.getEdad()
            );
        }
        for (VendedorDB vendedor : VendedorDB.values()) {
            optica.crearUsuario(
                    vendedor.getNombre(),
                    vendedor.getDocumento(),
                    vendedor.getSalario()
            );
        }
        for (OptometraDB optometra : OptometraDB.values()) {
            optica.crearUsuario(
                    optometra.getNombre(),
                    optometra.getDocumento(),
                    optometra.getSalario(),
                    optometra.getHorario()
            );
        }

        optica.crearDiagnostico(
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_1.getGradoLente(),
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_1.getProblemaVisual(),
                optica.getListaClientes().get(0),
                optica.obtenerOptometras().get(1)
        );
        optica.crearDiagnostico(
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_2.getGradoLente(),
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_2.getProblemaVisual(),
                optica.getListaClientes().get(1),
                optica.obtenerOptometras().get(0)
        );
        optica.crearDiagnostico(
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_3.getGradoLente(),
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_3.getProblemaVisual(),
                optica.getListaClientes().get(2),
                optica.obtenerOptometras().get(0)
        );
        optica.crearDiagnostico(
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_4.getGradoLente(),
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_4.getProblemaVisual(),
                optica.getListaClientes().get(3),
                optica.obtenerOptometras().get(1)
        );
        optica.crearDiagnostico(
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_5.getGradoLente(),
                DiagnosticoDB.DIAGNOSTICO_CLIENTE_5.getProblemaVisual(),
                optica.getListaClientes().get(4),
                optica.obtenerOptometras().get(0)
        );



        optica.crearLente(optica.getListaDiagnosticos().get(0),LenteDB.LENTE_CLIENTE_1.getMontura(),LenteDB.LENTE_CLIENTE_1.getFiltro());
        optica.crearLente(optica.getListaDiagnosticos().get(1),LenteDB.LENTE_CLIENTE_2.getMontura(),LenteDB.LENTE_CLIENTE_2.getFiltro());
        optica.crearLente(optica.getListaDiagnosticos().get(2),LenteDB.LENTE_CLIENTE_3.getMontura(),LenteDB.LENTE_CLIENTE_3.getFiltro());
        optica.crearLente(optica.getListaDiagnosticos().get(3),LenteDB.LENTE_CLIENTE_4.getMontura(),LenteDB.LENTE_CLIENTE_4.getFiltro());
        optica.crearLente(optica.getListaDiagnosticos().get(4),LenteDB.LENTE_CLIENTE_5.getMontura(),LenteDB.LENTE_CLIENTE_5.getFiltro());

        return optica;
    }

    private static void ejecutarAplicacion(Optica optica) {
        int ejecutarAplicacion = 1;
        while (ejecutarAplicacion == 1) {
            String proceso = EntradaConsola.tipoProceso();
            ejecutarAplicacion = EntradaConsola.cerrarApliacion(proceso);
            if (proceso != null) {
                String crud = EntradaConsola.tipoCrud(proceso);
                ejecutarAplicacion = EntradaConsola.cerrarApliacion(crud);
                if (crud != null) {
                    ejecutarAplicacion = EntradaConsola.ejecutarCrud(proceso, crud, optica);
                }
            }
        }
    }
}