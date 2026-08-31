// Cristian Santiago Moreno Ruiz
// Reto 3 Taller#1 Programacion funcional 
// Dada una lista de nombres de ciudades, genere una nueva lista donde todas estén escritas completamente en mayúsculas. 


import java.util.List;

public class Reto3MC {
    public static void main(String[] args) {
        List<String> cities = List.of("Bogotá", "Medellín", "Barranquilla", "Cali");
        
        List<String> citiesMay = cities.stream()
                .map(String::toUpperCase)
                .toList();
        
        System.out.println(citiesMay);
    }
}