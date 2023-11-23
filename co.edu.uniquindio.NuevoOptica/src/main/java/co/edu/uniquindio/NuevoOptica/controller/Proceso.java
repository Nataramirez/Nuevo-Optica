package co.edu.uniquindio.NuevoOptica.controller;

public enum Proceso {
    CLIENTE("Cliente"),
    OPTOMETRA("Optometra"),
    VENDEDOR("Vendedor"),
    DIAGNOSTICO("Diagnostico"),
    LENTE("Lente");
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    Proceso(String nombre) {
        this.nombre = nombre;
    }

    public static String[] proceso(){
        String[] proceso = {
                Proceso.CLIENTE.getNombre(),
                Proceso.OPTOMETRA.getNombre(),
                Proceso.VENDEDOR.getNombre(),
                Proceso.DIAGNOSTICO.getNombre(),
                Proceso.LENTE.getNombre()
        };
        return proceso;
    }
}
