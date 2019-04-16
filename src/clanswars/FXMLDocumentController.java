/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clanswars;

import java.awt.*;
import java.lang.reflect.Array;
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
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 *
 * @author alexander
 */
public class FXMLDocumentController implements Initializable {
    MantenimientoArmas mantenimientoArmas=MantenimientoArmas.getInstance();


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


    //segundo tab
    @FXML
    private ComboBox EA_comboBox;
    @FXML
    private TextField EA_edtNombre;
    @FXML
    private TextField EA_edtAlcance;
    @FXML
    private TextField EA_edtDanno;
    @FXML
    private TextField EA_edtRango;
    @FXML
    private TextField EA_edtNivel;
    @FXML
    private TextField EA_edtNivelAparicion;
    @FXML
    private TextField EA_edtApariencia;
    @FXML
    private ImageView ED_ImageViewArma;





    
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


    @FXML
    private void handleEA_comboBox(ActionEvent event){
        strArma= (String) EA_comboBox.getValue();
        Arma arma= mantenimientoArmas.getDatos().getArmasHash().get(strArma);
        EA_edtNombre.setText(arma.getNombre());
        EA_edtAlcance.setText(String.valueOf(arma.getAlcance()));
        EA_edtDanno.setText(String.valueOf(arma.getDanno()));
        EA_edtRango.setText(String.valueOf(arma.getRango()));
        EA_edtNivel.setText(String.valueOf(arma.getNivel()));
        EA_edtNivelAparicion.setText(String.valueOf(arma.getNivelAparicion()));
        EA_edtApariencia.setText(String.valueOf(arma.getApariencia()));
        Image imagen =  new Image("/images/Armas/" + strArma + "/" + "Atacando"+arma.getNivel() +".gif");
        ED_ImageViewArma.setImage(imagen);
    }


    @FXML
    private void handleGuardar(ActionEvent event){
        String nombre= EA_edtNombre.getText();
        long alcance= Long.parseLong(EA_edtAlcance.getText());
        long danno= Long.parseLong(EA_edtDanno.getText());
        long rango= Long.parseLong(EA_edtRango.getText());
        long nivel= Long.parseLong(EA_edtNivel.getText());
        long nivelParicion = Long.parseLong(EA_edtNivelAparicion.getText());
        String apariencia= EA_edtApariencia.getText();

        Arma arma= new Arma(nombre,alcance,danno,rango,nivel,nivelParicion,apariencia);

        mantenimientoArmas.editarArma(arma);
        cargarPantallas();

        }







    @Override
    public void initialize(URL url, ResourceBundle rb) {


        cmbHeroeNivel.setItems(FXCollections.observableArrayList(
                                    "1",
                                    "2",
                                    "3",
                                    "4",
                                    "5"
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










        cargarPantallas();



        

/*


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
    
    private void loadImages(){
        loadHeroeImage();
        loadArmaImage();
    }
    
    private void setImages(){
        if (boolImgArma && boolImgHeroe){ // Sólo si las dos imágenes ya están cargadas
            imgHeroe1.setImage(imgHeroe);
            imgArma1.setImage(imgArma);
        }
    }
    
    private void LoadSetImages(){
        loadImages();
        setImages();
    }



    // metodo futuro para cargar
    public void cargarPantallas(){

        for (String i:mantenimientoArmas.getDatos().getArmasHash().keySet()) {
            cmbArma.getItems().add(i);
            EA_comboBox.getItems().add(i);
        }
        EA_comboBox.getSelectionModel().select(0);
        cmbArma.getSelectionModel().select(0);



        for (IPrototype i:mantenimientoArmas.getPersonajes()) {
            cmbHeroe.getItems().add(((Personaje) i).getNombre());
        }

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

    }


    //metodo para borrar las varas de las pantalla de editar arma

    public void  borrarPantallaEditarArma(){


    }



    public void cargarCmbArmas() {

    }


}