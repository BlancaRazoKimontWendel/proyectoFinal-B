package estados;

import java.util.Scanner;

import menues.MenuInicio;
/**
 * Estado de inicio de la App.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoInicioApp extends Estado {
    /* ----- CONSTRUCTOR ----- */
    public EstadoInicioApp() {
        super(EstadosApp.INICIO_APP);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoInicioApp []";
    }
    /* ----- UTILERÍA ----- */
    public EstadosApp ejecutar(Scanner s) {
        System.out.println("Seleccione la opción deseada: ");
        MenuInicio menuInicio = new MenuInicio();
        menuInicio.close();
        System.out.println(menuInicio);
        menuInicio.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones.
        /* ----- CAMBIO DE ESTADO ----- */
        switch (menuInicio.getEleccion()) {
            case MenuInicio.OPCION_INICIAR_SESION:
                return EstadosApp.INICIO_SESION;
                break;
            case MenuInicio.OPCION_SALIR:
                return EstadosApp.SALIR;
                break;
            default:
                break;
        }
    }
}
