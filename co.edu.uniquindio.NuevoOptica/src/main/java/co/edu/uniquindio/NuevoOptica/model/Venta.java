package co.edu.uniquindio.NuevoOptica.model;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Cliente cliente;
    private Vendedor vendedor;

    public List<DetalleVenta> listaDetalleVentas = new ArrayList<>();

    public Venta(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(List<DetalleVenta> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", listaDetalleVentas=" + listaDetalleVentas +
                '}';
    }
}
