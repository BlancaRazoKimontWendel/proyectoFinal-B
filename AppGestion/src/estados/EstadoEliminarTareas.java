package estados;

import java.util.Scanner;

public class EstadoEliminarTareas extends Estado {
    public Estado ejecutar(Scanner s) {
        return null;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoEliminarTareas() {
        super(EstadosApp.ELIMINAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
