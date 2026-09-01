package dosw.semana_4.patrones.ejercicio6;

public interface PreferenceObserver {
    void onPreferenceChanged(String usuario, java.util.List<String> nuevasRecomendaciones);
}