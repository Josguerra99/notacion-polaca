/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Arbol.CrearArbol;
import com.jfoenix.controls.JFXRippler;
import controladores.Arbol_UI_Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import notacion_polaca.ConvertidorInfijoAPrefijo;

/**
 *
 * @author Jose Guerra
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    
    
    @FXML
    private Label resultLbl;

    @FXML
    private Button treeBtn;

    @FXML
    private TextField arithmeticTxt;
    @FXML
    private Pane treePane;

    @FXML
    private Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        arithmeticTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            ConvertidorInfijoAPrefijo aPrefijo = new ConvertidorInfijoAPrefijo();
            aPrefijo.convertidorInfijoAPrefijo(new StringBuffer(newValue));
            resultLbl.setText(aPrefijo.prefijo.toString());
            

        });

        treeBtn.setOnAction((ActionEvent event) -> {
            Arbol_UI_Controller.drawTree(treePane, CrearArbol.getArbol(resultLbl.getText()));
            
        });

    }

}
