package dosw.semana_4.patrones.ejercicio9;

public class Credentials {
    private final String usuario;
    private final String pais;
    private final int horaSolicitud;
    private final boolean tienePermisoAdmin;

    public Credentials(String usuario, String pais, int horaSolicitud, boolean tienePermisoAdmin) {
        this.usuario = usuario;
        this.pais = pais;
        this.horaSolicitud = horaSolicitud;
        this.tienePermisoAdmin = tienePermisoAdmin;
    }

    public String getUsuario() { return usuario; }
    public String getPais() { return pais; }
    public int getHoraSolicitud() { return horaSolicitud; }
    public boolean tienePermisoAdmin() { return tienePermisoAdmin; }
}