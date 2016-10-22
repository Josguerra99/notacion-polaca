/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXRippler;
import controladores.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Jose Guerra
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;   
    
    @FXML
    private Button treeBtn;
    
    @FXML
    private Pane treePane;
    
    
    @FXML
    private Pane rootPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        
        treeBtn.setOnAction((ActionEvent event) -> {
            Controller.drawTree(treePane,Proyecto.testArbol);
        });

        
        
    }    

    
    
}
