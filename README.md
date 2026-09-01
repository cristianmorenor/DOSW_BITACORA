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