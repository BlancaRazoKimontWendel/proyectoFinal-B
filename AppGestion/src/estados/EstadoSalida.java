package estados;

import java.util.Scanner;

public class EstadoSalida extends Estado {
    /* ----- CONSTRUCTOR ----- */
    public EstadoSalida() {
        super(EstadosApp.SALIR);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoSalida []";
    }
    /* ----- UTILERÍA ----- */
    public EstadosApp ejecutar(Scanner s) {
        return null;
    }
}
