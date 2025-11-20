/**
 * Esta clase se encarga de manejar cada tipo diferente de menú que sale en pantalla,
 * ya sea para iniciar sesión, elegir el modo de ingreso del usuario a la app, etc. 
 */
public class Menu {
    public static final char OPCION_SALIR = 's';
    private final String INDICACIONES;
    private final Diccionario<Character,String> OPCIONES;

    private char eleccion;

    /* ----- CONSTRUCTOR ----- */
    public Menu (String indicaciones, Diccionario<Character, String> opciones) {
        super();
        INDICACIONES = indicaciones;
        if (!opciones.hasKey(OPCION_SALIR)) {
            opciones.put(OPCION_SALIR, "Salida");
        }
        this.OPCIONES = opciones;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public String getIndicaciones() {
        return INDICACIONES;
    }
    public void setIndicaciones(String indicaciones) {
        System.out.println("INDICACIONES no puede ser modificado.");
    }
    public Diccionario<Character, String> getOpciones() {
        return OPCIONES;
    }
    public void setOpciones(Diccionario<Character, String> opciones) {
        System.out.println("OPCIONES no puede ser modificado.");
    }
    public char getEleccion() {
        return eleccion;
    }
    public void setEleccion(char eleccion) {
        this.eleccion = eleccion;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        String salida = INDICACIONES + "\n";
        for (int i = 0; i < OPCIONES.getSize(); i++) {
            salida += OPCIONES.getKey(i) + ") " + OPCIONES.getValue(i) + ".\n";
        }
        return salida;
    }
    /* ----- UTILERÍA ----- */
}