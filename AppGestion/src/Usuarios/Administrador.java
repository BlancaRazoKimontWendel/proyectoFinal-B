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
        // Se implementará cuando los estados de tareas usen ListaTareas
        System.out.println("Función verTareas(user) aún no disponible.");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

    /**
     * Agrega un usuario nuevo a la lista global de usuarios manejada por
     * AppComunicador. No guarda en archivos directamente; la persistencia
     * se hace cuando se cierra el Singleton.
     *
     * Reglas:
     * - No se permite nickname duplicado.
     * - No se permite email duplicado.
     * - Si ambos están duplicados, se reporta primero el nickname
     *   (como pide Brayan).
     *
     * @param nombre    Nombre del usuario.
     * @param nickname  Nombre de usuario (único).
     * @param email     Correo electrónico (único).
     * @param password  Contraseña.
     * @param rol       Tipo de usuario a crear.
     * @throws UsuarioExisteException si el nickname o el email ya existen.
     */
    public void agregarUsuario(String nombre,
                               String nickname,
                               String email,
                               String password,
                               TipoUsuario rol)
                               throws UsuarioExisteException {

        // Obtenemos la lista compartida desde el Singleton
        List<Usuario> usuarios = AppComunicador.getInstancia().getListaUsuarios();

        // Validar nickname o email duplicado.
        // IMPORTANTE: else if, para que si ambos están duplicados,
        // se priorice el mensaje de nickname (primero que se revisa).
        for (Usuario u : usuarios) {
            if (u.getNickname().equals(nickname)) {
                throw new UsuarioExisteException("Nickname duplicado", "nickname");
            } else if (u.getEmail().equals(email)) {
                throw new UsuarioExisteException("Email duplicado", "email");
            }
        }

        // Crear el usuario según rol
        Usuario nuevo;
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
                throw new IllegalArgumentException("Rol de usuario no reconocido: " + rol);
        }

        // Agregar a la lista en memoria
        usuarios.add(nuevo);
        // NO guardamos en archivo aquí: AppComunicador.close() se encarga al final.
    }
}
