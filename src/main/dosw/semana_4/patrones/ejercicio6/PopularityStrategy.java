package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class PopularityStrategy implements RecommendationAlgorithm {
    public List<String> recommend(String usuario) {
        return List.of("Wednesday", "Squid Game", "One Piece");
    }
}