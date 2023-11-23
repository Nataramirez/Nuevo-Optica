package co.edu.uniquindio.NuevoOptica.model;

import co.edu.uniquindio.NuevoOptica.controller.Crud;
import co.edu.uniquindio.NuevoOptica.controller.Proceso;
import co.edu.uniquindio.NuevoOptica.enums.GradoLente;
import co.edu.uniquindio.NuevoOptica.enums.ProblemaVisual;
import co.edu.uniquindio.NuevoOptica.enums.TipoUsuario;

import javax.swing.*;
import java.util.List;

public class EntradaConsola {
    /**
     * Método para seleccionar el proceso que desea gestionar el usuario
     * @return proceso<String>
     */
    public static String tipoProceso(){
        String proceso = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el proceso que desea gestionar",
                "PROCESO", JOptionPane.DEFAULT_OPTION,
                null,
                Proceso.proceso(),
                null);
        return proceso;
    }

    /**
     * Método para el tipo de acción a ejecutar, CREAR, LEER, ACTUALIZAR O ELIMINAR
     * @param proceso
     * @return proceso<String>
     */
    public static String tipoCrud(String proceso){
        String resp = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una acción a ejecutar",
                "CRUD", JOptionPane.DEFAULT_OPTION,
                null,
                Crud.crud(proceso),
                null);
        return resp;
    }

    /**
     * Método para llamar el tipo de CRUD de acuerdo al proceso
     * @param proceso
     * @param crud
     * @return
     */
    public static int ejecutarCrud(String proceso, String crud, Optica optica){
        int cerrarAplicacion = 1;
        if(crud.contains(Crud.CREATE.getNombre())){
            cerrarAplicacion = EntradaConsola.crear(proceso, optica);
        }
        if(crud.contains(Crud.READ.getNombre())){
            cerrarAplicacion = EntradaConsola.leer(proceso, optica);
        }
        if(crud.contains(Crud.DELETE.getNombre())){
            cerrarAplicacion = EntradaConsola.eliminar(proceso, optica);
        }
        /**
        if(crud.contains(Crud.UPDATE.getNombre())){
            cerrarAplicacion = EntradaConsola.actualizar(proceso);
        }**/

        return cerrarAplicacion;
    }

    /**
     * Método para crear usuarios o transacciones de acuerdo al proceso seleccionado
     * @param proceso
     * @param optica
     * @return
     */
    public static int crear(String proceso, Optica optica){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            while(cerrar == 1){
                String nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del cliente");
                int cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                if(cerrarAplicacionEnNombre == 0){
                    cerrar = cerrarAplicacionEnNombre;
                    return cerrar;
                } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                    nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del cliente");
                    cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                }
                String cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente");
                int cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                if(cerrarAplicacionEnCedula == 0){
                    cerrar = cerrarAplicacionEnCedula;
                    return cerrar;
                } else if (cerrarAplicacionEnCedula == 1 && cedula == null) {
                    cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente");
                    cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                }
                String telefono = JOptionPane.showInputDialog("Ingrese teléfono del cliente");
                int cerrarAplicacionEnTelefono = cerrarApliacion(telefono);
                if(cerrarAplicacionEnTelefono == 0){
                    cerrar = cerrarAplicacionEnTelefono;
                    return cerrar;
                } else if (cerrarAplicacionEnTelefono == 1 && telefono == null) {
                    telefono = JOptionPane.showInputDialog("Ingrese teléfono del cliente");
                    cerrarAplicacionEnTelefono = cerrarApliacion(telefono);
                }
                String correo = JOptionPane.showInputDialog("Ingrese correo del cliente");
                int cerrarAplicacionEnCorreo = cerrarApliacion(correo);
                if(cerrarAplicacionEnCorreo == 0){
                    cerrar = cerrarAplicacionEnCorreo;
                    return cerrar;
                } else if (cerrarAplicacionEnCorreo == 1 && correo == null) {
                    correo = JOptionPane.showInputDialog("Ingrese correo del cliente");
                    cerrarAplicacionEnCorreo = cerrarApliacion(correo);
                }
                Integer edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad del cliente"));
                if(edad == null){
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para la edad del cliente"));
                }
                int cerrarAplicacionEnEdad = cerrarApliacion(edad);
                if(cerrarAplicacionEnEdad == 0){
                    cerrar = cerrarAplicacionEnEdad;
                    return cerrar;
                } else if (cerrarAplicacionEnEdad == 1 && edad == null) {
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad del cliente"));
                    cerrarAplicacionEnEdad = cerrarApliacion(edad);
                }
                boolean respuesta = optica.crearUsuario(nombre, cedula, telefono, correo, edad);
                if(respuesta) {
                    JOptionPane.showMessageDialog(null,"El cliente se ha creado con éxito");
                }else {
                    JOptionPane.showMessageDialog(null,"EL cliente ya existe. Cliente NO creado");
                }
                cerrar = cerrarAplicacion();
                return cerrar;
            }
        }
        if(proceso.equals(Proceso.VENDEDOR.getNombre())){
            while(cerrar == 1){
                String nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del Vendedor");
                int cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                if(cerrarAplicacionEnNombre == 0){
                    cerrar = cerrarAplicacionEnNombre;
                    return cerrar;
                } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                    nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del Vendedor");
                    cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                }
                String cedula = JOptionPane.showInputDialog("Ingrese cedula del Vendedor");
                int cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                if(cerrarAplicacionEnCedula == 0){
                    cerrar = cerrarAplicacionEnCedula;
                    return cerrar;
                } else if (cerrarAplicacionEnCedula == 1 && cedula == null) {
                    cedula = JOptionPane.showInputDialog("Ingrese cedula del Vendedor");
                    cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                }
                Float salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese salario del Vendedor"));
                if(salario == null){
                    salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un valor numerico para el salario"));
                }
                int cerrarAplicacionEnSalario = cerrarApliacion(salario);
                if(cerrarAplicacionEnSalario == 0){
                    cerrar = cerrarAplicacionEnSalario;
                    return cerrar;
                } else if (cerrarAplicacionEnSalario == 1 && salario == null) {
                    salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese salario del Vendedor"));
                    cerrarAplicacionEnSalario = cerrarApliacion(salario);
                }
                boolean respuesta = optica.crearUsuario(nombre, cedula, salario);
                if(respuesta) {
                    JOptionPane.showMessageDialog(null,"El vendedor se ha creado con éxito");
                }else {
                    JOptionPane.showMessageDialog(null,"EL vendedor ya existe. Cliente NO creado");
                }
                cerrar = cerrarAplicacion();
                return cerrar;
            }
        }
        if(proceso.equals(Proceso.OPTOMETRA.getNombre())){
            while(cerrar == 1){
                String nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del Optometra");
                int cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                if(cerrarAplicacionEnNombre == 0){
                    cerrar = cerrarAplicacionEnNombre;
                    return cerrar;
                } else if (cerrarAplicacionEnNombre == 1 && nombre == null) {
                    nombre = JOptionPane.showInputDialog("Ingrese nombre y apellido del Optometra");
                    cerrarAplicacionEnNombre = cerrarApliacion(nombre);
                }
                String cedula = JOptionPane.showInputDialog("Ingrese cedula del Optometra");
                int cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                if(cerrarAplicacionEnCedula == 0){
                    cerrar = cerrarAplicacionEnCedula;
                    return cerrar;
                } else if (cerrarAplicacionEnCedula == 1 && cedula == null) {
                    cedula = JOptionPane.showInputDialog("Ingrese cedula del Optometra");
                    cerrarAplicacionEnCedula = cerrarApliacion(cedula);
                }
                Float salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese salario del Optometra"));
                if(salario == null){
                    salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un valor numerico para el salario"));
                }
                int cerrarAplicacionEnSalario = cerrarApliacion(salario);
                if(cerrarAplicacionEnSalario == 0){
                    cerrar = cerrarAplicacionEnSalario;
                    return cerrar;
                } else if (cerrarAplicacionEnSalario == 1 && salario == null) {
                    salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese salario del Optometra"));
                    cerrarAplicacionEnSalario = cerrarApliacion(salario);
                }
                String horario = JOptionPane.showInputDialog("Ingrese horario del Optometra");
                int cerrarAplicacionEnHorario = cerrarApliacion(horario);
                if(cerrarAplicacionEnHorario == 0){
                    cerrar = cerrarAplicacionEnHorario;
                    return cerrar;
                } else if (cerrarAplicacionEnHorario == 1 && horario == null) {
                    horario = JOptionPane.showInputDialog("Ingrese horario del Optometra");
                    cerrarAplicacionEnHorario = cerrarApliacion(horario);
                }
                boolean respuesta = optica.crearUsuario(nombre, cedula, salario, horario);
                if(respuesta) {
                    JOptionPane.showMessageDialog(null,"El optometra se ha creado con éxito");
                }else {
                    JOptionPane.showMessageDialog(null,"EL optometra ya existe. Cliente NO creado");
                }
                cerrar = cerrarAplicacion();
                return cerrar;
            }
        }
        if(proceso.equals(Proceso.DIAGNOSTICO.getNombre())){
            while(cerrar == 1){
                String gradoLente = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione el Grado del Lente",
                        "DIAGNOSTICO", JOptionPane.DEFAULT_OPTION,
                        null,
                        GradoLente.tipoGradoLente(),
                        null
                );

                GradoLente lenteEncontrado;
                if(gradoLente != null){
                    for (GradoLente lente: GradoLente.values()) {
                        if(lente.getNombre().equals(gradoLente)){
                            lenteEncontrado = lente;
                        }
                    }
                }else {
                    cerrar = cerrarAplicacion();
                }

                String problemaVisual = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione el Problema Visual",
                        "DIAGNOSTICO", JOptionPane.DEFAULT_OPTION,
                        null,
                        ProblemaVisual.tipoProblemaVisual(),
                        null
                );
                ProblemaVisual problemaVisual1;
                if(problemaVisual != null){
                    for (ProblemaVisual problemaVisual2: ProblemaVisual.values()) {
                        if(problemaVisual2.getNombre().equals(gradoLente)){
                            problemaVisual1 = problemaVisual2;
                        }
                    }
                }else {
                    cerrar = cerrarAplicacion();
                }
            }
        }
        return cerrar;
    }

    /**
     * Método para obtener listado de usuarios o transacciones según el flujo seleccionado
     * @param proceso
     * @param optica
     * @return
     */
    public static int leer(String proceso, Optica optica){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            List<Cliente> listaClientes =  optica.obtenerClientes();
            for(int i = 0; i < listaClientes.size(); i++){
                JOptionPane.showMessageDialog(null,listaClientes.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        if(proceso.equals(Proceso.OPTOMETRA.getNombre())){
            List<Optometra> listaOptometras =  optica.obtenerOptometras();
            for(int i = 0; i < listaOptometras.size(); i++){
                JOptionPane.showMessageDialog(null,listaOptometras.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        if(proceso.equals(Proceso.VENDEDOR.getNombre())){
            List<Vendedor> listaVendedores =  optica.obtenerVendedores();
            for(int i = 0; i < listaVendedores.size(); i++){
                JOptionPane.showMessageDialog(null,listaVendedores.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        if(proceso.equals(Proceso.DIAGNOSTICO.getNombre())){
            List<Diagnostico> listaDiagnosticos =  optica.obtenerDiagnosticos();
            for(int i = 0; i < listaDiagnosticos.size(); i++){
                JOptionPane.showMessageDialog(null,listaDiagnosticos.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        if(proceso.equals(Proceso.LENTE.getNombre())){
            List<Lente> listaLentes =  optica.obtenerLentes();
            for(int i = 0; i < listaLentes.size(); i++){
                JOptionPane.showMessageDialog(null,listaLentes.get(i).toString());
            }
            cerrar = cerrarAplicacion();
        }
        return cerrar;
    }


    public static int eliminar(String proceso, Optica optica){
        int cerrar = 1;
        if(proceso.equals(Proceso.CLIENTE.getNombre())){
            String cedula = JOptionPane.showInputDialog("Ingrese cedula del cliente que desea eliminar");
            if (cedula != null){
                boolean clienteEliminado = optica.eliminarUsuario(cedula, TipoUsuario.CLIENTE);
                if (clienteEliminado){
                    JOptionPane.showMessageDialog(null,"El cliente ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El cliente NO ha ha sido encontrado");
                }
            }
        }
        if(proceso.equals(Proceso.OPTOMETRA.getNombre())){
            String cedula = JOptionPane.showInputDialog("Ingrese cedula del optometra que desea eliminar");
            if(cedula != null){
                boolean optometraEliminado = optica.eliminarUsuario(cedula, TipoUsuario.OPTOMETRA);
                if(optometraEliminado){
                    JOptionPane.showMessageDialog(null,"El optometra ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El optometra NO ha sido encontrado");
                }
            }
        }
        if(proceso.equals(Proceso.VENDEDOR.getNombre())){
            String cedula = JOptionPane.showInputDialog("Ingrese número de prestamo que desea eliminar");
            if(cedula != null){
                boolean empleadoEliminado = optica.eliminarUsuario(cedula, TipoUsuario.VENDEDOR);
                if(empleadoEliminado){
                    JOptionPane.showMessageDialog(null,"El vendedor ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El vendedor NO ha ha sido encontrado");
                }
            }
        }
        if(proceso.equals(Proceso.DIAGNOSTICO.getNombre())){
            String diagnosticoEliminar = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el diagnostico que desea eliminar",
                    "DIAGNOSTICO", JOptionPane.DEFAULT_OPTION,
                    null,
                     getDiagnosticos(optica),
                    null
            );
            if(diagnosticoEliminar != null){
                boolean diagnosticoEliminado = optica.eliminarDiagnostico(diagnosticoEliminar);
                if(diagnosticoEliminado){
                    JOptionPane.showMessageDialog(null,"El Diagnostico ha sido eliminado");
                }else {
                    JOptionPane.showMessageDialog(null,"El diagnostico NO ha ha sido eliminado");
                }
            }
        }
        return cerrar;
    }

    /**
     * Método para obtener los IDs de la lista de diagnosticos
     * @param optica
     * @return
     */
    public static String[] getDiagnosticos(Optica optica){
        String[] idDiagnosticos = new String[]{};
        for (Diagnostico diagnosticos: optica.obtenerDiagnosticos()) {
            idDiagnosticos = new String[]{
                    diagnosticos.getId()
            };
        }
        return idDiagnosticos;
    }

    /**
     * Método para cerrar la aplicación
     * @return
     */
    public static int cerrarAplicacion(){
        int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                "¿Desea cerrar la aplicación?",
                "Alerta!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE);
        return respuestaCerrar;
    }

    /**
     * Método para cerrar la aplicación validando campos de tipo string
      * @param accion
     * @return
     */
    public static int cerrarApliacion(String accion){
        int cerrar = 1;
        if(accion instanceof String){
            return cerrar;
        }else {
            int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            cerrar = respuestaCerrar;
            return cerrar;
        }
    }

    /**
     * método para cerrar la aplicación validando campos de tipo Integer
     * @param accion
     * @return
     */
    public static int cerrarApliacion(Integer accion){
        int cerrar = 1;
        if(accion instanceof Integer){
            return cerrar;
        }else {
            int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            cerrar = respuestaCerrar;
            return cerrar;
        }
    }

    /**
     * Método para cerrar la aplicación validando campos de tipo Float
     * @param accion
     * @return
     */
    public static int cerrarApliacion(Float accion){
        int cerrar = 1;
        if(accion instanceof Float){
            return cerrar;
        }else {
            int respuestaCerrar = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar la aplicación?",
                    "Alerta!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            cerrar = respuestaCerrar;
            return cerrar;
        }
    }
}
