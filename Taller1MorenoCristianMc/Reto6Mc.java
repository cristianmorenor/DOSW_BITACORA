// Cristian Santiago Moreno Ruiz
// Reto 6 Taller#1 Programacion funcional 
// Dada una lista de empleados, convierta los nombres a mayúsculas y registre en consola cada transformación realizada antes de guardar el resultado final en una lista. 

import java.util.List;
import java.util.stream.Collectors;

public class Reto6Mc {
    public static void main(String[] args) {
        List<String> employees = List.of("Laura", "Pedro", "Carlos", "Ana");

        List<String> transformed = employees.stream()
                .map(String::toUpperCase)
                .peek(name -> System.out.println("Transformado: " + name))
                .collect(Collectors.toList());

        System.out.println("List: " + transformed);
    }
}
    