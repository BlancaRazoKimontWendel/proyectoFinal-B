package estados;

import java.util.Scanner;

public class EstadoFiltrarTareas extends Estado {
    public Estado ejecutar(Scanner s) {
        return null;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoFiltrarTareas() {
        super(EstadosApp.FILTRAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
