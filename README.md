# PROYECTO 1 ARBOL DE EXPRESION EN JAVA
Este es un proyecto cuya funcionalidad se resume en recibir en una caja de texto una expresión matemática
y en las demas cajas de texto escribir los distintos recorridos que posee el arbol, mientras que al mismo
tiempo se abre una ventana la cual posee un dibujo del arbol en si.

## Las clases que posee el código son
- ArboldeExpresion.java
- FormularioArbol.java
- Postfija.java
- correcta.java
- dibujo.java
- variables.java

### ArboldeExpresion
La función de esta clase es la de poder generar un arbol de expresion y tener metodos para sus recorridos, para ello se utiliza un algoritmo en donde se apilan nodos con valores de la expresion
y en el momento en el que se obtiene un operador se hace un nodo que guarda 2 nodos anteriores como sus hijos.
Sus metodos son:
- Nodo
- recorridoPostorden
- recorrido Inorden
- recorrido Preorden
- crearArbolExpresion

### Postfija
Es una funcion que se utiliza para poder convertir una expresion a infija, utilizando listas y arreglos para separar y ordenar la expresion, y usando un algoritmo de pilas para 
definir el orden de estas, tambien hay una funcion hecha para retornar directamente un string para luego usarlo como prueba de que el recorrido Postorden de la anterior clase sea correcto
Sus metodos son:
- ComprobarInversa (tanto para string como para arreglos string)
- PolacaInversa (tanto para string como para arreglos string)
- GetTokens

### correcta
Es una función cuyo objetivo es el analizar si la expresion que nos da el usuario es una correcta, su única función es "revisar" que devuelve un valor booleano

### Variables
Es una función cuyo objetivo es tomar las variables del código para pedirle al usuario mediante un JPane que ingrese los valores de estas variables, su unica funcion es un constructor.

### dibujo
Es una función cuyo objetivo es el de imprimir el arbol, mediante swing y las coordenadas de lo que se va a dibujar, tiene las clases:
- Nodo
- dibujo
- dibujarArbol

### FormularioArbol
Es la clase principal, la cual llama a un formulario para realizar todas las operaciones del programa.
