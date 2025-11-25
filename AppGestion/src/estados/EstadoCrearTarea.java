package estados;

import java.util.Scanner;

public class EstadoCrearTarea extends Estado {
    public Estado ejecutar(Scanner s) {
        return null;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoCrearTarea() {
        super(EstadosApp.CREAR_TAREA);
    }
    /* ----- CONSTRUCTOR ----- */
}
