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

**Captura de ejecución:** ![img.png](img.png)

**Explicación:** Se usó `filter()` con una expresión lambda para evaluar dos condiciones (número par y mayor a 10) sobre el Stream de la lista original, obteniendo así únicamente los elementos que cumplen ambas.