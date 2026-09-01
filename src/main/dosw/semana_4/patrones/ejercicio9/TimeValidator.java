package dosw.semana_4.patrones.ejercicio9;

public class TimeValidator extends Validator {
    protected void check(Credentials credentials) {
        System.out.println("[Chain] Validando horario laboral (" + credentials.getHoraSolicitud() + "h) de " + credentials.getUsuario());
        if (credentials.getHoraSolicitud() < 7 || credentials.getHoraSolicitud() > 20) {
            throw new AccessDeniedException("Acceso denegado: fuera del horario laboral (6h-20h)");
        }
    }
}