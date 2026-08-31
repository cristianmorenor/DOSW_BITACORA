// Cristian Santiago Moreno Ruiz
// Reto 8 Taller#1 Programacion funcional 
// Dada una lista de códigos de producto con repeticiones, genere una nueva colección donde cada código aparezca una sola vez. 

import java.util.List;
import java.util.stream.Collectors;

public class Reto8Mc {
    public static void main(String[] args) {
        List<String> codes = List.of("P01", "P02", "P01", "P03", "P02", "P04");

        List<String> uniqueCodes = codes.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCodes);
    }
}