package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio5 {

    record Transaction(String id, double amount, boolean approved) {}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("T1", 150.0, true),
                new Transaction("T2", 300.0, true),
                new Transaction("T3", 75.5, false),
                new Transaction("T4", 200.0, true)
        );

        boolean hayNoAprobadas = transactions.stream()
                .peek(System.out::println)
                .anyMatch(t -> !t.approved());

        boolean loteValido = !hayNoAprobadas;

        System.out.println("¿Lote es válido? " + loteValido);
    }
}