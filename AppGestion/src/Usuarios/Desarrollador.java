package usuarios;

import recursos.TipoUsuario;

/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BLANCA.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * Esta clase representa a un usuario Desarrollador 
 */

/**
 * Representa a un usuario de tipo Desarrollador dentro del sistema.
 * 
 * El Desarrollador cuenta con permisos intermedios:
 *  - Puede crear tareas únicamente para sí mismo.
 *  - Puede visualizar únicamente sus propias tareas.
 *  - Puede filtrar sus tareas por estado.
 *  - Puede actualizar sus tareas (estado, descripción, fechas), 
 *    respetando las restricciones del sistema.
 * 
 * Esta clase extiende {@link Usuario} y sirve como puente entre las
 * acciones de un usuario estándar y el administrador.
 *
 * Forma parte del módulo de gestión de usuarios.
 *
 * @author Blanca Razo
 */

public class Desarrollador extends Usuario {

    public Desarrollador(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }

    @Override
    public void verTareas(Usuario user) {
        System.out.println("Función verTareas(user) aún no implementada.");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.DESARROLLADOR;
    }

    // Métodos pendientes 
    public void crearTareaParaMi() {}
    public void verMisTareas() {}
    public void filtrarMisTareasPorEstado() {}
    public void actualizarMiTarea() {}
}
