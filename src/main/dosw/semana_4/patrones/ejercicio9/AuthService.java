package dosw.semana_4.patrones.ejercicio9;

public class AuthService {
    public AuthResult login(String tipoUsuario, Credentials credentials) {
        AuthStrategy strategy = switch (tipoUsuario) {
            case "EMPLEADO" -> new PasswordStrategy();
            case "EXTERNO" -> new GoogleStrategy();
            case "ADMIN" -> new BiometricStrategy();
            default -> throw new IllegalArgumentException("Tipo de usuario no soportado: " + tipoUsuario);
        };
        return strategy.authenticate(credentials);
    }
}