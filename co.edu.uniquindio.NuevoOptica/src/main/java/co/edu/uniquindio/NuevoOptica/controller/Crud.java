package co.edu.uniquindio.NuevoOptica.controller;

public enum Crud {
    CREATE("Crear ", 1),
    READ("Ver ", 2),
    UPDATE("Actualizar información de ", 3),
    DELETE("Eliminar ", 4);
    private String nombre;
    private int id;

    Crud(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static String[] crud(String proceso){
        String[] tipoCrud = new String[4];
        if(proceso.equalsIgnoreCase(Proceso.CLIENTE.getNombre())){
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "cliente",
                    Crud.READ.getNombre() + "clientes",
                    //Crud.UPDATE.getNombre() + "cliente",
                    Crud.DELETE.getNombre() + "cliente",
            };
        }else if(proceso.equalsIgnoreCase(Proceso.OPTOMETRA.getNombre())) {
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "optometra",
                    Crud.READ.getNombre() + "optometras",
                    //Crud.UPDATE.getNombre() + "optometra",
                    Crud.DELETE.getNombre() + "optometra",
            };
        } else if (proceso.equalsIgnoreCase(Proceso.VENDEDOR.getNombre())) {
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "vendedor",
                    Crud.READ.getNombre() + "vendedores",
                    //Crud.UPDATE.getNombre() + "vendedor",
                    Crud.DELETE.getNombre() + "vendedor",
            };
        } else if (proceso.equalsIgnoreCase(Proceso.DIAGNOSTICO.getNombre())) {
            tipoCrud = new String[] {
                    Crud.CREATE.getNombre() + "diagnóstico",
                    Crud.READ.getNombre() + "diagnósticos",
                    //Crud.UPDATE.getNombre() + "diagnóstico",
                    Crud.DELETE.getNombre() + "diagnóstico",
            };
        } else if (proceso.equalsIgnoreCase(Proceso.LENTE.getNombre())) {
            tipoCrud = new String[] {
                    //Crud.CREATE.getNombre() + "lente",
                    Crud.READ.getNombre() + "lentes",
                    //Crud.UPDATE.getNombre() + "lente",
                    //Crud.DELETE.getNombre() + "lente",
            };
        }
        return tipoCrud;
    }
}
