package estados;

import java.util.Scanner;

import menues.Menu;
import menues.MenuClosedException;
import menues.MenuConfirmacion;
import recursos.TipoUsuario;
import singleton.AppComunicador;
import usuarios.Administrador;
import usuarios.UsuarioExisteException;

class MenuRoles extends Menu {
    /* ----- CONSTRUCTOR ----- */
    public MenuRoles() {
        super();
        try {
            addOpcion("Administrador");
            addOpcion("Desarrollador");
            addOpcion("Invitado");
        } catch (MenuClosedException mce) {
            System.out.println("El menú no debería de estar cerrado.");
            mce.printStackTrace();
        }
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Estado que representa cuando un administrador agrega a un usuario.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoAgregarUsuario extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception {
        if (agregaUsuario(s)) {
            System.out.println("Se ha agregado con éxito al usuario.");
            return new EstadoUsoGeneral();
        /* Se pregunta si se quiere repetir la operación */
        } else if (! MetodosGenerales.repetirOperacion(s)) {
            return new EstadoUsoGeneral();
        }
        return new EstadoAgregarUsuario();
    }
    /**
     * Solicita los datos de un usuario para agregarlo al achivo usuarios.dat e indica si la
     * operación se realizó con éxito-
     * @param s Teclado con el que el usuario se comunica.
     * @return {@code true} si se agregó al usuario al archivo usuarios.dat y {@code false} si no.
     */
    private boolean agregaUsuario(Scanner s) throws Exception{
        System.out.print("Nombre: ");
        String nombre = s.next();
        System.out.println();
        System.out.print("Nombre de usuario: ");
        String nickname = s.next();
        System.out.println();
        System.out.print("Correo electrónico: ");
        String email = s.next();
        System.out.println();
        System.out.print("Contraseña: ");
        String password = s.next();
        System.out.println();
        TipoUsuario rol = null;
        MenuRoles menuRoles = new MenuRoles();
        menuRoles.close();
        MetodosGenerales.solicitaEntrada(s, menuRoles, "¿Qué rol le asigna?");
        switch (menuRoles.getEleccion().getIdentificador()) {
            case '1':
                rol = TipoUsuario.ADMINISTRADOR;
                break;
            case '2':
                rol = TipoUsuario.DESARROLLADOR;
                break;
            case '3':
                rol = TipoUsuario.INVITADO;
                break;
            default:
                throw new Exception();
        }
        try {
            if (usuarioConfirma(s)) {
                ((Administrador) AppComunicador.getInstancia().getUsuarioActual()).agregarUsuario(nombre, nickname, email, password, rol);
                return true; // <--- Si se añade.
            }
        } catch (UsuarioExisteException uee) {
            String datoDuplicado = "";
            switch (uee.getDatoDuplicado()) {
                case "nickname":
                    datoDuplicado = "nombre de usuario \"" + nickname + "\"";
                    break;
                case "email":
                    datoDuplicado = "correo electrónico \"" + email + "\"";
                    break;
            }
            System.out.println("El " + datoDuplicado + " " + 
                                (datoDuplicado == "nickname" ? nickname : email ) + 
                                " ya ha sido registrado.");
            // TODO: mejorar el sistema para que lo especifique en el momento donde se introdujo el dato.
        }
        return false; //<--- Si no se añade.
    }
    /**
     * Solicita al usuario confirmar la operación reciente, para mayor seguridad.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario confirma y {@code false} si no.
     */
    private boolean usuarioConfirma(Scanner s) throws Exception {
        MenuConfirmacion menuConfirmacion = new MenuConfirmacion();
        menuConfirmacion.close();
        MetodosGenerales.solicitaEntrada(s, menuConfirmacion, "¿Desea confirmar la operación?");
        if (menuConfirmacion.getEleccion().getIdentificador() == MenuConfirmacion.IDENTIFICADOR_CONFIRMAR) {
            return true;
        } else {
            System.out.println("La operación fue cancelada.");
            return false;
        }
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoAgregarUsuario() {
        super(EstadosApp.AGREGAR_USUARIO);
    }
    /* ----- CONSTRUCTOR ----- */
}
