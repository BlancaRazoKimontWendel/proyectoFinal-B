package usuarios;

import java.util.List;

import recursos.TipoUsuario;
import singleton.AppComunicador;

/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BLANCA.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * Esta clase representa a un usuario Administrador.
 * Ahora implementa la creación de usuarios y todos los métodos abstractos que exige Usuario.
 * ----- Mensaje para VISITANTES -----
 */
public class Administrador extends Usuario {

    // ---- CONSTRUCTOR ----
    public Administrador(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }

    // ---- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ----
    @Override
    public void verTareas(Usuario user) {
        // Cuando se defina qué salida exacta se quiere?
        System.out.println("Función verTareas(user) aún no disponible para Administrador:(.");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

    /**
     * Agrega un nuevo usuario a la lista global manejada por AppComunicador.
     * 
     * Reglas:
     * - No se permite repetir nickname.
     * - No se permite repetir email.
     * - Si ambos están repetidos, se prioriza reportar el nickname,
     *   por eso se usa if / else if.
     *
     * @param nombre   Nombre del usuario.
     * @param nickname Nickname (nombre de usuario).
     * @param email    Correo electrónico.
     * @param password Contraseña.
     * @param rol      Rol del usuario (ADMINISTRADOR, DESARROLLADOR o INVITADO).
     * @throws UsuarioExisteException si el nickname o el email ya existen.
     */
    public void agregarUsuario(String nombre,
                               String nickname,
                               String email,
                               String password,
                               TipoUsuario rol)
                               throws UsuarioExisteException {

        // Obtenemos la lista de usuarios en memoria desde el singleton. 
        // AppComunicador se encarga de cargarla de archivo al iniciar y de guardarla cuando se cierra, no?.
        List<Usuario> usuarios = AppComunicador.getInstancia().getListaUsuarios();

        // Validar nickname o email duplicado
        for (Usuario u : usuarios) {
            if (u.getNickname().equals(nickname)) {
                // Si nickname ya existe, prioritario reportarlo
                throw new UsuarioExisteException("Nickname duplicado", "nickname");
            } else if (u.getEmail().equals(email)) {
                // Sólo se revisa email si el nickname NO era duplicado
                throw new UsuarioExisteException("Email duplicado", "email");
            }
        }

        // Crear el usuario según su rol
        Usuario nuevo = null;
        switch (rol) {
            case ADMINISTRADOR:
                nuevo = new Administrador(nombre, nickname, email, password);
                break;
            case DESARROLLADOR:
                nuevo = new Desarrollador(nombre, nickname, email, password);
                break;
            case INVITADO:
                nuevo = new Invitado(nombre, nickname, email, password);
                break;
            default:
                // No debería pasar porque TipoUsuario es un enum cerrado, pero ahi lo dejo.
                throw new IllegalArgumentException("Rol de usuario no reconocido: " + rol);
        }

        // Añadimos el nuevo usuario a la lista en memoria.

        usuarios.add(nuevo);
    }
}
