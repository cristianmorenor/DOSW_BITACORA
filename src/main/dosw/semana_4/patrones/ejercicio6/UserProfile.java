package dosw.semana_4.patrones.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private final String usuario;
    private RecommendationAlgorithm algoritmo;
    private final List<PreferenceObserver> observers = new ArrayList<>();

    public UserProfile(String usuario, RecommendationAlgorithm algoritmoInicial) {
        this.usuario = usuario;
        this.algoritmo = algoritmoInicial;
    }

    public void addObserver(PreferenceObserver observer) {
        observers.add(observer);
    }

    public void cambiarAlgoritmo(RecommendationAlgorithm nuevoAlgoritmo) {
        this.algoritmo = nuevoAlgoritmo;
        List<String> recomendaciones = algoritmo.recommend(usuario);
        observers.forEach(o -> o.onPreferenceChanged(usuario, recomendaciones));
    }
}