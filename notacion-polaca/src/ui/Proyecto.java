/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controladores.Arbol;
import controladores.Nodo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jose Guerra
 */
public class Proyecto extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*Inicializamos la ventana de JavaFX*/
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static Arbol testArbol;
    
    public static void main(String[] args) {
        
        
        testArbol = new Arbol();
        Nodo nodo1 = new Nodo("/");
        Nodo nodo2 = new Nodo("^");
        Nodo nodo3 = new Nodo("+");
        Nodo nodo4 = new Nodo("x");
        Nodo nodo5 = new Nodo("*");
        Nodo nodo6 = new Nodo("2");
        Nodo nodo7 = new Nodo("y");
        Nodo nodo8 = new Nodo("5");
        Nodo nodo9 = new Nodo("-");
        Nodo nodo10 = new Nodo("*");
        Nodo nodo11 = new Nodo("4");
        Nodo nodo12 = new Nodo("x");
        Nodo nodo13 = new Nodo("3");
        
        testArbol.AddNodo(nodo1, null);
        testArbol.AddNodo(nodo2, nodo1);
        testArbol.AddNodo(nodo3, nodo2);
        testArbol.AddNodo(nodo4, nodo3);
        testArbol.AddNodo(nodo5, nodo3);
        testArbol.AddNodo(nodo6, nodo5);
        testArbol.AddNodo(nodo7, nodo5);
        testArbol.AddNodo(nodo8, nodo2);
        testArbol.AddNodo(nodo9, nodo1);
        testArbol.AddNodo(nodo10, nodo9);
        testArbol.AddNodo(nodo11, nodo10);
        testArbol.AddNodo(nodo12, nodo10);
        testArbol.AddNodo(nodo13, nodo9);
        
        testArbol.printTree();
        
        launch(args);

    }

}
