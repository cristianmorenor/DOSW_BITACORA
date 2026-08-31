// Cristian Santiago Moreno Ruiz
// Reto 15 Taller#1 Programacion Funcional
// Dada una lista de usuarios, verifique que ninguno tenga el nombre "root". 

import java.util.List;

public class Reto15Mc {
    public static void main(String[] args) {
        List<String> users = List.of("juan", "maria", "admin", "pedro", "soporte");

        boolean noOneIsRoot = users.stream()
                .noneMatch(u -> u.equals("root"));

        System.out.println("¿Ninguno es root? " + noOneIsRoot);
    }
}