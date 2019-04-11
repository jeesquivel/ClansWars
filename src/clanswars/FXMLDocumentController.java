/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clanswars;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Constructores.MantenimientoArmas;
import Objetos.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author alexander
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        MantenimientoArmas mantenimientoArmas= MantenimientoArmas.getMantenimientoArmas();


        ArrayList<IArma> armeria = mantenimientoArmas.getArmeria();

        for (IArma i:armeria) {
            System.out.println(i.toString());

        }




        Guerrero guerrero = new Guerrero(new Personaje("Arquera",500,1, AbstractObjeto.ESTADO.ESPERANDO,1,100,new ArrayList<>(),new Point(5,1), 0.5, 1, 100), new Arma("MataTodo", 5, 100, 0, 1, 1, ""));
        Guerrero guerrero2 = null;
        try {
            guerrero2 = (Guerrero)guerrero.deepclonar();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

        if (guerrero2 != null){

            System.out.println(guerrero.toString());
            System.out.println(guerrero2.toString());

            guerrero2.getPersonaje().setCosto(0);
            guerrero2.getPersonaje().setPosicion(new Point(1,10));

            System.out.println(guerrero.toString());
            System.out.println(guerrero2.toString());
        }





    }
}



