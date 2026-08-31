// Cristian Santiago Moreno Ruiz
// Reto 11 Taller#1 Programacion funcional
// Dada una lista de precios, determine cuál es el precio más bajo utilizando Streams. 

import java.util.List;
import java.util.Comparator;


public class Reto11Mc {
    public static void main(String[] args) {
        List<Integer> price = List.of(12000, 5000, 18000, 7500, 3000);

      int minPrice = price.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Precio mínimo ==  " + minPrice);
    }
}