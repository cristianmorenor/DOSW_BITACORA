// Cristian Santiago Moreno Ruiz
// Reto 2 Taller#1 Programación Funcional
// Dada una lista de productos, recorra la colección e imprima cada elemento en consola con el mensaje: "Producto disponible: <nombre>" 

import java.util.List;

public class Reto2MC {

    public static void main(String[] args) {

        List<String> products = List.of("Laptop","Mouse","Tecladdo","Monitor","Impresora");

        products.forEach(product->System.out.println("Producto disponible: " + product));
    }
}