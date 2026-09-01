package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio17 {

    private static double poderTotal(Entrenador e) {
        return e.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();
    }

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of(
                        new Pokemon(1L, "Pikachu", "Eléctrico", 45, 850, "Kanto", false),
                        new Pokemon(2L, "Charizard", "Fuego", 78, 1000, "Kanto", false))),
                new Entrenador(2L, "Gary", 10, List.of(
                        new Pokemon(3L, "Nidoking", "Veneno", 70, 1140, "Kanto", false),
                        new Pokemon(4L, "Arcanine", "Fuego", 65, 1200, "Kanto", false))),
                new Entrenador(3L, "Brock", 6, List.of(
                        new Pokemon(5L, "Onix", "Roca", 55, 900, "Kanto", false),
                        new Pokemon(6L, "Geodude", "Roca", 40, 770, "Kanto", false)))
        );

        Optional<Entrenador> masPoderoso = entrenadores.stream()
                .max(Comparator.comparingDouble(Ejercicio17::poderTotal));

        masPoderoso.ifPresent(e -> {
            System.out.println("Entrenador más poderoso: " + e.getNombre());
            System.out.println("Poder acumulado del equipo: " + (int) poderTotal(e));
        });
    }
}