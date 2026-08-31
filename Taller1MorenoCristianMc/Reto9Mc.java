// Cristian Santiago Moreno Ruiz
// Reto 9 Taller#1 Programacion funcional
// Dada una lista de los 20 mejores puntajes de un videojuego, obtenga únicamente los primeros 5 elementos para mostrar el ranking principal. 

import java.util.List;
import java.util.stream.Collectors;

public class Reto9Mc {
    public static void main(String[] args) {
        List<Integer> puntajes = List.of(100, 95, 91, 88, 85, 82, 79, 76, 73, 70, 67, 64, 60, 57, 53, 49, 45, 40, 35, 20);

        List<Integer> top5 = puntajes.stream()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 puntajes: " + top5);
    }
}