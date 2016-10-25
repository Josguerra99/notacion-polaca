/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Arbol.Arbol;
import com.jfoenix.controls.JFXRippler;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Jose Guerra
 */
public class Arbol_UI_Controller {

    static final Color PRIMARY_COLOR = Color.web("#009688");
    static final Color SECUNDARY_COLOR = Color.web("#546d78");
    static final Color FOREGROUND = Color.web("#455A64");

    private static ArrayList<Object> drawedComponents = new ArrayList<>();/*Lista que guarda los objetos que se dibujan para removerlos despues*/
    private static ArrayList<Vector2> positions = new ArrayList<>();/*Lista de las posiciones*/


    public static void drawTree(Pane canvas, Arbol arbol) {/*Dibuja el arbol*/
         /*Elimina el arbol anterior*/
        while (!drawedComponents.isEmpty()) {            
         clearCanvas(canvas);
            
        }
        
        
        int radius = 25;
        int lineWidth = 5;

        double totalWidth = canvas.getWidth() * 0.9 / 2;/*El ancho total del arbol (75% del tamaño del panel)*/
        double totalHeight = canvas.getHeight() * 0.8;/*Separacion de la altura del arbol*/
        int totalSpaces = (int) Math.pow(2, arbol.getMaxLvl()) / 2 - 1;/*Numero de espacios que habra entre cada nodo*/
        int totalColumns = (int) Math.pow(2, arbol.getMaxLvl()) / 2 + totalSpaces;/*El numero de columnas totales*/
        double totalColumnSize = totalWidth / totalColumns;/*El tamaño de una sola columna*/
        double height = totalHeight / arbol.getMaxLvl();
        /*Iteramos por los nodos para asignarle la posicion en el plano*/
        arbol.getNodos().stream().forEach((nodo) -> {

            /*Calculamos la posicion*/
            Vector2 pos = new Vector2(0, 0);

            /*Calculamos la anchura*/
            int levelSpaces = (int) Math.pow(2, nodo.getNivel()) / 2 - 1;/*Numero de espacios que habra entre cada nodo*/
            int levelColumns = (int) Math.pow(2, nodo.getNivel()) / 2 + levelSpaces;/*El numero de columnas totales*/

            int usedColums = totalColumns - ((int) Math.pow(2, arbol.getMaxLvl() - nodo.getNivel()) - 1);/*El numero de columas que abarca*/
            double levelWidth = usedColums * totalColumnSize;/*El ancho total del nivel*/
            double levelColumnsSize = levelWidth / levelColumns;
            int columsToNode = impar(nodo.getNumFromCenter() - 1);/*En que columna deberiamos posicionar al nodo*/


            levelColumnsSize *= nodo.getPosRelativeToRoot() == 1 ? -1 : 1;

            pos.x = canvas.getWidth() / 2 - levelColumnsSize * columsToNode;
            /*Calculamos la altura*/
            double levelHeight = nodo.getNivel() * height;/*La altura del nivel actual*/
            pos.y = levelHeight + (canvas.getHeight() - totalHeight) / 2;

            nodo.setPanelPosition(pos);

            //System.out.println(nodo.getTag() + " [" + pos.x + "," + pos.y + "]  "+nodo.getNivel()+" "+ impar(3));
        });

        /*Primero dibujamos las lineas*/
        arbol.getNodos().stream().filter((nodo) -> (nodo.getParent() != null)).forEach((nodo) -> {
            drawLine(canvas, nodo.getParent().getPanelPosition(), nodo.getPanelPosition(), lineWidth);
        });
        /*Luego dibujamos los circulos*/
        arbol.getNodos().stream().forEach((nodo) -> {
            drawCircle(canvas, nodo.getPanelPosition(), radius, nodo.getTag());
        });

    }

    private static void drawCircle(Pane canvas, Vector2 pos, int radius, String tag) {
        Circle circle = new Circle();
        circle.setCenterX(pos.x);/*La posicion en x del circulo*/
        circle.setCenterY(pos.y);/*La posicion en y del circulo*/
        circle.setRadius(radius);/*El radio del circulo*/
        circle.setFill(PRIMARY_COLOR);/*Color del circulo*/
        canvas.getChildren().add(circle);/*Agregamos el circulo al panel*/
        drawedComponents.add(circle);/*Agregamos este objeto a la lista de objetos dibujados*/
        drawText(canvas, pos, tag);/*Y agregamos texto al circulo*/

    }

    private static void drawLine(Pane canvas, Vector2 start, Vector2 end, int width) {
        Line line = new Line(start.x, start.y, end.x, end.y);/*Creamos la linea*/
        line.setStrokeWidth(width);/*Agregamos el ancho a la linea*/
        line.setStroke(SECUNDARY_COLOR);/*Agregamos el color*/
        canvas.getChildren().add(line);/*Agregamos la linea al panel*/
        drawedComponents.add(line);/*Agregamos la line a la lista*/
    }

    private static void drawText(Pane canvas, Vector2 pos, String tag) {
        /*Creamos el texto ponemos la posicion en x y en y y agregamos el texto*/
        Text text = new Text(pos.x - 25, pos.y + 12.5, tag);/*La posicion en x le restamos 25 ya que ponemos el ancho predefinido como 50 y para centrarlo restamos 25, lo mismo con la altura*/
        text.setFont(new Font("Roboto Regular", 40));
        text.setFill(FOREGROUND);/*Agregamos el color del texto*/
        text.setWrappingWidth(50);/*Agregamos el ancho mencionado anteriormente*/
        text.setTextAlignment(TextAlignment.CENTER);
        text.minHeight(50);
        drawedComponents.add(text);/*Agregamos el texto a la lista*/
        canvas.getChildren().add(text);/*Lo añadimos al panel*/
    }

    /*Elimina todos los objetos dibujados del canvas*/
    private static void clearCanvas(Pane canvas) {

        /*Recorremos la lista de los componentes que dibujamos*/
        for (int i = 0; i < drawedComponents.size(); i++) {
            canvas.getChildren().remove((Node) drawedComponents.get(i));/*Removemos el objeto del panel*/
            drawedComponents.remove(i);/*Removemos el objeto de la lista*/
        }

    }

    private static int impar(int pos) {
        if (pos < 0) {
            return 0;
        }

        int num = -1;
        for (int i = 0; i <= pos; i++) {
            num += 2;
        }
        return num;
    }

}
