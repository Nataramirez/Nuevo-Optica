package co.edu.uniquindio.NuevoOptica.model;

public class DetalleVenta {
    private Lente lente;

    Venta ownedByVenta;
    public Lente getLente() {
        return lente;
    }

    public void setLente(Lente lente) {
        this.lente = lente;
    }

    public Venta getOwnedByVenta() {
        return ownedByVenta;
    }

    public void setOwnedByVenta(Venta ownedByVenta) {
        this.ownedByVenta = ownedByVenta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "lente=" + lente +
                '}';
    }
}
