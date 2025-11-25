package estados;

import java.util.Scanner;

public class EstadoDesplegarTareas extends Estado {
    public Estado ejecutar(Scanner s) {
        return null;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoDesplegarTareas() {
        super(EstadosApp.DESPLEGAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
