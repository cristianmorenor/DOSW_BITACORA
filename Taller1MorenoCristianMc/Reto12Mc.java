// Cristian Santiago Moreno Ruiz
// Reto 12 Taller#1 Programacion funcional
// Dada una lista de salarios, determine cuál es el salario más alto utilizando Streams. 


import java.util.List;
import java.util.Comparator;

public class Reto12Mc {
    public static void main(String[] args) {
        List<Integer> salary= List.of(1800000, 2500000, 3200000, 2100000, 4000000);

        int maxSalary= salary.stream()
                .max(Comparator.naturalOrder())
                .get();

        System.out.println("Salario máximo ==  " + maxSalary);
    }
}