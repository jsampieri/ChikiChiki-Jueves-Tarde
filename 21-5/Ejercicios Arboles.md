## EJERCICIO 1 — Construcción de ABB 

Insertá en un ABB inicialmente vacío los siguientes valores en este orden: 50, 30, 70, 20, 40, 60, 80\.  
1.Describí el árbol resultante nodo por nodo.  
2.Indicá el recorrido In-orden y la altura del árbol medida en aristas (hoja \= altura 0). 

Insertando: 50,30,70,20,30,60,80  
**Resultado del arbol:**

50  
           /    \\  
        30    70  
        /  \\      /  \\  
     20 40 60 80

**Nodo por nodo:**  
50 → Raiz  
30 → Menor que 50 → va a la izquierda de 50  
70 → Mayor que 50 → Va a la derecha  
20 → Menor que 50 →menor que 30→Izquierda de 30  
40 → Menor que 50 → Mayor que 30→Derecha de 30  
 60 → Mayor que 50 → Menor que 70 → Izquierda de 70  
80 → Mayor que 50 → Mayor que 70 → Derecha de 70

IN-ORDER (izq→raiz→der):20,30,40,50,60,70,80

## EJERCICIO 2 — Traza de Búsqueda 

Sobre el árbol anterior, trazá la búsqueda del valor 55\.  
1.Indicá la secuencia de nodos visitados (→).  
2.Indicá la cantidad de comparaciones de clave (el chequeo contra null no cuenta).

50 → 70 → 60 → null (no se encontro)

| Paso | Nodo | Comparacion |
| :---- | :---- | :---- |
| 1 | 50 | 55\>50 → Derecha |
| 2 | 70 | 55\<70 → Izquierda |
| 3 | 60 | 55\<60→Izquierda |
| 4 | null | No existe |

Comparaciones de clave: **3**

## **EJERCICIO 3 — Eliminación en ABB**   Sobre el árbol del Ejercicio 1, eliminá el nodo 30 usando el criterio del sucesor in-orden.  1.Indicá el caso de eliminación (hoja / un hijo / dos hijos).  2.Identificá el valor del sucesor en-orden y describí el árbol resultante.

1. El nodo 30 tiene dos hijos (20 y 40), por lo que hay que reemplazarlo por un sucesor in-orden.  
2. El valor del sucesor in-order es 40 ya que es el mínimo del subárbol derecho.

Árbol resultante:   
50  
           /   \\  
        40   70  
        /       /  \\  
     20     60 80

Antes: 20 → 30 → 40 → 50 → 60 → 70 → 80 

Después: 20 → 40 → 50 → 60 → 70 → 80 

## EJERCICIO 4 — Factores de Balance AVL

Dado un AVL con los valores 30, 20, 40, 10, 25 insertados en ese orden.

1.Describí la estructura nodo por nodo.

30  
           /   \\  
        20   40  
        /  \\       
     10   25 

2.Indicá el Factor de Balance (bf) de cada nodo: bf=h(izq)−h(der), con h(null)=−1.

Nodo 30: bf \= 1-0 \=1, Nodo 20: bf \= 0-0 \=0, Nodo 40: bf \= \-1-(-1) \=0, Nodo 10: bf \= \-1-(-1) \=0

Nodo 25: bf \= \-1-(-1) \=0

está balanceado porque los valores se encuentran entre \-1 y 1\.

## EJERCICIO 5 — Rotación AVL: Caso LL 

En un AVL que contiene 30 y 20, insertá el valor 10\.  
1.Identificá el nodo desbalanceado y su bf.  
2.Indicá el tipo de rotación y describí el árbol final rebalanceado.

Paso 1: Árbol inicial

  El AVL contiene 30 y 20\. Como 20 \< 30, el 20 es hijo izquierdo de 30:

        30  
       /  
    20

  Paso 2: Inserción del 10

     	 30  
    	 /  
          20  
          /  
       10

  Paso 3: Cálculo de alturas y balance factors

  Se calcula de abajo hacia arriba:

  \- Nodo 10: altura izq \= −1, altura der \= −1, bf \= 0 → balanceado.  
  \- Nodo 20: altura izq \= 0, altura der \= −1, bf \= \+1 → balanceado.  
  \- Nodo 30: altura izq \= 1, altura der \= −1, bf \= \+2 → desbalanceado.

  Nodo desbalanceado: 30, con bf \= \+2.

  Paso 4: Identificación del tipo de rotación

  Se analiza el camino desde el nodo desbalanceado hasta el nodo insertado:

  \- Desde 30 bajamos a la izquierda hacia 20 → primera L.  
  \- Desde 20 bajamos a la izquierda hacia 10 → segunda L.

  Caso LL → Rotación Simple a la Derecha sobre el nodo 30\.

  Paso 5: Árbol final rebalanceado

  Tras la rotación simple a la derecha sobre 30:  
  \- 20 pasa a ser la nueva raíz.  
  \- 10 queda como hijo izquierdo de 20\.  
  \- 30 queda como hijo derecho de 20\.

       20  
      /     \\  
    10   30

## EJERCICIO 6 — Rotación AVL: Caso LR 

En un AVL que contiene 30 y 20, insertá el valor 25\.  
1.Identificá el nodo desbalanceado y su bf.  
En este caso el nodo desbalanceado es 30 debido a que el subarbol izquierdo tiene mayor  altura que el derecho. Y su factor de balance es 2 ya que la resta para obtenerlo da como resultado 2 \- 0 \= 2\.

2.Detallá los movimientos de la rotación doble y describí el árbol final.

En este caso usamos una RDI:  
Primero realiza una rotacion simple a la izquierda sobre 20:  
                30  
    /  
  25  
  /  
20  
Despues hace una rotacion simple a la derecha sobre 30:

    25  
   /   \\  
 20  30  
 

## EJERCICIO 7 — Árbol B de orden 3 

Definí las reglas de un Árbol B de orden 3 (orden \= cantidad máxima de hijos).  
 1.Cantidad máxima de claves por nodo.  
 2.Cantidad mínima de claves por nodo no raíz.

✅ \[10\]

✅ \[10, 20\]

❌ \[10, 20, 30\]  → overflow, hay que hacer split

        \[20\]          ← nivel 0 (raíz)

       /    \\

    \[10\]    \[30\]      ← nivel 1 (hojas, mismo nivel) ✅

| REGLA | VALOR |
| :---- | :---- |
| Max Hijos por Nodo | 3 |
| Max Claves por Nodo | 2 (Orden \-1) |
| Min Claves por nodo no raiz | 1(\[Orden/2\]-1=1 |
| Min Hijos de nodo interno no raiz | 2 |
| Todas las hojas al mismo nivel | ✅  |

**EJERCICIO 8 — Inserción en Árbol B orden 3**   
 En un Árbol B de orden 3 vacío, insertá 10, 20, 30\.  
 1.Explicá la condición de overflow al insertar el 30\.  
 2.Indicá la clave promocionada y describí la estructura final (Raíz y Hojas).

Insertamos 10,20,30:  
Insertar 10:  
\[10\]  
Insertar 20:   
\[10,20\] ←ok, max 2 claves

Insertar 30 → Overflow:  
1- Condición de overflow: El nodo ya tiene 2 claves máximo y queremos agregar una tercera→ Overflow  
2- Split:  
Nodo temporal: \[ 10,20,30\]  
Clave del medio \= 20 → se promociona a la raíz  
Queda 2 hojas: \[10\] y \[30\]  
Estructura Final:

   \[20|   \]         ←- Raiz  
	  /      	\\  
/      	 \\  
       \[10|   \]        \[30|   \]   ←— Hoja