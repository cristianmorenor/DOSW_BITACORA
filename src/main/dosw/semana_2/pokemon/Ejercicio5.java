package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {

    record Pokemon(String nombre, int nivel) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Mewtwo", 88),
                new Pokemon("Dragonite", 82),
                new Pokemon("Squirtle", 38),
                new Pokemon("Mew", 85),
                new Pokemon("Charmander", 62)
        );

        List<Pokemon> superiores80 = pokemones.stream()
                .filter(p -> p.nivel() > 80)
                .collect(Collectors.toList());

        String nombres = superiores80.stream()
                .map(Pokemon::nombre)
                .collect(Collectors.joining(", "));

        System.out.println("Pokémon con nivel > 80: " + superiores80.size() + " (" + nombres + ")");
    }
}