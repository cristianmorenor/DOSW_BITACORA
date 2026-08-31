// Cristian Santiago Moreno Ruiz
// Reto 14 Taller#1 Programacion Funcional
// Dada una lista de notas, determine si todas son mayores o iguales a 3.0. 

import java.util.List;

public class Reto14Mc {
    public static void main(String[] args) {
        List<Double> scores = List.of(4.0, 3.5, 4.2, 5.0, 3.8);

        boolean allApproved = scores.stream()
                .allMatch(n -> n >= 3.0);

        System.out.println("¿Todas >= 3.0? " + allApproved);
    }
}