package dosw.semana_4.patrones.ejercicio9;

public class PasswordStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("[Auth] Validando usuario/contraseña de " + credentials.getUsuario());
        return new AuthResult(true, credentials.getUsuario());
    }
}