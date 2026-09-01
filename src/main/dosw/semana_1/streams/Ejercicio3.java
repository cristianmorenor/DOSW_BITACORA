package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio3 {

    record User(int id, String name, int age, boolean active) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Daniel", 25, true),
                new User(2, "Ana", 27, false),
                new User(3, "Juliana", 20, true),
                new User(4, "Diego", 32, false)
        );

        List<String> sortedUsers = users.stream()
                .filter(User::active)
                .map(User::name)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedUsers);
    }
}