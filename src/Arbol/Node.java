/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import controladores.Vector2;
import java.awt.Point;

/**
 *
 * @author Jose Guerra
 */
public class Node {
        
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    private int nivel;//Nivel al que se encuentra el nodo
    private String tag;//Nombre que se mostrara del nodo
    private Node parent;//Nodo padre
    private Node LftChild;//Nodo hijo derecha
    private Node rghtChild;//Nodo hijo izquierda
    private int pos;//Posicion relativa al nodo padre izq o der 0->izq 1->der
    
    private int posRelativeToRoot;//La posicion relativa al nodo 0->izq 1->der
    private int numFromCenter;//La posicion del nodo con respecto al centro (Por ejemplo pos 1 , 2 , 3 , 4)
    private Vector2 panelPosition;//Posicion del este nodo en el panel
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Node() {
    }

    public Node(String tag) {
        this.tag = tag;
        this.LftChild=null;
        this.rghtChild=null;
        this.parent=null;
    }

    public Node(String tag, Node parent, Node childLft, Node childRght) {
        this.tag = tag;
        this.parent = parent;
        this.LftChild = childLft;
        this.rghtChild = childRght;
    }

    public Node(int nivel, String tag) {
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
       
    public Node getLftChild() {
        return LftChild;
    }

    public void setLftChild(Node LftChild) {
        this.LftChild = LftChild;
    }

    public Node getRghtChild() {
        return rghtChild;
    }

    public void setRghtChild(Node rghtChild) {
        this.rghtChild = rghtChild;
    }
    
    
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public int getPosRelativeToRoot() {
        return posRelativeToRoot;
    }

    public void setPosRelativeToRoot(int posRelativeToRoot) {
        this.posRelativeToRoot = posRelativeToRoot;
    }

    public int getNumFromCenter() {
        return numFromCenter;
    }

    public void setNumFromCenter(int numFromCenter) {
        this.numFromCenter = numFromCenter;
    }

    public Vector2 getPanelPosition() {
        return panelPosition;
    }

    public void setPanelPosition(Vector2 panelPosition) {
        this.panelPosition = panelPosition;
    }



    //</editor-fold>    

    
    
}
