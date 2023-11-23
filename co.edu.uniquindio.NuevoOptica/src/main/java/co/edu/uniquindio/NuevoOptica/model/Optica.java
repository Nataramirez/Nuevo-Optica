package co.edu.uniquindio.NuevoOptica.model;

import co.edu.uniquindio.NuevoOptica.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Optica {

    public List<Empleado> listaEmpleados = new ArrayList<>();
    public List<Cliente> listaClientes = new ArrayList<>();
    public List<Lente> listaLentes = new ArrayList<>();
    public List<Diagnostico> listaDiagnosticos = new ArrayList<>();
    public List<Venta> listaVentas = new ArrayList<>();

    public Optica(){}

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Lente> getListaLentes() {
        return listaLentes;
    }

    public void setListaLentes(List<Lente> listaLentes) {
        this.listaLentes = listaLentes;
    }

    public List<Diagnostico> getListaDiagnosticos() {
        return listaDiagnosticos;
    }

    public void setListaDiagnosticos(List<Diagnostico> listaDiagnosticos) {
        this.listaDiagnosticos = listaDiagnosticos;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    /**
     * Método para verificar la existencia de usuarios en la aplicación
     * @param documento
     * @return boolean
     */
    public boolean buscarUsuario(String documento, TipoUsuario tipoUsuario){
        boolean usuarioExiste = false;
        switch (tipoUsuario){
            case CLIENTE: {
                for (Cliente cliente: getListaClientes()) {
                    if(cliente.getDocumento().equals(documento)){
                        usuarioExiste = true;
                        break;
                    }
                }
            }
            case VENDEDOR: {
                for (Empleado empleado: getListaEmpleados()) {
                    if(empleado.getDocumento().equals(documento)){
                        usuarioExiste = true;
                        break;
                    }
                }
            }
            case OPTOMETRA: {
                for (Empleado empleado: getListaEmpleados()) {
                    if(empleado.getDocumento().equals(documento)){
                        usuarioExiste = true;
                        break;
                    };
                }
            }
            default: {
                return usuarioExiste;
            }
        }
    }

    /**
     * Buscar Diagnostico por id único
     * @param idDiagnostico
     * @return
     */
    public boolean buscarDiagnostico(String idDiagnostico){
        boolean diagnosticoExiste = false;
        for (Diagnostico diagnostico: getListaDiagnosticos()) {
            if(diagnostico.getId().equals(idDiagnostico)){
                diagnosticoExiste = true;
                break;
            }
        }
        return diagnosticoExiste;
    }

    /**
     * Método para verificar la existe un diagnóstico
     * @param diagnosticoBuscado
     * @return boolean
     */
    public boolean buscarDiagnostico(Diagnostico diagnosticoBuscado){
        boolean diagnosticoExiste = false;
        for (Diagnostico diagnostico: getListaDiagnosticos()) {
            if(diagnostico.getId().equals(diagnosticoBuscado.getId())){
                diagnosticoExiste = true;
                break;
            }
        }
        return diagnosticoExiste;
    }

    /**
     * Método para buscar un diagnostico y validar su posterior creación
     * @param gradoLente
     * @param problemaVisual
     * @param cliente
     * @param optometra
     * @return boolean
     */
    public boolean buscarDiagnostico(GradoLente gradoLente, ProblemaVisual problemaVisual, Cliente cliente, Optometra optometra){
        boolean diagnosticoExiste = false;
        for (Diagnostico diagnostico: getListaDiagnosticos()) {
            if(diagnostico.getGradoLente() == gradoLente &&
                    diagnostico.getProblemaVisual() == problemaVisual &&
                    diagnostico.getCliente() == cliente && diagnostico.getOptometra() == optometra){
                diagnosticoExiste = true;
                break;
            }
        }
        return diagnosticoExiste;
    }

    /**
     * Método para buscar lente
     * @param diagnostico
     * @param montura
     * @param filtro
     * @return boolean
     */
    public boolean buscarLente(Diagnostico diagnostico, Montura montura, Filtro filtro){
        boolean lenteExiste = false;
        for (Lente lente: getListaLentes()) {
            if(lente.getDiagnostico().equals(diagnostico) && lente.getMontura().equals(montura) &&
                    lente.getFiltro().equals(filtro)){
                lenteExiste = true;
                break;
            }
        }
        return lenteExiste;
    }

    /**
     *  Método para verificar la existe un lente
     * @param lenteBuscado
     * @return boolean
     */
    public boolean buscarLente(Lente lenteBuscado){
        boolean lenteExiste = false;
        for (Lente lente: getListaLentes()) {
            if(lente.getId().equals(lenteBuscado.getId())){
                lenteExiste = true;
                break;
            }
        }
        return lenteExiste;
    }

    /**
     * Método para crear usuario de tipo Cliente
     * @param nombre
     * @param documento
     * @param telefono
     * @param correo
     * @param edad
     * @return boolean
     */
    public boolean crearUsuario(String nombre, String documento, String telefono, String correo, int edad){
        if(!buscarUsuario(documento, TipoUsuario.CLIENTE)){
            Cliente cliente = new Cliente(nombre, documento, telefono, correo, edad);
            getListaClientes().add(cliente);
            return true;
        }else {
            return false;
        }

    }

    /**
     * Método para crear usuario de tipo Vendedor
     * @param nombre
     * @param documento
     * @param salario
     * @return boolean
     */
    public boolean crearUsuario(String nombre, String documento, float salario) {
        if(!buscarUsuario(documento, TipoUsuario.VENDEDOR)){
            Vendedor vendedor = new Vendedor(nombre, documento, salario);
            getListaEmpleados().add(vendedor);
            return true;
        }
        return false;
    }

    /**
     * Método para crear usuarios de tipo Optómetra
     * @param nombre
     * @param documento
     * @param salario
     * @param horario
     * @return boolean
     */
    public boolean crearUsuario(String nombre, String documento, float salario, String horario){
        if(!buscarUsuario(documento, TipoUsuario.OPTOMETRA)){
            Optometra optometra = new Optometra(nombre, documento, salario, horario);
            getListaEmpleados().add(optometra);
            return true;
        }
        return false;
    }

    /**
     * Método para la creación de diagnósticos
     * @param gradoLente
     * @param problemaVisual
     * @param cliente
     * @param optometra
     * @return Diagnostico
     */
    public Diagnostico crearDiagnostico(GradoLente gradoLente, ProblemaVisual problemaVisual, Cliente cliente, Optometra optometra) {
        if (!buscarDiagnostico(gradoLente, problemaVisual, cliente, optometra)) {
            Diagnostico diagnostico = new Diagnostico(gradoLente, problemaVisual, cliente, optometra);
            getListaDiagnosticos().add(diagnostico);
            cliente.setDiagnostico(diagnostico);
            optometra.getListaDiagnosticos().add(diagnostico);
            return diagnostico;
        }
        return new Diagnostico();
    }

    /**
     * Método para crear lente
     * @param diagnostico
     * @param montura
     * @param filtro
     * @return boolean
     */
    public boolean crearLente(Diagnostico diagnostico, Montura montura, Filtro filtro ){
        if (!buscarLente(diagnostico, montura, filtro)){
            Lente lente = new Lente(diagnostico, montura, filtro);
            getListaLentes().add(lente);
            return true;
        }else {
            return false;
        }

    }

    /**
     * Método para obtener listado de Optómetras
     * @return ArrayList<Optometra>
     */
    public ArrayList<Optometra> obtenerOptometras(){
        ArrayList<Optometra> listaOptometras = new ArrayList<>();
        for (Empleado empleado: getListaEmpleados()) {
            if(empleado instanceof Optometra){
                listaOptometras.add((Optometra) empleado);
            }
        }
       return listaOptometras;
    }

    /**
     * Método para optener listado de Vendedores
     * @return ArrayList<Empleado>
     */
    public ArrayList<Vendedor> obtenerVendedores(){
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();
        for (Empleado empleado: getListaEmpleados()) {
            if(empleado instanceof Vendedor){
                listaVendedores.add((Vendedor) empleado);
            }
        }
        return listaVendedores;
    }

    /**
     * Método para obtener listado de Clientes
     * @return List<Cliente>
     */
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Método para obtener listado de diagnóticos
     * @return List<Diagnostico>
     */
    public List<Diagnostico> obtenerDiagnosticos() {
        return getListaDiagnosticos();
    }

    /**
     * Método para obtener listado de Lentes
     * @return  List<Lente>
     */
    public List<Lente> obtenerLentes() {
        return getListaLentes();
    }

    /**
     * Método para eliminar usuarios
     * @param documento
     * @param tipoUsuario
     * @return boolean
     */
    public boolean eliminarUsuario(String documento, TipoUsuario tipoUsuario){
        boolean usuarioEliminado = false;
        switch (tipoUsuario){
            case CLIENTE -> {
                if (buscarUsuario(documento, TipoUsuario.CLIENTE)){
                    int tamanioLista = getListaClientes().size();
                    for(int i = 0; i < tamanioLista; i++){
                        Cliente cliente = getListaClientes().get(i);
                        if(cliente.getDocumento().equals(documento)){
                            getListaClientes().remove(i);
                            usuarioEliminado = true;
                            break;
                        }
                    }
                }
            }
            case VENDEDOR -> {
                if(buscarUsuario(documento, TipoUsuario.VENDEDOR)){
                    int tamanioLista = getListaEmpleados().size();
                    for(int i = 0; i < tamanioLista; i++){
                        Empleado empleado = getListaEmpleados().get(i);
                        if(empleado.getDocumento().equals(documento)){
                            getListaEmpleados().remove(i);
                            usuarioEliminado = true;
                            break;
                        }
                    }
                }
            }
            case OPTOMETRA -> {
                if (buscarUsuario(documento, TipoUsuario.OPTOMETRA)){
                    int tamanioLista = getListaEmpleados().size();
                    for(int i = 0; i < tamanioLista; i++){
                        Empleado empleado = getListaEmpleados().get(i);
                        if(empleado.getDocumento().equals(documento)){
                            getListaEmpleados().remove(i);
                            usuarioEliminado = true;
                            break;
                        }
                    }
                }
            }
        }
        return usuarioEliminado;
    }

    /**
     * Método para eliminar diagnosticos
     * @param diagnostico
     * @return boolean
     */
    public boolean eliminarDiagnostico(Diagnostico diagnostico){
        boolean diagnosticoEliminado = false;
        if(buscarDiagnostico(diagnostico)){
            int tamanioLista = getListaDiagnosticos().size();
            for(int i = 0; i < tamanioLista; i++){
                Diagnostico diagnosticoEncontrado = getListaDiagnosticos().get(i);
                if(diagnosticoEncontrado.getId().equals(diagnostico.getId())){
                    getListaDiagnosticos().remove(i);
                    diagnosticoEliminado = true;
                    break;
                }
            }
        }
        return diagnosticoEliminado;
    }

    public boolean eliminarDiagnostico(String idDiagnostico){
        boolean diagnosticoEliminado = false;
        if(buscarDiagnostico(idDiagnostico)){
            int tamanioLista = getListaDiagnosticos().size();
            for(int i = 0; i < tamanioLista; i++){
                Diagnostico diagnosticoEncontrado = getListaDiagnosticos().get(i);
                if(diagnosticoEncontrado.getId().equals(idDiagnostico)){
                    getListaDiagnosticos().remove(i);
                    diagnosticoEliminado = true;
                    break;
                }
            }
        }
        return diagnosticoEliminado;
    }

    /**
     * Método para eliminar lentes
     * @param lente
     * @return boolean
     */
    public boolean eliminarLente(Lente lente){
        boolean lenteEliminado = false;
        if(buscarLente(lente)){
            int tamanioLista = getListaLentes().size();
            for(int i = 0; i < tamanioLista; i++){
                Lente lenteEncontrado = getListaLentes().get(i);
                if(lenteEncontrado == lente){
                    getListaLentes().remove(i);
                    lenteEliminado = true;
                    break;
                }
            }
        }
        return lenteEliminado;
    }

    /**
     * Método para actualizar nombre del vendedor
     * @param nombre
     * @param vendedor
     * @return boolean
     */
    public boolean actualizarVendedor(String nombre, Vendedor vendedor){
        boolean vendedorActualizado = false;
        for (Empleado vendedorEncontrado: obtenerVendedores()) {
            if(vendedorEncontrado.getDocumento().equals(vendedor.getDocumento())){
                vendedorEncontrado.setNombre(nombre);
                vendedorActualizado = true;
            }
        }
        return vendedorActualizado;
    }

    /**
     * Método para actualizar el salario del vendedor
     * @param salario
     * @param vendedor
     * @return boolean
     */
    public boolean actualizarVendedor(float salario, Vendedor vendedor){
        boolean vendedorActualizado = false;
        for (Empleado vendedorEncontrado: obtenerVendedores()) {
            if(vendedorEncontrado.getDocumento().equals(vendedor.getDocumento())){
                vendedorEncontrado.setSalario(salario);
                vendedorActualizado = true;
            }
        }
        return vendedorActualizado;
    }

    /**
     * Método para actualizar nombre del optometra
     * @param nombre
     * @param optometra
     * @return boolean
     */
    public boolean actualizarOptometra(String nombre, Optometra optometra){
        boolean optometraActualizado = false;
        for (Empleado optometraEncontrado: obtenerOptometras()) {
            if(optometraEncontrado.getDocumento().equals(optometra.getDocumento())){
                optometraEncontrado.setNombre(nombre);
                optometraActualizado = true;
            }
        }
        return optometraActualizado;
    }

    /**
     * Método para actualizar salario del optometra
     * @param salario
     * @param optometra
     * @return boolean
     */
    public boolean actualizarOptometra(float salario, Optometra optometra){
        boolean optometraActualizado = false;
        for (Empleado optometraEncontrado: obtenerOptometras()) {
            if(optometraEncontrado.getDocumento().equals(optometra.getDocumento())){
                optometraEncontrado.setSalario(salario);
                optometraActualizado = true;
            }
        }
        return optometraActualizado;
    }

    /**
     * Método para actualizar nombre o correo del cliente
     * @param valorCambio
     * @param cliente
     * @return boolean
     */
    public boolean actualizarCliente(String valorCambio, Cliente cliente){
        boolean clienteActualizado = false;
        for (Cliente clienteEncontrado: obtenerClientes()) {
            if(valorCambio.contains("@")){
                if(clienteEncontrado.getDocumento().equals(cliente.getDocumento())){
                    clienteEncontrado.setCorreo(valorCambio);
                    clienteActualizado = true;
                }
            } else {
                if(clienteEncontrado.getDocumento().equals(cliente.getDocumento())){
                    clienteEncontrado.setNombre(valorCambio);
                    clienteActualizado = true;
                }
            }
        }
        return clienteActualizado;
    }

    /**
     * Mpetodo para actualizar la edad del cliente
     * @param edad
     * @param cliente
     * @return boolean
     */
    public boolean actualizarCliente(int edad, Cliente cliente){
        boolean clienteActualizado = false;
        for (Cliente clienteEncontrado: obtenerClientes()) {
            if(clienteEncontrado.getDocumento().equals(cliente.getDocumento())){
                clienteEncontrado.setEdad(edad);
                clienteActualizado = true;
            }
        }
        return clienteActualizado;
    }

    /**
     * Método para grado del lente del diagnostico
     * @param gradoLente
     * @param diagnostico
     * @return boolean
     */
    public boolean actualizarDiagnostico(GradoLente gradoLente, Diagnostico diagnostico){
        boolean diagnosticoActualizado = false;
        for (Diagnostico diagnosticoEncontrado: obtenerDiagnosticos()) {
            if(buscarDiagnostico(diagnostico)){
                diagnosticoEncontrado.setGradoLente(gradoLente);
                diagnosticoActualizado = true;
            }
        }
        return diagnosticoActualizado;
    }

    /**
     * Método para actualizar ep problema visual del diagnostico
     * @param problemaVisual
     * @param diagnostico
     * @return boolean
     */
    public boolean actualizarDiagnostico(ProblemaVisual problemaVisual, Diagnostico diagnostico){
        boolean diagnosticoActualizado = false;
        for (Diagnostico diagnosticoEncontrado: obtenerDiagnosticos()) {
            if(buscarDiagnostico(diagnostico)){
                diagnosticoEncontrado.setProblemaVisual(problemaVisual);
                diagnosticoActualizado = true;
            }
        }
        return diagnosticoActualizado;
    }

    /**
     * Método para actualizar el cliente del diagnostico
     * @param cliente
     * @param diagnostico
     * @return boolean
     */
    public boolean actualizarDiagnostico(Cliente cliente, Diagnostico diagnostico){
        boolean diagnosticoActualizado = false;
        for (Diagnostico diagnosticoEncontrado: obtenerDiagnosticos()) {
            if(buscarDiagnostico(diagnostico)){
                diagnosticoEncontrado.setCliente(cliente);
                diagnosticoActualizado = true;
            }
        }
        return diagnosticoActualizado;
    }

    /**
     * Método para actualizar optometra del diagnostico
     * @param optometra
     * @param diagnostico
     * @return boolean
     */
    public boolean actualizarDiagnostico(Optometra optometra, Diagnostico diagnostico){
        boolean diagnosticoActualizado = false;
        for (Diagnostico diagnosticoEncontrado: obtenerDiagnosticos()) {
            if(buscarDiagnostico(diagnostico)){
                diagnosticoEncontrado.setOptometra(optometra);
                diagnosticoActualizado = true;
            }
        }
        return diagnosticoActualizado;
    }

    /**
     * Método para actualizar el diagnostico del cliente
     * @param diagnostico
     * @param lente
     * @return boolean
     */
    public boolean actualizarLente(Diagnostico diagnostico, Lente lente){
        boolean lenteActualizado = false;
        for (Lente lenteEncontrado: obtenerLentes()) {
            if(buscarLente(lente)){
                lenteEncontrado.setDiagnostico(diagnostico);
                lenteActualizado = true;
            }
        }
        return lenteActualizado;
    }

    /**
     * Método para actualizar montura del Lente
     * @param montura
     * @param lente
     * @return boolean
     */
    public boolean actualizarLente(Montura montura, Lente lente){
        boolean lenteActualizado = false;
        for (Lente lenteEncontrado: obtenerLentes()) {
            if(buscarLente(lente)){
                lenteEncontrado.setMontura(montura);
                lenteActualizado = true;
            }
        }
        return lenteActualizado;
    }

    /**
     * Método para actualizar filtro del lente
     * @param filtro
     * @param lente
     * @return boolean
     */
    public boolean actualizarLente(Filtro filtro, Lente lente){
        boolean lenteActualizado = false;
        for (Lente lenteEncontrado: obtenerLentes()) {
            if(buscarLente(lente)){
                lenteEncontrado.setFiltro(filtro);
                lenteActualizado = true;
            }
        }
        return lenteActualizado;
    }
}
