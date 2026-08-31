// Cristian Santiago Moreno Ruiz
// Reto 4 Taller#1 Programacion funcional 
// Dada una lista de números enteros, calcule la suma total de todos los elementos utilizando una operación de reducción. 

import java.util.List;

public class Reto4MC {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 8, 5, 10, 15);
        int sumar = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sumar);
    }
}



