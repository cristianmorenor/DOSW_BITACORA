package dosw.semana_4.patrones.ejercicio9;

public interface AuthStrategy {
    AuthResult authenticate(Credentials credentials);
}