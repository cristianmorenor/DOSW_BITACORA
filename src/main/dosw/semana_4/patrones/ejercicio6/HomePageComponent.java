package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class HomePageComponent implements PreferenceObserver {
    public void onPreferenceChanged(String usuario, List<String> nuevasRecomendaciones) {
        System.out.println("[HomePage] Actualizando banner principal de " + usuario + " con: " + nuevasRecomendaciones);
    }
}