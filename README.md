# SEMANA No 1 — DOSW Manejo de Streams

## Datos personales:
- Nombre y Apellido: Cristian Santiago Moreno
- Código de Estudiante: 1000100162
- Curso: DOSW

### Ejercicio 01 — Números Pares mayores a diez

Dada una lista de números enteros, obtener una nueva lista solo con los números pares mayores a 10.

**Código implementado:**
```java
package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 8, 10, 12, 15, 18, 20);

        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 == 0 && n > 10)
                .collect(Collectors.toList());

        System.out.println(resultado);
    }
}
```

**Captura de ejecución:** ![](evidencias/ejercicio1.png)

**Explicación:** Se usó `filter()` con una expresión lambda para evaluar dos condiciones (número par y mayor a 10) sobre el Stream de la lista original, obteniendo así únicamente los elementos que cumplen ambas.

### Ejercicio 02 — Cantidad de Palabras con más de 4 caracteres

Dada una lista de palabras: filtrar las que tengan más de 4 caracteres, convertirlas a mayúsculas, ordenarlas alfabéticamente y obtener la cantidad total.
**Código implementado:**
```java
package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public static void main(String[] args) {
        List<String> palabras = List.of("java", "stream", "api", "functional", "code", "git");

        List<String> resultado = palabras.stream()
                .filter(p -> p.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Cantidad de palabras resultantes: " + resultado.size());
    }
}
```


**Captura de ejecución:** ![](evidencias/ejercicio2.png)

**Explicación:** Se usó `filter()` para quedarnos con las palabras de más de 4 caracteres, `map()` con method reference (`String::toUpperCase`) para pasarlas a mayúsculas, y `sorted()` para ordenarlas alfabéticamente antes de contar el resultado.

### Ejercicio 03 — Obtener nombres de los Usuarios

Dada una lista de usuarios con los atributos: id, name, age, active. Filtrar únicamente los usuarios activos, obtener una lista con los nombres en mayúscula y ordenada alfabéticamente.

**Código implementado:**
```java
package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio3 {

    record User(int id, String name, int age, boolean active) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Daniel", 25, true),
                new User(2, "Ana", 27, false),
                new User(3, "Beatriz", 20, true),
                new User(4, "Diego", 32, false),
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
```

**Captura de ejecución:** ![](evidencias/ejercicio3.png)

**Explicación:** Se usó `filter()` con method reference (`User::active`) para quedarnos solo con los usuarios activos, `map()` para extraer el nombre (`User::name`) y transformarlo a mayúsculas (`String::toUpperCase`), y `sorted()` para ordenar alfabéticamente el resultado.

### Ejercicio 04 — Personas mayores de edad

Dado un listado de Usuarios (mismos atributos anteriores), filtrar las personas mayores de edad y obtener sus nombres.

**Código implementado:**
```java
package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

    record User(int id, String name, int age, boolean active) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Daniel", 25, true),
                new User(2, "Ana", 27, false),
                new User(3, "Juliana", 15, true),
                new User(4, "Diego", 32, false)
        );

        List<String> mayores = users.stream()
                .filter(u -> u.age() >= 18)
                .map(User::name)
                .collect(Collectors.toList());

        System.out.println(mayores);
    }
}
```

**Captura de ejecución:** ![](evidencias/ejercicio4.png)

**Explicación:** Se usó `filter()` con una lambda para quedarnos únicamente con los usuarios de 18 años o más, y `map()` con method reference (`User::name`) para extraer solo sus nombres.

### Ejercicio 05 — Transacciones Bancarias

Dada una lista de transacciones bancarias (id, amount, approved), procesar la lista usando Streams para: ver cada transacción con `peek()`, verificar si existe al menos una no aprobada, y retornar si el lote es válido.

**Código implementado:**
```java
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

        System.out.println("¿Lote válido? " + loteValido);
    }
}
```

**Captura de ejecución:** ![](evidencias/ejercicio5.png)

**Explicación:** Se usó `peek()` para imprimir cada transacción a medida que se procesa, y `anyMatch()` para verificar si existe al menos una no aprobada. Como `anyMatch()` hace corto circuito, deja de evaluar transacciones apenas encuentra una que cumple la condición (por eso T4 no se llegó a procesar). El lote se considera válido solo si no hay ninguna no aprobada.


# SEMANA No 2 — Bitácora Pokémon

## Datos de Entrenador: 
- Nombre y Apellido: Cristian Moreno
- Código de Estudiante: 1000100162
- Curso: DOSW 

### Ejercicio 01 — Pokémon Tipo Fuego

Dada una lista de Pokémon con nombre y tipo, obtener únicamente aquellos cuyo tipo sea Fuego.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    record Pokemon(String nombre, String tipo) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", "Eléctrico"),
                new Pokemon("Charmander", "Fuego"),
                new Pokemon("Squirtle", "Agua"),
                new Pokemon("Vulpix", "Fuego"),
                new Pokemon("Bulbasaur", "Planta"),
                new Pokemon("Flareon", "Fuego")
        );

        List<String> tipoFuego = pokemones.stream()
                .filter(p -> p.tipo().equals("Fuego"))
                .map(Pokemon::nombre)
                .collect(Collectors.toList());

        System.out.println(tipoFuego);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio1.png)

**Explicación:** Se usó `filter()` con una lambda para quedarnos solo con los Pokémon de tipo Fuego, y `map()` con method reference (`Pokemon::nombre`) para extraer únicamente sus nombres.

### Ejercicio 02 — Pokédex Gritona

Transformar todos los nombres de Pokémon a mayúsculas.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public static void main(String[] args) {
        List<String> pokemones = List.of("Pikachu", "Charmander", "Squirtle", "Bulbasaur");

        List<String> pokedexGritona = pokemones.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(pokedexGritona);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio2.png)

**Explicación:** Se usó `map()` con method reference (`String::toUpperCase`) para transformar cada nombre a mayúsculas de forma simple y directa.

### Ejercicio 03 — Poder Total del Equipo

Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {
        List<Integer> niveles = List.of(45, 62, 38, 71, 55, 29);

        int sumaTotal = niveles.stream()
                .reduce(0, Integer::sum);

        System.out.println("Suma total de niveles: " + sumaTotal);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio3.png)

**Explicación:** Se usó `reduce()` con un valor inicial de 0 y `Integer::sum` como method reference para acumular la suma de todos los niveles del Stream.

### Ejercicio 04 — Pokémon Alfa

Encontrar el Pokémon con el nivel más alto dentro del equipo.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio4 {

    record Pokemon(String nombre, int nivel) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Charmander", 62),
                new Pokemon("Squirtle", 38),
                new Pokemon("Snorlax", 90),
                new Pokemon("Mewtwo", 88)
        );

        Optional<Pokemon> alfa = pokemones.stream()
                .max(Comparator.comparingInt(Pokemon::nivel));

        alfa.ifPresent(p -> System.out.println("Pokémon Alfa: " + p.nombre() + " (nivel " + p.nivel() + ")"));
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio4.png)

**Explicación:** Se usó `max()` con un `Comparator.comparingInt()` sobre el nivel de cada Pokémon para encontrar el de mayor nivel, devuelto como `Optional<Pokemon>`.

### Ejercicio 05 — Pokémon Legendarios

Contar cuántos Pokémon del equipo tienen nivel superior a 80.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {

    record Pokemon(String nombre, int nivel) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Mewtwo", 88),
                new Pokemon("Dragonite", 82),
                new Pokemon("Squirtle", 38),
                new Pokemon("Mew", 85),
                new Pokemon("Charmander", 62)
        );

        List<Pokemon> superiores80 = pokemones.stream()
                .filter(p -> p.nivel() > 80)
                .collect(Collectors.toList());

        String nombres = superiores80.stream()
                .map(Pokemon::nombre)
                .collect(Collectors.joining(", "));

        System.out.println("Pokémon con nivel > 80: " + superiores80.size() + " (" + nombres + ")");
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio5.png)

**Explicación:** Se usó `filter()` para quedarnos con los Pokémon de nivel superior a 80, `size()` para contarlos y `Collectors.joining()` para mostrar sus nombres separados por coma.

### Ejercicio 06 — Pokédex Sin Duplicados

Dada una lista de Pokémon con elementos repetidos, generar una nueva colección donde cada Pokémon aparezca una sola vez.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio6 {

    public static void main(String[] args) {
        List<String> pokemones = List.of("Pikachu", "Charmander", "Pikachu", "Squirtle", "Charmander", "Mewtwo");

        List<String> sinDuplicados = pokemones.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(sinDuplicados);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio6.png)

**Explicación:** Se usó `distinct()` para eliminar los elementos repetidos del Stream, conservando el orden de primera aparición.

### Ejercicio 07 — Orden del Profesor Oak

El Profesor Oak quiere su Pokédex organizada. Ordenar alfabéticamente los nombres de los Pokémon.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {

    public static void main(String[] args) {
        List<String> pokemones = List.of("Squirtle", "Pikachu", "Mewtwo", "Bulbasaur", "Charmander", "Abra");

        List<String> ordenados = pokemones.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ordenados);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio7.png)

**Explicación:** Se usó `sorted()` sin comparador personalizado, aprovechando el orden natural alfabético de los `String`.

### Ejercicio 08 — Evoluciones Preparadas

Dada una lista de Pokémon que incluye si pueden evolucionar (boolean puedeEvolucionar), obtener únicamente los que estén listos para evolucionar.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio8 {

    record Pokemon(String nombre, boolean puedeEvolucionar) {}

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", true),
                new Pokemon("Raichu", false),
                new Pokemon("Charmander", true),
                new Pokemon("Charizard", false),
                new Pokemon("Squirtle", true),
                new Pokemon("Blastoise", false)
        );

        List<String> listosParaEvolucionar = pokemones.stream()
                .filter(Pokemon::puedeEvolucionar)
                .map(Pokemon::nombre)
                .collect(Collectors.toList());

        System.out.println("Listos para evolucionar: " + listosParaEvolucionar);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio8.png)

**Explicación:** Se usó `filter()` con method reference (`Pokemon::puedeEvolucionar`) para quedarnos solo con los Pokémon listos para evolucionar, y `map()` para extraer sus nombres.

### Ejercicio 09 — Equipo Élite

A partir del Nivel 3 se trabaja con la clase `Pokemon` (id, nombre, tipo, nivel, poderCombate, region, legendario). Mostrar únicamente los Pokémon cuyo poderCombate sea superior a 500.

**Clase Pokemon (reutilizada desde este ejercicio en adelante):**
```java
package dosw.semana_2.pokemon;

public class Pokemon {
    private Long id;
    private String nombre;
    private String tipo;
    private int nivel;
    private double poderCombate;
    private String region;
    private boolean legendario;

    public Pokemon(Long id, String nombre, String tipo, int nivel, double poderCombate, String region, boolean legendario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.poderCombate = poderCombate;
        this.region = region;
        this.legendario = legendario;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNivel() { return nivel; }
    public double getPoderCombate() { return poderCombate; }
    public String getRegion() { return region; }
    public boolean isLegendario() { return legendario; }
}
```

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        List<Pokemon> equipoElite = pokemones.stream()
                .filter(p -> p.getPoderCombate() > 500)
                .collect(Collectors.toList());

        String resultado = equipoElite.stream()
                .map(p -> p.getNombre() + "(" + (int) p.getPoderCombate() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("Equipo Élite (PC > 500): [" + resultado + "]");
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio9.png)

**Explicación:** Desde este ejercicio en adelante se trabaja con objetos complejos en vez de listas simples de tipos primitivos. Primero se creó la clase `Pokemon` con sus siete atributos y getters, siguiendo exactamente la especificación del taller. Luego, sobre la lista de instancias de `Pokemon`, se usó `filter()` con una lambda que evalúa `p.getPoderCombate() > 500` para quedarnos únicamente con los Pokémon cuyo poder de combate supera los 500 puntos. Como el resultado de ese filtro sigue siendo una lista de objetos `Pokemon` (y no de `String`), se hizo un segundo paso con `map()` para transformar cada objeto en una representación de texto legible (`nombre(poderCombate)`), y finalmente `Collectors.joining(", ")` para unir esos textos en un solo resultado separado por comas, replicando el formato de salida esperado por el taller. Esta separación en dos streams (uno para filtrar objetos, otro para darles formato de texto) es un patrón común cuando se necesita tanto la colección de objetos como una presentación distinta de esos datos.

### Ejercicio 10 — Pokédex Compacta

Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        List<String> nombres = pokemones.stream()
                .map(Pokemon::getNombre)
                .collect(Collectors.toList());

        System.out.println(nombres);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio10.png)

**Explicación:** Este ejercicio es un caso directo de transformación de tipo dentro de un Stream: se parte de una `List<Pokemon>` (objetos complejos con siete atributos cada uno) y se necesita llegar a una `List<String>` que contenga solo un dato puntual de cada objeto. Para eso se usa `map()`, cuya función es aplicar una transformación a cada elemento del Stream sin alterar la cantidad de elementos ni el orden original. Como transformación se usó el method reference `Pokemon::getNombre`, equivalente a escribir la lambda `p -> p.getNombre()`, pero más compacto y legible, ya que simplemente delega la llamada al getter correspondiente de cada objeto. El resultado de `map()` sigue siendo un Stream, por lo que se cierra con `collect(Collectors.toList())` para materializarlo de nuevo en una lista concreta que se pueda imprimir. Este patrón (`map()` + `getX()`) es la base de casi todas las "proyecciones" de datos que se piden más adelante en el taller, donde se necesita extraer un subconjunto de información de una colección de objetos más ricos.

### Ejercicio 11 — Poder Promedio

Calcular el promedio de poderCombate de todos los Pokémon del equipo.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio11 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        double promedio = pokemones.stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .average()
                .orElse(0);

        System.out.printf("Poder de combate promedio: %.2f%n", promedio);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio11.png)

**Explicación:** Este ejercicio necesita un dato numérico agregado (un promedio), y para eso Java ofrece los Streams especializados en primitivos (`IntStream`, `LongStream`, `DoubleStream`), que traen operaciones estadísticas listas como `average()`, `sum()`, `min()` y `max()` sin necesidad de escribirlas manualmente con `reduce()`. Para llegar a ese Stream especializado se usó `mapToDouble()` en vez del `map()` normal: mientras `map()` transforma un Stream de objetos en otro Stream de objetos, `mapToDouble()` transforma un Stream de objetos (`Pokemon`) directamente en un `DoubleStream` de valores primitivos, extrayendo el `poderCombate` de cada uno mediante el method reference `Pokemon::getPoderCombate`. Sobre ese `DoubleStream` ya se puede llamar `average()`, que retorna un `OptionalDouble` (no un `double` directo) porque técnicamente el Stream podría estar vacío y no existiría promedio calculable; por eso se usa `.orElse(0)` como valor de respaldo. Finalmente, `System.out.printf` con el formato `%.2f` se usó para mostrar el resultado con exactamente dos decimales, tal como pide la salida esperada del taller (474.17 y no 474.166666...).

### Ejercicio 12 — Campeón Regional

Obtener el Pokémon con mayor poderCombate de toda la lista.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio12 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        Optional<Pokemon> campeon = pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate));

        campeon.ifPresent(p ->
                System.out.println("Campeón: " + p.getNombre() + " con PC: " + (int) p.getPoderCombate()));
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio12.png)

**Explicación:** Aunque este ejercicio es muy similar al #4 (Pokémon Alfa), aquí se comparó por `poderCombate` (un `double`) en vez de por `nivel` (un `int`), por eso se usó `Comparator.comparingDouble()` en lugar de `comparingInt()` — cada tipo primitivo tiene su variante especializada del comparador para evitar el costo de autoboxing (convertir el primitivo a su clase envolvente `Double`/`Integer`) que ocurriría si se usara `Comparator.comparing()` genérico. El method reference `Pokemon::getPoderCombate` le indica al comparador qué campo usar para decidir el "mayor" entre dos

### Ejercicio 13 — Organizar por Tipo

Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(2L, "Psyduck", "Agua", 25, 180, "Kanto", false),
                new Pokemon(3L, "Charmander", "Fuego", 25, 250, "Kanto", false),
                new Pokemon(4L, "Vulpix", "Fuego", 30, 260, "Kanto", false),
                new Pokemon(5L, "Bulbasaur", "Planta", 22, 220, "Kanto", false)
        );

        Map<String, List<String>> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        porTipo.forEach((tipo, nombres) -> System.out.println(tipo + ": " + nombres));
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio13.png)


**Explicación:** Este ejercicio introduce `Collectors.groupingBy()`, el recolector encargado de dividir un Stream en subgrupos según una función clasificadora. Aquí la clasificación se hace por `Pokemon::getTipo`, así que el resultado final es un `Map<String, List<Pokemon>>` donde cada clave es un tipo (Agua, Fuego, Planta...) y cada valor la lista de Pokémon de ese tipo. Sin embargo, la salida esperada solo pide los *nombres*, no los objetos completos — por eso se usó la forma de dos argumentos de `groupingBy()`, donde el segundo argumento es un `Collector` "downstream" que se aplica dentro de cada grupo. En este caso se usó `Collectors.mapping(Pokemon::getNombre, Collectors.toList())`, que transforma cada elemento del grupo con `getNombre()` antes de coleccionarlo en una lista, evitando tener que hacer un segundo `map()` por separado después de agrupar. Finalmente se recorrió el `Map` resultante con `forEach()` para imprimir cada tipo junto a su lista de nombres.

### Ejercicio 14 — Organizar por Región

Agrupar los Pokémon según su región de origen.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio14 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Chikorita", "Planta", 20, 200, "Johto", false),
                new Pokemon(3L, "Torchic", "Fuego", 22, 210, "Hoenn", false),
                new Pokemon(4L, "Piplup", "Agua", 18, 190, "Sinnoh", false),
                new Pokemon(5L, "Charmander", "Fuego", 25, 250, "Kanto", false),
                new Pokemon(6L, "Totodile", "Agua", 21, 205, "Johto", false)
        );

        Map<String, List<String>> porRegion = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        porRegion.forEach((region, nombres) -> System.out.println(region + ": " + nombres));
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio14.png)

**Explicación:** Este ejercicio es estructuralmente idéntico al #13, solo que la agrupación se hace por región en vez de por tipo — lo cual demuestra la flexibilidad de `groupingBy()`: basta con cambiar la función clasificadora (`Pokemon::getRegion` en vez de `Pokemon::getTipo`) para reorganizar completamente los datos según otro criterio, sin tocar el resto de la lógica. Se mantuvo el mismo patrón de `groupingBy()` con `Collectors.mapping()` como downstream collector, para que cada grupo contenga directamente los nombres (`String`) en vez de los objetos `Pokemon` completos, que es lo que pide la salida esperada.

### Ejercicio 15 — Maestro de Gimnasios

A partir del Nivel 4 se trabaja también con la clase `Entrenador` (id, nombre, medallas, List<Pokemon>). Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

**Clase Entrenador (reutilizada desde este ejercicio en adelante):**
```java
package dosw.semana_2.pokemon;

import java.util.List;

public class Entrenador {
    private Long id;
    private String nombre;
    private int medallas;
    private List<Pokemon> equipo;

    public Entrenador(Long id, String nombre, int medallas, List<Pokemon> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.medallas = medallas;
        this.equipo = equipo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMedallas() { return medallas; }
    public List<Pokemon> getEquipo() { return equipo; }
}
```

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio15 {

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of()),
                new Entrenador(2L, "Misty", 5, List.of()),
                new Entrenador(3L, "Brock", 6, List.of()),
                new Entrenador(4L, "Gary", 10, List.of())
        );

        Optional<Entrenador> campeon = entrenadores.stream()
                .max(Comparator.comparingInt(Entrenador::getMedallas));

        campeon.ifPresent(e -> {
            System.out.println("Campeón de gimnasios: " + e.getNombre());
            System.out.println("Medallas obtenidas: " + e.getMedallas());
        });
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio15.png)

**Explicación:** Este ejercicio marca un cambio de nivel de abstracción: ya no se opera directamente sobre `Pokemon`, sino sobre `Entrenador`, una clase que a su vez *contiene* una lista de `Pokemon` (un objeto anidado dentro de otro). Para efectos de este ejercicio puntual esa lista interna no se usa todavía (se deja vacía con `List.of()`), pero la clase ya queda lista para los ejercicios siguientes del Nivel 4 que sí necesitan navegar dentro del equipo de cada entrenador. La lógica en sí reutiliza el mismo patrón que el Ejercicio 4 y el 12: `max()` con un `Comparator.comparingInt()`, esta vez usando `Entrenador::getMedallas` como criterio de comparación. El resultado, envuelto en `Optional<Entrenador>`, se procesa con `ifPresent()` y una lambda de bloque (con llaves `{}`) porque esta vez se necesitan imprimir dos líneas distintas en vez de una sola expresión.

### Ejercicio 16 — Entrenadores Experimentados

Mostrar únicamente los entrenadores que posean más de 5 medallas.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio16 {

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of()),
                new Entrenador(2L, "Misty", 5, List.of()),
                new Entrenador(3L, "Brock", 6, List.of()),
                new Entrenador(4L, "Gary", 10, List.of()),
                new Entrenador(5L, "May", 3, List.of()),
                new Entrenador(6L, "Dawn", 7, List.of())
        );

        List<Entrenador> experimentados = entrenadores.stream()
                .filter(e -> e.getMedallas() > 5)
                .collect(Collectors.toList());

        String resultado = experimentados.stream()
                .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("Entrenadores con > 5 medallas: [" + resultado + "]");
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio16.png)

**Explicación:** Nótese que Misty, con exactamente 5 medallas, queda excluida del resultado — la condición del enunciado es "más de 5", es decir estrictamente mayor (`>`), no "5 o más" (`>=`). Es un detalle fácil de pasar por alto pero importante para que la salida coincida exactamente con la esperada. Al igual que en el Ejercicio 9, se usó `filter()` para obtener primero la lista de objetos `Entrenador` que cumplen la condición, y luego un segundo Stream con `map()` y `Collectors.joining()` únicamente para dar formato de texto al resultado impreso, manteniendo separada la lógica de filtrado de la lógica de presentación.

### Ejercicio 17 — Equipo Más Poderoso

Calcular cuál entrenador tiene la suma total de poderCombate más alta entre todos sus Pokémon.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio17 {

    private static double poderTotal(Entrenador e) {
        return e.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();
    }

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of(
                        new Pokemon(1L, "Pikachu", "Eléctrico", 45, 850, "Kanto", false),
                        new Pokemon(2L, "Charizard", "Fuego", 78, 1000, "Kanto", false))),
                new Entrenador(2L, "Gary", 10, List.of(
                        new Pokemon(3L, "Nidoking", "Veneno", 70, 1140, "Kanto", false),
                        new Pokemon(4L, "Arcanine", "Fuego", 65, 1200, "Kanto", false))),
                new Entrenador(3L, "Brock", 6, List.of(
                        new Pokemon(5L, "Onix", "Roca", 55, 900, "Kanto", false),
                        new Pokemon(6L, "Geodude", "Roca", 40, 770, "Kanto", false)))
        );

        Optional<Entrenador> masPoderoso = entrenadores.stream()
                .max(Comparator.comparingDouble(Ejercicio17::poderTotal));

        masPoderoso.ifPresent(e -> {
            System.out.println("Entrenador más poderoso: " + e.getNombre());
            System.out.println("Poder acumulado del equipo: " + (int) poderTotal(e));
        });
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio17.png)

**Explicación:** Este ejercicio necesitaba comparar entrenadores por un valor que no es un atributo directo de la clase (como sí lo eran las medallas en el Ejercicio 15), sino un cálculo derivado: la suma de `poderCombate` de todos los Pokémon dentro de su equipo. Esto requiere un Stream anidado dentro de otro Stream, ya que por cada `Entrenador` hay que recorrer su lista interna de `Pokemon`. Para evitar calcular esa suma dos veces (una para comparar y otra para imprimir el resultado), se extrajo la lógica a un método auxiliar `poderTotal(Entrenador e)`, que internamente usa `mapToDouble()` sobre `e.getEquipo()` para convertir la lista de Pokémon en un `DoubleStream` de


### Ejercicio 18 — Top 5 Pokémon Más Fuertes

Generar un ranking de los cinco Pokémon con mayor poderCombate de toda la Pokédex.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio18 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 65, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        List<Pokemon> top5 = pokemones.stream()
                .sorted(Comparator.comparingDouble(Pokemon::getPoderCombate).reversed())
                .limit(5)
                .toList();

        IntStream.rangeClosed(1, top5.size())
                .mapToObj(i -> "#" + i + " " + top5.get(i - 1).getNombre() + " - PC: " + (int) top5.get(i - 1).getPoderCombate())
                .forEach(System.out::println);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio18.png)

**Explicación:** Se usó `sorted()` con `Comparator.comparingDouble(Pokemon::getPoderCombate).reversed()` para ordenar de mayor a menor poder de combate, y `limit(5)` para quedarnos solo con los cinco primeros — tal como sugiere el hint del taller. El reto adicional era numerar el ranking (#1, #2...) sin usar un ciclo `for` tradicional ni una variable contador externa, ya que eso violaría la regla de "solo Streams y Lambdas". La solución fue usar `IntStream.rangeClosed(1, top5.size())`, que genera un Stream de números del 1 al 5 (los puestos del ranking), y con `mapToObj()` se transforma cada número de puesto en la línea de texto correspondiente, accediendo al Pokémon de esa posición con `top5.get(i - 1)` (restando 1 porque las listas empiezan en índice 0, pero el ranking empieza en 1). Finalmente `forEach(System.out::println)` imprime cada línea ya construida.

### Ejercicio 19 — Top 3 Entrenadores

Generar un ranking de los 3 mejores entrenadores considerando: 1° más medallas, 2° mayor poder acumulado, 3° orden alfabético como criterio de desempate.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio19 {

    private static double poderTotal(Entrenador e) {
        return e.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();
    }

    public static void main(String[] args) {
        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Gary", 10, List.of(
                        new Pokemon(1L, "Nidoking", "Veneno", 70, 1140, "Kanto", false),
                        new Pokemon(2L, "Arcanine", "Fuego", 65, 1200, "Kanto", false))),
                new Entrenador(2L, "Ash", 8, List.of(
                        new Pokemon(3L, "Pikachu", "Eléctrico", 45, 850, "Kanto", false),
                        new Pokemon(4L, "Charizard", "Fuego", 78, 1000, "Kanto", false))),
                new Entrenador(3L, "Dawn", 7, List.of(
                        new Pokemon(5L, "Piplup", "Agua", 30, 1050, "Sinnoh", false),
                        new Pokemon(6L, "Buneary", "Normal", 28, 1050, "Sinnoh", false))),
                new Entrenador(4L, "Brock", 6, List.of(
                        new Pokemon(7L, "Onix", "Roca", 55, 900, "Kanto", false),
                        new Pokemon(8L, "Geodude", "Roca", 40, 770, "Kanto", false)))
        );

        Comparator<Entrenador> ranking = Comparator
                .comparingInt(Entrenador::getMedallas).reversed()
                .thenComparing(Comparator.comparingDouble(Ejercicio19::poderTotal).reversed())
                .thenComparing(Entrenador::getNombre);

        List<Entrenador> top3 = entrenadores.stream()
                .sorted(ranking)
                .limit(3)
                .toList();

        IntStream.range(0, top3.size())
                .mapToObj(i -> "#" + (i + 1) + " " + top3.get(i).getNombre()
                        + " - " + top3.get(i).getMedallas() + " medallas, PC: " + (int) poderTotal(top3.get(i)))
                .forEach(System.out::println);
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio19.png)

**Explicación:** Este ejercicio pide un ranking con **tres niveles de criterio de desempate**, el caso de uso exacto para `Comparator.thenComparing()`: encadena comparadores donde el segundo solo se aplica si el primero considera dos elementos "empatados", y el tercero solo si los dos anteriores empatan también. Se construyó así: `comparingInt(Entrenador::getMedallas).reversed()` (más medallas primero), `.thenComparing(comparingDouble(Ejercicio19::poderTotal).reversed())` (en empate de medallas, gana mayor poder acumulado del equipo, reutilizando el método auxiliar `poderTotal()` del Ejercicio 17), y

### Ejercicio 20 — Pokédex Analítica

Construir una estructura que muestre: cantidad de Pokémon por tipo, por región, cantidad de legendarios, promedio de nivel y el Pokémon más fuerte. Todo usando únicamente Streams.

**Código implementado:**
```java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {

    public static void main(String[] args) {
        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Johto", true),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Charmander", "Fuego", 62, 380, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 78, 610, "Kanto", false)
        );

        Map<String, Long> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));

        Map<String, Long> porRegion = pokemones.stream()
                .collect(Collectors.groupingBy(Pokemon::getRegion, Collectors.counting()));

        long legendarios = pokemones.stream()
                .filter(Pokemon::isLegendario)
                .count();

        double promedioNivel = pokemones.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0);

        pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .ifPresent(p -> {
                    System.out.println("Por tipo: " + porTipo);
                    System.out.println("Por región: " + porRegion);
                    System.out.println("Legendarios: " + legendarios);
                    System.out.printf("Promedio niv: %.1f%n", promedioNivel);
                    System.out.println("Más fuerte: " + p.getNombre() + " (PC: " + (int) p.getPoderCombate() + ")");
                });
    }
}
```

**Captura de ejecución:** ![](evidencias/pokemon_ejercicio20.png)

**Explicación:** Este ejercicio de cierre combina prácticamente todos los operadores vistos en el taller. Se usó `groupingBy()` con `Collectors.counting()` (en vez del `Collectors.mapping()` de los ejercicios 13 y 14) porque aquí solo interesa *cuántos* Pokémon hay por grupo, no sus nombres — `counting()` es un recolector downstream que simplemente cuenta los elementos de cada grupo en vez de coleccionarlos. Para los legendarios se usó `filter()` con method reference (`Pokemon::isLegendario`) seguido de `count()`, ya que es un total simple sin necesidad de agrupar. El promedio de nivel reutiliza el patrón de `mapToInt()` + `average()` visto en el Ejercicio 11. Finalmente, para el Pokémon más fuerte se usó `max()` con `Comparator.comparingDouble()`, igual que en ejercicios anteriores, y se aprovechó el `ifPresent()` de ese resultado para imprimir todo el reporte junto, evitando declarar variables sueltas fuera de los streams.