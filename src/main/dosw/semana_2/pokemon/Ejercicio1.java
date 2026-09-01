package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    record Pokemon(String nombre, String tipo) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", "Eléctrico"),
                new Pokemon("Charmander", "Fuego"),
                new Pokemon("Squirtle", "Agua"),
                new Pokemon("Vulpix", "Fuego"),
                new Pokemon("Bulbasaur", "Planta"),
                new Pokemon("Flareon", "Fuego")
        );

        List<String> tipoFuego = pokemones.stream()
                .filter(p -> p.tipo().equals("Fuego"))
                .map(Pokemon::nombre)
                .collect(Collectors.toList());

        System.out.println(tipoFuego);
    }
}