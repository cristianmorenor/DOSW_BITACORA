package dosw.semana_4.patrones.ejercicio9;

public class GoogleStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("[Auth] Validando token OAuth de Google para " + credentials.getUsuario());
        return new AuthResult(true, credentials.getUsuario());
    }
}