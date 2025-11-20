import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BRAYAN.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String indicaciones = "Seleccione una de las siguientes opciones:";
        Character[] keys = {'1','s'};
        String[] values = {"Iniciar sesión", "Salir"};
        Diccionario<Character,String> opciones = new Diccionario<>(keys, values);

        Menu menu = new Menu(indicaciones, opciones);
        System.out.println(menu);
        s.close();
    }
}
