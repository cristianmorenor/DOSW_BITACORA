package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio19 {

    private static double poderTotal(Entrenador e) {
        return e.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();
    }

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Gary", 10, List.of(
                        new Pokemon(1L, "Nidoking", "Veneno", 70, 1140, "Kanto", false),
                        new Pokemon(2L, "Arcanine", "Fuego", 65, 1200, "Kanto", false))),
                new Entrenador(2L, "Ash", 8, List.of(
                        new Pokemon(3L, "Pikachu", "Eléctrico", 45, 850, "Kanto", false),
                        new Pokemon(4L, "Charizard", "Fuego", 78, 1000, "Kanto", false))),
                new Entrenador(3L, "Dawn", 7, List.of(
                        new Pokemon(5L, "Piplup", "Agua", 30, 1050, "Sinnoh", false),
                        new Pokemon(6L, "Buneary", "Normal", 28, 1050, "Sinnoh", false))),
                new Entrenador(4L, "Brock", 6, List.of(
                        new Pokemon(7L, "Onix", "Roca", 55, 900, "Kanto", false),
                        new Pokemon(8L, "Geodude", "Roca", 40, 770, "Kanto", false)))
        );

        Comparator<Entrenador> ranking = Comparator
                .comparingInt(Entrenador::getMedallas).reversed()
                .thenComparing(Comparator.comparingDouble(Ejercicio19::poderTotal).reversed())
                .thenComparing(Entrenador::getNombre);

        List<Entrenador> top3 = entrenadores.stream()
                .sorted(ranking)
                .limit(3)
                .toList();

        IntStream.range(0, top3.size())
                .mapToObj(i -> "#" + (i + 1) + " " + top3.get(i).getNombre()
                        + " - " + top3.get(i).getMedallas() + " medallas, PC: " + (int) poderTotal(top3.get(i)))
                .forEach(System.out::println);
    }
}