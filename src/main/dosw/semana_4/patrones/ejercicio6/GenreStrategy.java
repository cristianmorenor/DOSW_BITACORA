package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class GenreStrategy implements RecommendationAlgorithm {
    public List<String> recommend(String usuario) {
        return List.of("Stranger Things", "Dark", "The OA");
    }
}