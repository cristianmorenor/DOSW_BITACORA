package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(2L, "Psyduck", "Agua", 25, 180, "Kanto", false),
                new Pokemon(3L, "Charmander", "Fuego", 25, 250, "Kanto", false),
                new Pokemon(4L, "Vulpix", "Fuego", 30, 260, "Kanto", false),
                new Pokemon(5L, "Bulbasaur", "Planta", 22, 220, "Kanto", false)
        );

        Map<String, List<String>> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        porTipo.forEach((tipo, nombres) -> System.out.println(tipo + ": " + nombres));
    }
}