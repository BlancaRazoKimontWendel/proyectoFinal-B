import java.util.Scanner;

import estados.*;

public class AppAlt {
    private static Estado estadoActual = new EstadoInicio();
    private static Scanner s = new Scanner(System.in);
    private static EstadoSalida estdoSalida = new EstadoSalida();
    public static void main(String[] args) throws Exception {
        while (! estadoActual.equals(estadoSalida)) {
            estadoActual.ejecutar(s);
        }
        
    }
}
