// Cristian Santiago Moreno Ruiz
// Reto 5 Taller#1 Programacion funcional 
// Dada una lista de correos electrónicos donde algunos están repetidos
// transforme la colección en una estructura que elimine automáticamente los elementos duplicados. 


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Reto5Mc {
    public static void main(String[] args) {
        List<String> emails = List.of("a@correo.com", "b@correo.com", "a@correo.com", "c@correo.com", "b@correo.com");
        Set<String> Uemails = emails.stream()
                .collect(Collectors.toSet());

        System.out.println(Uemails);
        Uemails.forEach(System.out::println);
    }
}