package dosw.semana_4.patrones.ejercicio9;

public class BiometricStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("[Auth] Validando huella biométrica de " + credentials.getUsuario());
        return new AuthResult(true, credentials.getUsuario());
    }
}