// Cristian Santiago Moreno Ruiz
// Reto 13 Taller#1 Programacion Funcional
// Dada una lista de números, verifique si existe al menos un número par dentro de la colección. 


import java.util.List;

public class Reto13Mc {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(7, 11, 13, 20, 25);

        boolean hasPair = numbers.stream()
                .anyMatch(n -> n % 2 == 0);

        System.out.println("¿Hay algún par? " + hasPair);
    }
}