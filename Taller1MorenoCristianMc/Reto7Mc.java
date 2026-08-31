// Cristian Santiago Moreno Ruiz
// Reto 7 Taller#1 Programacion funcional 
// Dada una lista de edades, obtenga una nueva lista ordenada de menor a mayor y otra de mayor a menor. 


import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Reto7Mc {
    public static void main(String[] args) {
        List<Integer> edades = List.of(25, 18, 32, 21, 19, 28);

        List<Integer> asc = edades.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> desc = edades.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Ascendente:");
        System.out.println(asc);

        System.out.println("\nDescendente:");
        System.out.println(desc);
    }   
}