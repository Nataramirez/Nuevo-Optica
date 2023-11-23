package co.edu.uniquindio.NuevoOptica.enums;

public enum GradoLente {
    GRADO_025("GRADO_025", 50000), GRADO_050("GRADO_050",50000), GRADO_075("GRADO_075",50000), GRADO_100("GRADO_100",50000),
    GRADO_125("GRADO_125",100000), GRADO_150("GRADO_150",100000), GRADO_175("GRADO_175",100000), GRADO_200("GRADO_200",100000),
    GRADO_225("GRADO_225",150000), GRADO_250("GRADO_250",150000), GRADO_275("GRADO_275",150000), GRADO_300("GRADO_300",150000),
    GRADO_325("GRADO_325",200000), GRADO_350("GRADO_350",200000), GRADO_375("GRADO_375",200000), GRADO_400("GRADO_400",200000),
    GRADO_425("GRADO_425",250000), GRADO_450("GRADO_450",250000), GRADO_475("GRADO_475",250000), GRADO_500("GRADO_500",250000),
    GRADO_525("GRADO_525",300000), GRADO_550("GRADO_550",300000), GRADO_575("GRADO_575",300000), GRADO_600("GRADO_600",300000);

    private String nombre;
    private double precio;

    GradoLente(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static String[] tipoGradoLente(){
        String[] gradoLente = {
               GradoLente.GRADO_025.getNombre(),
               GradoLente.GRADO_050.getNombre(),
                GradoLente.GRADO_075.getNombre(),
                GradoLente.GRADO_100.getNombre(),
                GradoLente.GRADO_125.getNombre(),
                GradoLente.GRADO_150.getNombre(),
                GradoLente.GRADO_175.getNombre(),
                GradoLente.GRADO_200.getNombre(),
                GradoLente.GRADO_225.getNombre(),
                GradoLente.GRADO_250.getNombre(),
                GradoLente.GRADO_275.getNombre(),
                GradoLente.GRADO_300.getNombre(),
                GradoLente.GRADO_325.getNombre(),
                GradoLente.GRADO_350.getNombre(),
                GradoLente.GRADO_375.getNombre(),
                GradoLente.GRADO_400.getNombre(),
                GradoLente.GRADO_425.getNombre(),
                GradoLente.GRADO_450.getNombre(),
                GradoLente.GRADO_475.getNombre(),
                GradoLente.GRADO_500.getNombre(),
                GradoLente.GRADO_525.getNombre(),
                GradoLente.GRADO_550.getNombre(),
                GradoLente.GRADO_575.getNombre(),
                GradoLente.GRADO_600.getNombre(),
        };
        return gradoLente;
    }
}
