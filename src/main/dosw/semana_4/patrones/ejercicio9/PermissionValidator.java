package dosw.semana_4.patrones.ejercicio9;

public class PermissionValidator extends Validator {
    protected void check(Credentials credentials) {
        System.out.println("[Chain] Validando permisos de " + credentials.getUsuario());
        if (!credentials.tienePermisoAdmin() && credentials.getUsuario().equals("root")) {
            throw new AccessDeniedException("El usuario root requiere permisos de administrador");
        }
    }
}