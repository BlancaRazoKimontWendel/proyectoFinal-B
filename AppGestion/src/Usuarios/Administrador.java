package usuarios;

import recursos.TipoUsuario;
import java.util.List;

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

    // ===== CONSTRUCTOR =====
    public Administrador(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }

    // ---- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ----
    @Override
    public void verTareas(Usuario user) {
        // Se implementará cuando Ricardo termine ListaTareas
        System.out.println("Función verTareas(user) aún no disponible.");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

    /**
     * Agrega un usuario nuevo a la lista recibida, verificando:
     *  - Que el nickname no esté repetido.
     *  - Que el email no esté repetido.
     *
     * IMPORTANTE:
     *  - No accede a archivos.
     *  - No usa AppComunicador ni Scanner.
     *  - Toda la interacción con el usuario y la persistencia la hacen los estados / singleton.
     *
     * @param listaUsuarios lista donde se agregará el nuevo usuario.
     * @param nombre        nombre del usuario.
     * @param nickname      nickname (debe ser único).
     * @param email         correo (debe ser único).
     * @param password      contraseña.
     * @param rol           tipo de usuario a crear.
     * @return              el usuario recién creado y añadido a la lista.
     * @throws UsuarioExisteException si nickname o email ya están registrados.
     */
    public Usuario agregarUsuario(List<Usuario> listaUsuarios,
                                  String nombre,
                                  String nickname,
                                  String email,
                                  String password,
                                  TipoUsuario rol)
                                  throws UsuarioExisteException {

        // Primero validamos nickname duplicado
        for (Usuario u : listaUsuarios) {
            if (u.getNickname().equals(nickname)) {
                throw new UsuarioExisteException("Nickname duplicado", "nickname");
            }
        }

        // Luego validamos email duplicado
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equals(email)) {
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
                // Esta clase la administra Fernanda.
                // Debe existir un constructor compatible: Invitado(String, String, String, String)
                nuevo = new Invitado(nombre, nickname, email, password);
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado: " + rol);
        }

        listaUsuarios.add(nuevo);
        return nuevo;
    }
}
