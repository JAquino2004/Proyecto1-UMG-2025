/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboldeexpresion;
import static javax.swing.JOptionPane.*;
/**
 *
 * @author Joshua
 */
public class variables {
    public String variables(String a){
        String inicio=a;
        
        String total="";
        for(int i = 0; i < a.length(); i++){
            if (!"+-*/^0123456789".contains(String.valueOf(inicio.charAt(i)))){
                 String variable = showInputDialog("DIGITA EL VALOR DE LA VARIABLE: "+a.charAt(i));
                a=a.replace(String.valueOf(a.charAt(i)), variable);
            }
        }
        
        return a;
    }
            
}
