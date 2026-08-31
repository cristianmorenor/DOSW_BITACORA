// Cristian Santiago Moreno Ruiz
// Reto 1 Taller#1 Programación Funcional 
// Dada una lista de nombres de estudiantes, obtenga una nueva lista que contenga únicamente los nombres que empiezan por la letra A. 

import java.util.List;

public class Reto1MC{
    public static void main(String[] args) {
        List<String> names = List.of("Ana",  "Carlos", "Andres","Pedro","Alejandra","Juan", "Amanda");
        
        List<String> namesA = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

        System.out.println(namesA);
    }
}




