// Cristian Santiago Moreno Ruiz
// Reto 10 Taller#1 Programacion funcional
// Dada una lista de películas, ignore las dos primeras y obtenga una nueva lista con las restantes.

import java.util.List;
import java.util.stream.Collectors;

public class Reto10Mc {
    public static void main(String[] args) {
        List<String> movies = List.of( "Avatar", "Titanic", "Interestelar", "Matrix", "Gladiador");

        List<String> restantes = movies.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(restantes);
    }
}