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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 *
 * @author alexander
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView imgHeroe1;
    @FXML
    private ImageView imgArma1;
    @FXML
    private ComboBox cmbHeroe;
    @FXML
    private ComboBox cmbHeroeNivel;
    @FXML
    private ComboBox cmbArma;
    @FXML
    private ComboBox cmbArmaNivel;
    @FXML
    private ComboBox cmbAccion;
    
    private String strHeroe, strArma, strHeroeNivel, strArmaNivel, strAccion;
    private Image imgHeroe;
    private Image imgArma;
    private boolean boolImgHeroe;
    private boolean boolImgArma;
    
    @FXML
    private void handlebtnRotar(ActionEvent event) {
        imgHeroe1.setRotate(imgHeroe1.getRotate() + 5);
        imgArma1.setRotate(imgArma1.getRotate() + 5);
    }
    
    @FXML
    private void handlecmbHeroe(ActionEvent event) {
        strHeroe = (String)cmbHeroe.getValue();
        LoadSetImages();
    }
    
    @FXML
    private void handlecmbHeroeNivel(ActionEvent event) {
        strHeroeNivel = (String)cmbHeroeNivel.getValue();
        LoadSetImages();
    }
    
    @FXML
    private void handlecmbArma(ActionEvent event) {
        strArma = (String)cmbArma.getValue();
        LoadSetImages();
    }
    
    @FXML
    private void handlecmbArmaNivel(ActionEvent event) {
        strArmaNivel = (String)cmbArmaNivel.getValue();
        LoadSetImages();
    }
    
    @FXML
    private void handlecmbAccion(ActionEvent event) {
        strAccion = (String)cmbAccion.getValue();
        LoadSetImages();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cmbHeroe.setItems(FXCollections.observableArrayList(
                                    "Arquera",
                                    "Barbaro",
                                    "Enfermera",
                                    "Mago",
                                    "Soldado"
                                ));
        cmbHeroeNivel.setItems(FXCollections.observableArrayList(
                                    "1",
                                    "2",
                                    "3",
                                    "4",
                                    "5"
                                ));
        
        cmbArma.setItems(FXCollections.observableArrayList(
                                    "Manos",
                                    "Espada",
                                    "Mazo",
                                    "Arco",
                                    "Jeringa",
                                    "Hechizo"
                                ));
        cmbArmaNivel.setItems(FXCollections.observableArrayList(
                                    "1",
                                    "2",
                                    "3",
                                    "4",
                                    "5"
                                ));
        cmbAccion.setItems(FXCollections.observableArrayList(
                                    "Atacando",
                                    "Caminando",
                                    "Detenido",
                                    "Muerto"
                                ));
        
        cmbHeroe.getSelectionModel().select(0);
        cmbHeroeNivel.getSelectionModel().select(0);
        cmbArma.getSelectionModel().select(0);
        cmbArmaNivel.getSelectionModel().select(0);
        cmbAccion.getSelectionModel().select(0);
        
        strHeroe = (String)cmbHeroe.getValue();
        strHeroeNivel = (String)cmbHeroeNivel.getValue();
        strArma = (String)cmbArma.getValue();
        strArmaNivel = (String)cmbArmaNivel.getValue();
        strAccion = (String)cmbAccion.getValue();
        
        LoadSetImages();
        
        /*MantenimientoArmas mantenimientoArmas= MantenimientoArmas.getInstance();


        ArrayList<IArma> armeria = (ArrayList<IArma>) mantenimientoArmas.cargarTodo();

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
        }*/





    }
    
    private void loadHeroeImage(){
        boolImgHeroe = false;
        
        imgHeroe = new Image("/images/Heroes/" + strHeroe + "/" + strAccion + strHeroeNivel + ".gif");
        System.out.println("/images/Heroes/" + strHeroe + "/" + strAccion + strHeroeNivel + ".gif");

        if (imgHeroe.getProgress() != 1){ // Si la imagen no se ha cargado espera hasta que se cargue
            imgHeroe.progressProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                if ((double)newValue == 1) {
                    boolImgHeroe = true;
                    setImages();
                }
            });
        }else
            boolImgHeroe = true;
          
    }
    
    private void loadArmaImage(){
        boolImgArma = false;
        
        imgArma = new Image("/images/Armas/" + strArma + "/" + strAccion + strArmaNivel + ".gif");
        
        if (imgArma.getProgress() != 1){ // Si la imagen no se ha cargado espera hasta que se cargue
            imgArma.progressProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                if ((double)newValue == 1) {
                    boolImgArma = true;
                    setImages();
                }
            });
        }else
            boolImgArma = true;
        
    }
    
    private void setHeroeImage(){
        imgHeroe1.setImage(imgHeroe);
    }
    
    private void setArmaImage(){
        imgArma1.setImage(imgArma);
    }
    
    private void loadImages(){
        loadHeroeImage();
        loadArmaImage();
    }
    
    private void setImages(){
        if (boolImgArma && boolImgHeroe){ // Sólo si las dos imágenes ya están cargadas
            setHeroeImage();
            setArmaImage();
        }
    }
    
    private void LoadSetImages(){
        loadImages();
        setImages();
    }

}