/// Cristian Santiago Moreno Ruiz
// Reto Final Taller#1 Programacion Funcional
// ​​Se tiene una lista de estudiantes con nombre y promedio. Construya una solución usando Streams que permita: filtrar aprobados (promedio ≥ 3.0), 
// convertir nombres a mayúsculas, ordenar por promedio de mayor a menor,
// mostrar cada estudiante procesado en consola, y guardar el resultado en una nueva lista.​ 

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RetoFinalMc {

    record Student(String name, double average) {}

    public static void main(String[] args) {
        List<Student> estudiantes = List.of(
                new Student("Ana", 4.5),
                new Student("Carlos", 3.2),
                new Student("Pedro", 2.8),
                new Student("Laura", 4.8),
                new Student("Andrés", 3.9),
                new Student("María", 2.5)
        );

        List<String> resultado = estudiantes.stream()
                .filter(e -> e.average() >= 3.0)
                .map(e -> new Student(e.name().toUpperCase(), e.average()))
                .sorted(Comparator.comparingDouble(Student::average).reversed())
                .peek(e -> System.out.println("Procesado: " + e.name() + "  " + e.average()))
                .map(e -> e.name() + "(" + e.average() + ")")
                .collect(Collectors.toList());

        System.out.println("\nLista final:");
        System.out.println(resultado);
    }
}
