package dosw.semana_4.patrones.ejercicio9;

public class CredentialValidator extends Validator {
    protected void check(Credentials credentials) {
        System.out.println("[Chain] Validando credenciales de " + credentials.getUsuario());
    }
}