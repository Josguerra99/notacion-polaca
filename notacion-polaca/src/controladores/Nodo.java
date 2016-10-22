/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Point;

/**
 *
 * @author Jose Guerra
 */
public class Nodo {
        
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    private int nivel;//Nivel al que se encuentra el nodo
    private String tag;//Nombre que se mostrara del nodo
    private Nodo parent;//Nodo padre
    private Nodo LftChild;//Nodo hijo derecha
    private Nodo rghtChild;//Nodo hijo izquierda
    private int pos;//Posicion relativa al nodo padre izq o der 0->izq 1->der
    
    protected int posRelativeToRoot;//La posicion relativa al nodo 0->izq 1->der
    protected int numFromCenter;//La posicion del nodo con respecto al centro (Por ejemplo pos 1 , 2 , 3 , 4)
    protected Vector2 panelPosition;//Posicion del este nodo en el panel
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Nodo() {
    }

    public Nodo(String tag) {
        this.tag = tag;
    }

    public Nodo(String tag, Nodo parent, Nodo childLft, Nodo childRght) {
        this.tag = tag;
        this.parent = parent;
        this.LftChild = childLft;
        this.rghtChild = childRght;
    }

    public Nodo(int nivel, String tag) {
        this.nivel = nivel;
        this.tag = tag;
    }
    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
            
    
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Nodo getParent() {
        return parent;
    }

    public void setParent(Nodo parent) {
        this.parent = parent;
    }
       
    public Nodo getLftChild() {
        return LftChild;
    }

    public void setLftChild(Nodo LftChild) {
        this.LftChild = LftChild;
    }

    public Nodo getRghtChild() {
        return rghtChild;
    }

    public void setRghtChild(Nodo rghtChild) {
        this.rghtChild = rghtChild;
    }
    
    
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    //</editor-fold>    


    
}
