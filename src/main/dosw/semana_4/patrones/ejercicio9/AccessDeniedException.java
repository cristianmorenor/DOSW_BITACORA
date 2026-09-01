package dosw.semana_4.patrones.ejercicio9;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String mensaje) {
        super(mensaje);
    }
}