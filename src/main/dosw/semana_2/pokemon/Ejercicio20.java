package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Johto", true),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Charmander", "Fuego", 62, 380, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        Map<String, Long> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));

        Map<String, Long> porRegion = pokemones.stream()
                .collect(Collectors.groupingBy(Pokemon::getRegion, Collectors.counting()));

        long legendarios = pokemones.stream()
                .filter(Pokemon::isLegendario)
                .count();

        double promedioNivel = pokemones.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0);

        pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .ifPresent(p -> {
                    System.out.println("Por tipo: " + porTipo);
                    System.out.println("Por región: " + porRegion);
                    System.out.println("Legendarios: " + legendarios);
                    System.out.printf("Promedio niv: %.1f%n", promedioNivel);
                    System.out.println("Más fuerte: " + p.getNombre() + " (PC: " + (int) p.getPoderCombate() + ")");
                });
    }
}