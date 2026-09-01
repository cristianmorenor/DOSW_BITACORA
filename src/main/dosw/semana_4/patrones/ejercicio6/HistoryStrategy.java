package dosw.semana_4.patrones.ejercicio6;

import java.util.List;

public class HistoryStrategy implements RecommendationAlgorithm {
    public List<String> recommend(String usuario) {
        return List.of("Breaking Bad", "Better Call Saul");
    }
}