package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class SuggestedListComponent implements PreferenceObserver {
    public void onPreferenceChanged(String usuario, List<String> nuevasRecomendaciones) {
        System.out.println("[SuggestedList] Recargando lista de sugeridos de " + usuario + ": " + nuevasRecomendaciones);
    }
}