/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.geometry.Pos;

/**
 *
 * @author Jose Guerra
 */
public class Arbol {

    private Node root;//Nodo raiz 
    private ArrayList<Node> nodos;//La lista de todos los nodos
    private int maxLvl = 0;

    public Arbol() {
        nodos = new ArrayList<>();//Inicializamos la lista
    }

    //<editor-fold defaultstate="collapsed" desc="Añadir nodo">    
    /*Añade un nodo automaticamente (Busca si esta vacio el izq o der y lo añade)*/
    public void AddNodo(Node nodo, Node parent) {

        if (nodos.isEmpty()) {
            /*Creamos la raiz*/
            root = nodo;
            root.setNivel(0);/*El root es nivel 0*/
            nodos.add(root);
            nodo.setNumFromCenter(0);
            return;
        }

        if (parent.getLftChild() == null) {
            parent.setLftChild(nodo);
            nodo.setParent(parent);
            nodo.setNivel(parent.getNivel() + 1);
            maxLvl = maxLvl <= nodo.getNivel() ? nodo.getNivel() : maxLvl;/*Si este nivel es mayor al maximo que existe cambiamos valores*/
            nodos.add(nodo);/*Añadimos el nodo a la lista de nodos*/
            
            /*La posicion relativa a la raiz*/
            nodo.setPosRelativeToRoot(nodo.getParent()==root?0:nodo.getParent().getPosRelativeToRoot());/*Si es el nodo hijo del root miramos la posicion si no solo agarramos el del padre*/
            
            nodo.setPos(0);
            nodo.setNumFromCenter(getPositionFromCenter(nodo));/*Agregamos la posicion hacia en centro*/

            

            SortByLevel();
            return;
        }

        if (parent.getRghtChild() == null) {
            parent.setRghtChild(nodo);
            nodo.setParent(parent);
            nodo.setNivel(parent.getNivel() + 1);
            maxLvl = maxLvl <= nodo.getNivel() ? nodo.getNivel() : maxLvl;/*Si este nivel es mayor al maximo que existe cambiamos valores*/
            nodos.add(nodo);/*Añadimos el nodo a la lista de nodos*/
            
            /*La posicion relativa a la raiz*/
            nodo.setPosRelativeToRoot(nodo.getParent()==root?1:nodo.getParent().getPosRelativeToRoot());/*Si es el nodo hijo del root miramos la posicion si no solo agarramos el del padre*/
            
            nodo.setPos(1);
            nodo.setNumFromCenter(getPositionFromCenter(nodo));/*Agregamos la posicion hacia en centro*/
            SortByLevel();
        }

    }

       

    private int getPositionFromCenter(Node nodo) {

        if (nodo.getParent() == root) {/*Si es el hijo de la raiz la posicion siempre sera 1*/
            return 1;
        }
        
        int pos=0;
        
        if(nodo.getPosRelativeToRoot()==0){/*Si esta a la izquierda del arbol*/
            /*Significa que los nodos que vayan hacia la derecha del nodo padre estan mas cercanos al centro*/
            pos=nodo.getParent().getNumFromCenter();
            pos+=nodo.getPos()==0?pos:pos-1;
            return  pos;
        }
        
        if(nodo.getPosRelativeToRoot()==1){/*Si esta a la derecha del arbol*/
            /*Significa que los nodos que vayan hacia la izquierda del nodo padre estan mas cercanos al centro*/
            pos=nodo.getParent().getNumFromCenter();
            pos+=nodo.getPos()==1?pos:pos-1;
            return  pos;

        }
        

        return 0;
    }

    //</editor-fold>
    public void printTree() {
        nodos.stream().forEach((nodo) -> {
            System.out.println("/>" + nodo.getNivel() + " " + nodo.getTag() + " " + nodo.getPos()+"   "+nodo.getNumFromCenter());
        });
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getMaxLvl() {
        return maxLvl;
    }

    public void setMaxLvl(int maxLvl) {
        this.maxLvl = maxLvl;
    }

    public ArrayList<Node> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Node> nodos) {
        this.nodos = nodos;
    }
    //</editor-fold>

    public void SortByLevel() {
        Collections.sort(nodos, sortByLevel);
    }

    /*Un comparador para ordenar la lista*/
    private final Comparator<Node> sortByLevel = (Node t, Node t1) -> {

        /*Primero compara con el nivel del nodo*/
        int resultado = Integer.compare(t.getNivel(), t1.getNivel());

        if (resultado != 0) {
            return resultado;
        }

        /*Luego compara con la posicion (izq o der)*/
        resultado = Integer.compare(t.getPos(), t1.getPos());

        return resultado;
    };

}
