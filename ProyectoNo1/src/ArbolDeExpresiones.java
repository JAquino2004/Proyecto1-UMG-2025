 
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAR10
 */
public class ArbolDeExpresiones {
    
    ArbolDeExpresiones raiz;
    
    //constructor
    public ArbolDeExpresiones(ArbolDeExpresiones raiz) {
        this.raiz = null;
    }
    
    // metodo para valir el operador
    public static boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '*' ||c == '/');
    }
    
    //metodo para construir el arbol
    public static Nodo construirArbolPostfijo(String cadena){
        Stack<Nodo> pila = new Stack<>();
        
        //hacemos un recorrido de la cadena de caracteres ingresada para validar la expresiosn
        for(int i=0; i<cadena.length();i++){
            char valor = cadena.charAt(i);
            
            //validamos si en la cadena se encuentran espacios en blanco ingresados por el usuario
            if(valor == ' ') continue;
            //usamos un metodo de la clase Character para validar si el caracter es un digito
            if(Character.isDigit(valor)){
                pila.push(new Nodo(String.valueOf(valor)));
            }else if(isOperator(valor)){
                //si el caracter es un operador, creamos un nuevo nodo que contendra ese operador
                Nodo operator = new Nodo(String.valueOf(valor));
                //sacamos los datos que estan en la pila y le asignamos el operador
                operator.derecha = pila.pop();
                operator.izquierda = pila.pop();
                
                //añadimos el operador a la pila
                pila.push(operator);
            }
            
        }
        return pila.pop();
    }
    
    
    //metodo que imprime la expresion del arbol en preorden
    public void preOrden(Nodo raiz){
        if(raiz != null){
            System.out.println(raiz.expresion + " ");
            preOrden(raiz.izquierda);
            preOrden(raiz.derecha);
        }
        
    }
    
    //metodo que imprime la expresion del arbol en inorden
    public void inOrden(Nodo raiz){
        inOrden(raiz.izquierda);
        System.out.println(raiz.expresion + " ");
        inOrden(raiz.derecha);
    }
    
    //metodo que imprime la expresion del arbol en postorden
    public void postOrden(Nodo raiz){
        postOrden(raiz.izquierda);
        postOrden(raiz.derecha);
        System.out.println(raiz.expresion + " ");
    }
    
}
