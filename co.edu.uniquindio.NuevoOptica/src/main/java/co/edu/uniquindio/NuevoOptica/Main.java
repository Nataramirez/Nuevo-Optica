package co.edu.uniquindio.NuevoOptica;

import co.edu.uniquindio.NuevoOptica.database.ClienteDB;
import co.edu.uniquindio.NuevoOptica.database.OptometraDB;
import co.edu.uniquindio.NuevoOptica.database.VendedorDB;
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

        Diagnostico diagnostico1 = optica.crearDiagnostico(
                GradoLente.GRADO_075,
                ProblemaVisual.ASTIGMATISMO,
                optica.getListaClientes().get(1),
                optica.obtenerOptometras().get(1)
        );

        optica.crearLente(diagnostico1, Montura.ACERO_INOXIDABLE, Filtro.UV);
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