/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Guerra
 */
public class CrearArbol {

    public static Arbol getArbol(String notacionPolaca) {
        Arbol arbol = new Arbol();

        String[] caracteres = notacionPolaca.split("");

        
        Node tempNode=new Node();        
        for (int i = 0; i < caracteres.length; i++) {
            
            
            if (i == 0) {//Creamos la raiz
                Node node=new Node(caracteres[i]);
                arbol.AddNodo(node, null);
                tempNode=node;
                continue;
            }
            
            if(esOperador(caracteres[i])){                
                while (tempNode.getLftChild()!=null&&tempNode.getRghtChild()!=null) { /*Mientras que el nodo tenga los dos hijos empezamos a buscar un nuevo temp node*/                   
                    tempNode=tempNode.getParent();
                }
                Node node=new Node(caracteres[i]);
                arbol.AddNodo(node, tempNode);
                tempNode=node;  
            }else{
                 while (tempNode.getLftChild()!=null&&tempNode.getRghtChild()!=null) { /*Mientras que el nodo tenga los dos hijos empezamos a buscar un nuevo temp node*/                   
                    tempNode=tempNode.getParent();
                }
                Node node=new Node(caracteres[i]);
                arbol.AddNodo(node, tempNode);                
            }
            
            
            

        }

        return arbol;

    }

    private static boolean esOperador(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^") || c.equals("%");
    }

}
