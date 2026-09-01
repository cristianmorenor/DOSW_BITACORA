package dosw.semana_4.patrones.ejercicio9;

public class LocationValidator extends Validator {
    protected void check(Credentials credentials) {
        System.out.println("[Chain] Validando ubicación (" + credentials.getPais() + ") de " + credentials.getUsuario());
        if (!credentials.getPais().equals("Colombia")) {
            throw new AccessDeniedException("Acceso denegado: ubicación fuera de Colombia");
        }
    }
}