package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class NotificationService implements PreferenceObserver {
    public void onPreferenceChanged(String usuario, List<String> nuevasRecomendaciones) {
        System.out.println("[Notification] Enviando push a " + usuario + ": ¡Nuevas recomendaciones disponibles!");
    }
}