/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboldeexpresion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Joshua
 */

class Nodo{
  String valor;
  Nodo derecha;
  Nodo izquierda;
public Nodo(String value) {
        this.valor = value;
        this.izquierda = this.derecha = null;
    }  
}
public class ArboldeExpresion {
    
    Nodo raiz;
    Postfija a=new Postfija();
    
    public ArboldeExpresion(String expresion){
       raiz=crearArbolExpresion(expresion);
    }
    
public String recorridoPostorden(Nodo nodo) {
        if (nodo == null) return "";
        return recorridoPostorden(nodo.izquierda)+ recorridoPostorden(nodo.derecha)+ nodo.valor;
    }

public String recorridoInorden(Nodo nodo) {
        if (nodo == null) return "";
        return recorridoInorden(nodo.izquierda) + nodo.valor + recorridoInorden(nodo.derecha);
    }

public String recorridoPreorden(Nodo nodo) {
        if (nodo == null) return "";
        return nodo.valor+ recorridoPreorden(nodo.izquierda) + recorridoPreorden(nodo.derecha);
    }
 
   
 
    public Nodo crearArbolExpresion(String expresion) {
        String[] tokens = a.getTokens(expresion);
        List<String> polacaInversa = a.PolacaInversa(tokens);
        Stack<Nodo> pila = new Stack<>();
        
        
      

        for (String token : polacaInversa) {
            if (!"^()*/+-".contains(token)) { // Si es número, crea un nodo hoja
                pila.push(new Nodo(token));
            } else { // Si es operador, crea un nodo con dos hijos
                Nodo derecha = pila.pop();
                Nodo izquierda = pila.pop();
                Nodo nuevo = new Nodo(token);
                nuevo.izquierda=(izquierda);
                nuevo.derecha=(derecha);
                pila.push(nuevo);
            }
        }
        return pila.pop(); 
        
        
    }

 
    
    

    /**
     * @param args the command line arguments
     */
    

}

 