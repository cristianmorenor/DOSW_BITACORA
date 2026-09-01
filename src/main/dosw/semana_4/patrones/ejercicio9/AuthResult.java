package dosw.semana_4.patrones.ejercicio9;

public class AuthResult {
    private final boolean exitoso;
    private final String usuario;

    public AuthResult(boolean exitoso, String usuario) {
        this.exitoso = exitoso;
        this.usuario = usuario;
    }

    public boolean isExitoso() { return exitoso; }
    public String getUsuario() { return usuario; }
}