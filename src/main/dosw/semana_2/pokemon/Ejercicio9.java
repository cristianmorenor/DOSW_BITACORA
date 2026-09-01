package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        List<Pokemon> equipoElite = pokemones.stream()
                .filter(p -> p.getPoderCombate() > 500)
                .collect(Collectors.toList());

        String resultado = equipoElite.stream()
                .map(p -> p.getNombre() + "(" + (int) p.getPoderCombate() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("Equipo Élite (PC > 500): [" + resultado + "]");
    }
}