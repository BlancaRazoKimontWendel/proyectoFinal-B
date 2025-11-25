package estados;
import java.util.Scanner;

public class EstadoActualizarTareas extends Estado {
    public Estado ejecutar(Scanner s) {
        return null;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoActualizarTareas() {
        super(EstadosApp.ACTUALIZAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
