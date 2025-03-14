/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboldeexpresion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
class Nodo{
  String valor;
  Nodo derecha;
  Nodo izquierda;
public Nodo(String value) {
        this.valor = value;
        this.izquierda = this.derecha = null;
    }  
}

class dibujo extends JPanel {
    Nodo raiz;

    public dibujo(Nodo raiz) {
        this.raiz = raiz;
        
    }

    private void dibujarArbol(Graphics g, Nodo nodo, int x, int y, int offset) {
        if (nodo == null) return;

        g.setColor(Color.BLACK);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(nodo.valor, x + 12, y + 18);
        
        
        if (nodo.izquierda != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x - offset + 15, y + 60);
            dibujarArbol(g, nodo.izquierda, x - offset, y + 60, offset / 2);
        }

        if (nodo.derecha != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x + offset + 15, y + 60);
            dibujarArbol(g, nodo.derecha, x + offset, y + 60, offset / 2);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarArbol(g, raiz, getWidth() / 2, 30, getWidth() / 4);
    }
}


