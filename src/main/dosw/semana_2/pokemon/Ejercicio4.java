package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio4 {

    record Pokemon(String nombre, int nivel) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Charmander", 62),
                new Pokemon("Squirtle", 38),
                new Pokemon("Snorlax", 90),
                new Pokemon("Mewtwo", 88)
        );

        Optional<Pokemon> alfa = pokemones.stream()
                .max(Comparator.comparingInt(Pokemon::nivel));

        alfa.ifPresent(p -> System.out.println("Pokémon Alfa: " + p.nombre() + " (nivel " + p.nivel() + ")"));
    }
}