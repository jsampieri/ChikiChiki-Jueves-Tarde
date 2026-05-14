# Ejercicios de costos

## Ejercicio 1

La complejidad temporal en el peor caso es **O(n²)**.

Esto ocurre porque, si no aparece ningún `5` ni ningún `6`, el método recorre todo el arreglo y además ejecuta un ciclo interno que depende del valor de `i`.

En total, el ciclo interno hace aproximadamente `0 + 1 + 2 + ... + (n - 1)` vueltas, por eso el costo termina siendo cuadrático.

## Ejercicio 2

En una **ColaPU estática**, la operación `Acolar(x)` cuesta **O(n)**.

Esto pasa porque el nuevo elemento se agrega en la posición `0`, entonces hay que desplazar todos los elementos hacia la derecha.

En una **ColaPI estática**, `Acolar(x)` cuesta **O(1)**.

Esto pasa porque el nuevo elemento se agrega directamente al final del arreglo.

En una **ColaLD dinámica**, `Acolar(x)` también cuesta **O(1)**.

Esto pasa porque la cola tiene un puntero al último nodo, entonces no hace falta recorrer toda la estructura.

La implementación **PU** es distinta porque agregar al principio obliga a mover elementos, mientras que en las otras se agrega directamente al final.

## Ejercicio 3

La complejidad temporal del algoritmo `filtrar` es **O(n)**.

Esto ocurre porque cada elemento de la cola se procesa una cantidad constante de veces.

Aunque se use una cola auxiliar para restaurar la original, el recorrido sigue siendo proporcional a la cantidad de elementos.

La complejidad espacial es **O(n)**.

Esto se debe a que se usa una estructura auxiliar que puede guardar hasta `n` elementos.

Además, la cola resultado también puede llegar a guardar hasta `n` elementos si todos cumplen la condición.

## Ejercicio 4

La complejidad total del método es **O(n)**.

La primera instrucción de impresión cuesta **O(1)**.

El primer ciclo recorre todo el arreglo una vez, por eso cuesta **O(n)**.

El segundo ciclo también recorre todo el arreglo una vez, por eso también cuesta **O(n)**.

Entonces, el costo total es `O(1) + O(n) + O(n)`, que se simplifica como **O(n)**.

## Ejercicio 5

La complejidad de recorrer una matriz cuadrada de `n x n` es **O(n²)**.

Esto pasa porque la matriz tiene `n²` elementos en total.

El peor caso ocurre cuando el número par está en la última posición o cuando directamente no hay ningún número par.

En ese caso, hay que recorrer toda la matriz.

## Ejercicio 6

La complejidad total del bloque de código es **O(n²)**.

El Bloque A tiene un ciclo simple que recorre el arreglo una vez, entonces cuesta **O(n)**.

El Bloque B tiene dos ciclos anidados, y cada uno recorre hasta `n`, entonces cuesta **O(n²)**.

El costo total es `O(n) + O(n²)`.

Por jerarquía de dominancia, se conserva el término más grande, por eso queda **O(n²)**.

## Ejercicio 7

La búsqueda binaria tiene complejidad **O(log n)**.

Esto ocurre porque en cada paso divide la cantidad de datos a la mitad.

Primero revisa sobre `n` elementos, después sobre `n/2`, después sobre `n/4`, después sobre `n/8`, y así sucesivamente.

La cantidad de divisiones necesarias hasta llegar a un solo elemento es logarítmica.

Por eso la búsqueda binaria no es lineal, sino **O(log n)**.

## Ejercicio 8

La complejidad real de calcular la intersección de dos conjuntos estáticos es **O(n²)**.

Aunque se recorra el conjunto `A` una sola vez, por cada elemento se llama a `B.Pertenece(x)`.

En una implementación estática, `Pertenece(x)` puede tener que recorrer todo el conjunto `B`, por eso cuesta **O(n)**.

Como se llama `n` veces, el costo es `n * O(n)`, es decir, **O(n²)**.

Además, `Agregar(x)` también puede validar que el elemento no esté repetido, lo cual también puede costar **O(n)**.

Por eso, considerando las validaciones internas del TDA, el costo final sigue siendo **O(n²)**.

## Ejercicio 9

La operación `Desacolar()` en una cola con prioridad implementada con `K` subcolas cuesta **O(K)**.

Esto pasa porque puede tener que revisar las subcolas una por una hasta encontrar la primera que tenga elementos.

No depende de la cantidad total de elementos `n`, porque no se recorren todos los datos cargados.

Solo se revisan las prioridades disponibles.

Por eso, si hay `K` prioridades, el costo se expresa como **O(K)**.

Si `K` fuera fijo, también podría considerarse **O(1)**.

## Ejercicio 10

La complejidad del Fibonacci recursivo es **exponencial**, aproximadamente **O(2ⁿ)**.

Esto ocurre porque cada llamada genera dos nuevas llamadas: `fibonacci(n - 1)` y `fibonacci(n - 2)`.

Entonces se forma un árbol de llamadas que crece muy rápido.

Además, muchas llamadas se repiten varias veces.

Por eso no es constante ni lineal, sino exponencial.

## Resumen final

| Ejercicio | Complejidad |
|---|---|
| Ejercicio 1 | O(n²) |
| Ejercicio 2 - ColaPU | O(n) |
| Ejercicio 2 - ColaPI | O(1) |
| Ejercicio 2 - ColaLD | O(1) |
| Ejercicio 3 - Tiempo | O(n) |
| Ejercicio 3 - Espacio | O(n) |
| Ejercicio 4 | O(n) |
| Ejercicio 5 | O(n²) |
| Ejercicio 6 | O(n²) |
| Ejercicio 7 | O(log n) |
| Ejercicio 8 | O(n²) |
| Ejercicio 9 | O(K) |
| Ejercicio 10 | O(2ⁿ) |
