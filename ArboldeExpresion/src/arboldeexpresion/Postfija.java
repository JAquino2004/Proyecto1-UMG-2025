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
public class Postfija {
     private static final Map<String, Integer> precedence = new HashMap<>();

    static {
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("^", 3);
        
    }

    public static String ComprobarInversa(String[] tokens) {
       String expresion ="";
        Stack<String> pila = new Stack<>();

        for (String token : tokens) {
           
            if (!"^()*/+-".contains(token))  { //es un numero
                expresion+=(token);
            } else if (precedence.containsKey(token)) { // Es operador
                while (!pila.isEmpty() && precedence.getOrDefault(pila.peek(), 0) >= precedence.get(token)) {
                    if(!(precedence.getOrDefault(pila.peek(), 0)==3 && precedence.get(token)==3)){
                         expresion+=pila.pop();
                    }else{
                        break;
                        }
                   
                }
                pila.push(token);
            } else if (token.equals("(")) {
                pila.push(token);
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    expresion+=pila.pop();
                }
                pila.pop(); // Elimina '('
            }
        }

        while (!pila.isEmpty()) {
            expresion+=pila.pop();
        }
        return expresion;
    }
    

     public static List<String> PolacaInversa(String[] tokens) {
        List<String> expresion = new ArrayList<>();
        Stack<String> pila = new Stack<>();

        for (String token : tokens) {
           
            if (!"^()*/+-".contains(token))  { //es un numero
                expresion.add(token);
            } else if (precedence.containsKey(token)) { // Es operador
                while (!pila.isEmpty() && precedence.getOrDefault(pila.peek(), 0) >= precedence.get(token)) {
                    if(!(precedence.getOrDefault(pila.peek(), 0)==3 && precedence.get(token)==3)){
                         expresion.add(pila.pop());
                    }else{
                        break;
                        }
                   
                }
                pila.push(token);
            } else if (token.equals("(")) {
                pila.push(token);
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    expresion.add(pila.pop());
                }
                pila.pop(); // Elimina '('
            }
        }

        while (!pila.isEmpty()) {
            expresion.add(pila.pop());
        }
        return expresion;
    }
    public static String[] getTokens(String expresion) {
        return expresion.replace(" ", "")
                .replace("^", ",^,")
                .replace("*", ",*,")
                .replace("/", ",/,")
                .replace("+", ",+,")
                .replace("-", ",-,")
                .replace(")", ",),")
                .replace("(", ",(,")
                .replace(",,", ",").split(",");
    }
    
    public static List<String> PolacaInversa(String tokens) {
          return PolacaInversa(getTokens(tokens));
        
        
    }
    public static String ComprobarInversa(String tokens) {
          return ComprobarInversa(getTokens(tokens));
        
        
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    

}

 