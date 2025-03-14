/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboldeexpresion;

/**
 *
 * @author Joshua
 */
public class correcta {

   static public boolean revisar(String expresion) {
        if (expresion.length() < 3) {
            return false;
        } else if ("+*/^".contains(String.valueOf(expresion.charAt(0))) || "+*/^".contains(String.valueOf(expresion.charAt(expresion.length()-1)))) {
            return false;
        } else {
            for (int i = 0; i < expresion.length(); i++) {
                if ("+-*/^".contains(String.valueOf(expresion.charAt(i)))) {
                    if ("+-*/^".contains(String.valueOf(expresion.charAt(i - 1))) || "+-*/^".contains(String.valueOf(expresion.charAt(i + 1)))) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
   

}
