package estados;

import java.util.Scanner;

import singleton.*;

public class EstadoCerrarSesion extends Estado {
    public Estado ejecutar(Scanner s) {
        try {
            AppComunicador.getInstancia().setUsuarioActual(null);
        } catch (SingletonClosedException sce) {
            System.out.println("El singleton no debería estar cerrado.");
            sce.printStackTrace();
        }
        return new EstadoInicioApp();
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoCerrarSesion() {
        super(EstadosApp.CERRAR_SESION);
    }
    /* ----- CONSTRUCTOR ----- */
}
