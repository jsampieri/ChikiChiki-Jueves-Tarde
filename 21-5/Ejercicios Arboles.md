# Ejercicios de Árboles

## EJERCICIO 1 — Construcción de ABB

Insertá en un ABB inicialmente vacío los siguientes valores en este orden:

**50, 30, 70, 20, 40, 60, 80**

1. Describí el árbol resultante nodo por nodo.
2. Indicá el recorrido **in-order** y la altura del árbol medida en aristas, considerando que una hoja tiene altura 0.

### Resultado del árbol

```text
        50
      /    \
    30      70
   /  \    /  \
 20   40  60   80
```

### Nodo por nodo

| Nodo | Ubicación |
|---:|---|
| 50 | Raíz del árbol. |
| 30 | Menor que 50 → va a la izquierda de 50. |
| 70 | Mayor que 50 → va a la derecha de 50. |
| 20 | Menor que 50 y menor que 30 → va a la izquierda de 30. |
| 40 | Menor que 50 y mayor que 30 → va a la derecha de 30. |
| 60 | Mayor que 50 y menor que 70 → va a la izquierda de 70. |
| 80 | Mayor que 50 y mayor que 70 → va a la derecha de 70. |

### Recorrido in-order

```text
20 → 30 → 40 → 50 → 60 → 70 → 80
```

### Altura del árbol

La altura del árbol es **2 aristas**, porque el camino más largo desde la raíz hasta una hoja tiene 2 aristas.

Ejemplo:

```text
50 → 30 → 20
```

---

## EJERCICIO 2 — Traza de búsqueda

Sobre el árbol anterior, trazá la búsqueda del valor **55**.

1. Indicá la secuencia de nodos visitados.
2. Indicá la cantidad de comparaciones de clave. El chequeo contra `null` no cuenta.

### Secuencia de búsqueda

```text
50 → 70 → 60 → null
```

El valor **55 no se encuentra** en el árbol.

### Comparaciones

| Paso | Nodo | Comparación | Decisión |
|---:|---:|---|---|
| 1 | 50 | 55 > 50 | Ir a la derecha. |
| 2 | 70 | 55 < 70 | Ir a la izquierda. |
| 3 | 60 | 55 < 60 | Ir a la izquierda. |
| 4 | null | — | No existe el nodo. |

**Comparaciones de clave:** 3

---

## EJERCICIO 3 — Eliminación en ABB

Sobre el árbol del Ejercicio 1, eliminá el nodo **30** usando el criterio del sucesor in-order.

1. Indicá el caso de eliminación: hoja, un hijo o dos hijos.
2. Identificá el valor del sucesor in-order y describí el árbol resultante.

### Caso de eliminación

El nodo **30** tiene dos hijos:

```text
    30
   /  \
 20   40
```

Por lo tanto, corresponde el caso de **eliminación de un nodo con dos hijos**.

### Sucesor in-order

El sucesor in-order de **30** es **40**, porque es el menor valor del subárbol derecho de 30.

### Árbol resultante

```text
        50
      /    \
    40      70
   /       /  \
 20       60   80
```

### Recorrido in-order antes y después

Antes:

```text
20 → 30 → 40 → 50 → 60 → 70 → 80
```

Después:

```text
20 → 40 → 50 → 60 → 70 → 80
```

---

## EJERCICIO 4 — Factores de balance AVL

Dado un AVL con los valores **30, 20, 40, 10, 25** insertados en ese orden.

1. Describí la estructura nodo por nodo.
2. Indicá el factor de balance de cada nodo usando:

```text
bf = h(izq) - h(der)
h(null) = -1
```

### Estructura del árbol

```text
        30
      /    \
    20      40
   /  \
 10   25
```

### Factores de balance

| Nodo | h(izq) | h(der) | bf = h(izq) - h(der) |
|---:|---:|---:|---:|
| 10 | -1 | -1 | 0 |
| 25 | -1 | -1 | 0 |
| 40 | -1 | -1 | 0 |
| 20 | 0 | 0 | 0 |
| 30 | 1 | 0 | 1 |

El árbol está balanceado porque todos los factores de balance están entre **-1 y 1**.

---

## EJERCICIO 5 — Rotación AVL: Caso LL

En un AVL que contiene **30** y **20**, insertá el valor **10**.

1. Identificá el nodo desbalanceado y su factor de balance.
2. Indicá el tipo de rotación y describí el árbol final rebalanceado.

### Paso 1: Árbol inicial

Como **20 < 30**, el nodo 20 queda como hijo izquierdo de 30.

```text
    30
   /
 20
```

### Paso 2: Inserción del 10

Como **10 < 30** y **10 < 20**, queda a la izquierda de 20.

```text
      30
     /
   20
  /
10
```

### Paso 3: Cálculo de factores de balance

Se calcula de abajo hacia arriba.

| Nodo | h(izq) | h(der) | bf | Estado |
|---:|---:|---:|---:|---|
| 10 | -1 | -1 | 0 | Balanceado |
| 20 | 0 | -1 | 1 | Balanceado |
| 30 | 1 | -1 | 2 | Desbalanceado |

El nodo desbalanceado es **30**, con **bf = +2**.

### Paso 4: Tipo de rotación

El camino desde el nodo desbalanceado hasta el nodo insertado es:

```text
30 → izquierda → 20 → izquierda → 10
```

Esto corresponde al caso **LL**.

Por lo tanto, se aplica una **rotación simple a la derecha** sobre el nodo 30.

### Árbol final rebalanceado

```text
    20
   /  \
 10    30
```

---

## EJERCICIO 6 — Rotación AVL: Caso LR

En un AVL que contiene **30** y **20**, insertá el valor **25**.

1. Identificá el nodo desbalanceado y su factor de balance.
2. Detallá los movimientos de la rotación doble y describí el árbol final.

### Paso 1: Árbol luego de insertar 25

Como **25 < 30** y **25 > 20**, queda como hijo derecho de 20.

```text
      30
     /
   20
     \
      25
```

### Paso 2: Nodo desbalanceado

El nodo desbalanceado es **30**.

```text
bf(30) = h(izq) - h(der) = 1 - (-1) = 2
```

Como el camino es izquierda-derecha, corresponde el caso **LR**.

```text
30 → izquierda → 20 → derecha → 25
```

### Paso 3: Rotación doble

Primero se realiza una **rotación simple a la izquierda** sobre 20.

Antes:

```text
      30
     /
   20
     \
      25
```

Después de rotar a la izquierda sobre 20:

```text
      30
     /
   25
  /
20
```

Luego se realiza una **rotación simple a la derecha** sobre 30.

### Árbol final rebalanceado

```text
    25
   /  \
 20    30
```

---

## EJERCICIO 7 — Árbol B de orden 3

Definí las reglas de un Árbol B de orden 3, considerando que el orden es la cantidad máxima de hijos.

1. Indicá la cantidad máxima de claves por nodo.
2. Indicá la cantidad mínima de claves por nodo no raíz.

### Reglas principales

| Regla | Valor |
|---|---:|
| Máximo de hijos por nodo | 3 |
| Máximo de claves por nodo | 2 |
| Mínimo de claves por nodo no raíz | 1 |
| Mínimo de hijos en nodo interno no raíz | 2 |
| Todas las hojas deben estar al mismo nivel | Sí |

### Ejemplo de overflow

Un nodo de un Árbol B de orden 3 puede tener como máximo **2 claves**.

```text
[10]           OK
[10, 20]       OK
[10, 20, 30]   Overflow
```

Cuando ocurre overflow, se hace split.

```text
        [20]
       /    \
    [10]    [30]
```

---

## EJERCICIO 8 — Inserción en Árbol B de orden 3

En un Árbol B de orden 3 vacío, insertá **10, 20, 30**.

1. Explicá la condición de overflow al insertar el 30.
2. Indicá la clave promocionada y describí la estructura final.

### Paso 1: Insertar 10

```text
[10]
```

### Paso 2: Insertar 20

```text
[10, 20]
```

Todavía está permitido, porque el máximo es **2 claves por nodo**.

### Paso 3: Insertar 30

Al intentar insertar 30, el nodo queda temporalmente así:

```text
[10, 20, 30]
```

Esto genera **overflow**, porque el nodo supera el máximo de 2 claves.

### Split

La clave del medio, **20**, se promociona a la raíz.

```text
        [20]
       /    \
    [10]    [30]
```

### Estructura final

| Parte | Contenido |
|---|---|
| Raíz | [20] |
| Hoja izquierda | [10] |
| Hoja derecha | [30] |
