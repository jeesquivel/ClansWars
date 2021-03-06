/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clanswars;

import Constructores.ArmasFactory;
import Constructores.MantenimientoArmas;
import Constructores.PersonajeFactory;
import Objetos.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author alexander
 */
public class FXMLDocumentController implements Initializable {
    MantenimientoArmas mantenimientoArmas=MantenimientoArmas.getInstance();




    @FXML
    private AnchorPane tabPane;

    @FXML
    private ComboBox EA_cmbSeleccionTipo;

    private String strHeroe, strArma;
    private Image imgHeroe;
    private Image imgArma;
    private boolean boolImgHeroe;
    private boolean boolImgArma;


    //segundo tab

    @FXML
    private ComboBox EA_cmbSeleccionArma;
    @FXML
    private ComboBox EA_cmbTipoArma;
    @FXML
    private ComboBox EA_cmbNivelArma;
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
    private TextField EA_edtApariencia;
    @FXML
    private TextField EA_edtNivelAparicion;
    @FXML
    private TextField EA_edtNivelMaximo;
    @FXML
    private ImageView EA_ImageViewArma;
    @FXML
    private Label EA_labelSeleccionarArma;
    @FXML
    private Label EA_labelQuienUsaArma;
    @FXML
    private Label EA_labelTipoArma;
    @FXML
    private Label EA_labelNivelArma;
    @FXML
    private TextField EA_edtPuedeUsar;
    @FXML
    private TextField EA_edtTipo;




    // tercer tab

    @FXML
    private Label EP_labelSeleccionarPersonaje;
    @FXML
    private Label EP_labelSeleccionarAccion;
    @FXML
    private Label EP_labelSeleccionarNivel;
    @FXML
    private Label EP_labelTipoPersonaje;
    @FXML
    private ImageView EP_ImageView;
    @FXML
    private TextField EP_edtNombre;
    @FXML
    private TextField EP_edtTipo;
    @FXML
    private TextField EP_edtVida;
    @FXML
    private TextField EP_edtNivel;
    @FXML
    private TextField EP_edtNivelMaximo;
    @FXML
    private TextField EP_edtNivelAparicion;
    @FXML
    private TextField EP_edtVelocidad;
    @FXML
    private TextField EP_edtCampos;
    @FXML
    private TextField EP_edtGolpes;
    @FXML
    private TextField EP_edtCosto;
    @FXML
    private TextField EP_edtApariencia;
    @FXML
    private ComboBox EP_cmbSeleccionarPersonaje;
    @FXML
    private ComboBox EP_cmbSeleccionarAccion;
    @FXML
    private ComboBox EP_cmbSeleccionarNivel;
    @FXML
    private ComboBox EP_cmbTipoPersonaje;

    // CUARTO TAB
    @FXML
    private ComboBox CG_cmbArma;
    @FXML
    private ComboBox CG_cmbHeroe;
    @FXML
    private ComboBox CG_cmbAccion;
    @FXML
    private ComboBox CG_cmbNivel;


    @FXML
    private ImageView CG_ImageViewHeroe;
    @FXML
    private ImageView CG_ImageViewArma;




    @FXML
    private void handleEA_comboBox(ActionEvent event){
        try{

        strArma= (String) EA_cmbSeleccionArma.getValue();
        Arma arma= mantenimientoArmas.getDatos().getArmas().get(strArma);
        EA_edtNombre.setText(arma.getNombre());
        EA_edtTipo.setText(arma.getTipo());
        EA_edtAlcance.setText(String.valueOf(arma.getAlcance()));
        EA_edtDanno.setText(String.valueOf(arma.getDanno()));
        EA_edtRango.setText(String.valueOf(arma.getRango()));
        EA_edtNivel.setText(String.valueOf(arma.getNivel()));
        EA_edtNivelMaximo.setText(String.valueOf(arma.getNivelMaximo()));
        EA_edtNivelAparicion.setText(String.valueOf(arma.getNivelAparicion()));
        EA_edtApariencia.setText(String.valueOf(arma.getApariencia()));

        EA_edtPuedeUsar.setText(arma.getPuedeUsar());
        EA_cmbNivelArma.getItems().removeAll();
        for (int i = (int) arma.getNivel(); i <arma.getNivelMaximo()+1 ; i++) {
            if (!EA_cmbNivelArma.getItems().contains(i)){
            EA_cmbNivelArma.getItems().add(i);}
        }
        EA_cmbNivelArma.getSelectionModel().select(0);

        Image imagen =  new Image(arma.getApariencia()+"Atacando"+1+".gif");
        EA_ImageViewArma.setImage(imagen);

        }catch (Exception e){
            mensajeErrorConsulta();
            limpiarPantallaEA();

        }
    }


    @FXML
    private void handleComboBoxNivelArma(ActionEvent event){
        try{
            String nivel = (String) EA_cmbNivelArma.getValue().toString();
            Arma arma= mantenimientoArmas.getDatos().getArmas().get(strArma);
            Image imagen =  new Image(arma.getApariencia()+"Atacando"+nivel+".gif");
            EA_ImageViewArma.setImage(imagen);
        }catch (Exception e){

        }

    }




/*
        METODOS DEL SEGUNDP TAB
 */

    @FXML
    private void handleBuscarUrl(ActionEvent event) throws MalformedURLException {
        String url;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscador de imagen");
        File file =fileChooser.showOpenDialog(tabPane.getScene().getWindow());
        if(file!=null) {
            url= String.valueOf(file.toURI().toURL());
            imgArma = new Image(url);
            EA_ImageViewArma.setImage(imgArma);
            EA_edtApariencia.setText(String.valueOf(file.toURI().toURL()));
        }
    }

    @FXML
    private void handleCrearNuevaArma(ActionEvent event){
        EA_labelSeleccionarArma.setVisible(false);
        EA_cmbSeleccionArma.setVisible(false);
        EA_cmbNivelArma.setVisible(false);
        EA_labelNivelArma.setVisible(false);
        EA_ImageViewArma.setImage(null);
        EA_cmbSeleccionTipo.setVisible(true);
        EA_labelQuienUsaArma.setVisible(true);
        EA_labelTipoArma.setVisible(true);
        EA_cmbTipoArma.setVisible(true);
        limpiarPantallaEA();
    }


    @FXML
    private void handleGuardarArma(ActionEvent event){
        try {


            String nombre = EA_edtNombre.getText();
            long alcance = Long.parseLong(EA_edtAlcance.getText());
            long danno = Long.parseLong(EA_edtDanno.getText());
            long rango = Long.parseLong(EA_edtRango.getText());
            long nivel = Long.parseLong(EA_edtNivel.getText());
            long nivelAparicion = Long.parseLong(EA_edtNivelAparicion.getText());
            long nivelMaximo = Long.parseLong(EA_edtNivelMaximo.getText());
            String apariencia = EA_edtApariencia.getText();
            String puedeUsar = EA_edtPuedeUsar.getText();
            String tipo = EA_edtTipo.getText();


            //agregar un patron de disenno creacional
            // se agrego el factory

            ArmasFactory armasFactory = new ArmasFactory();
            IArma arma = armasFactory.crearArma(nombre, tipo, alcance, danno, rango, nivel, nivelMaximo, nivelAparicion, apariencia, puedeUsar);


            mantenimientoArmas.editarArma((Arma) arma);

            actualizarComboBoxes();


            EA_cmbSeleccionArma.setVisible(true);
            EA_labelSeleccionarArma.setVisible(true);
            EA_cmbNivelArma.setVisible(true);
            EA_labelNivelArma.setVisible(true);

            EA_cmbSeleccionTipo.setVisible(false);
            EA_labelQuienUsaArma.setVisible(false);
            EA_labelTipoArma.setVisible(false);
            EA_cmbTipoArma.setVisible(false);

            limpiarPantallaEA();

            mensajeExito("Arma");



        }catch (Exception e){
                mensajeError();
        }



    }


    @FXML
    private void handleComboBoxTipo(ActionEvent event){
        EA_edtPuedeUsar.setText((String) EA_cmbSeleccionTipo.getValue());
    }

    @FXML
    private void handleComboBoxTipoArma(ActionEvent event){
        EA_edtTipo.setText((String) EA_cmbTipoArma.getValue());
    }





    @FXML
    private void handleCancelar(ActionEvent event){
        actualizarComboBoxes();

        EA_cmbSeleccionArma.setVisible(true);
        EA_labelSeleccionarArma.setVisible(true);
        EA_cmbNivelArma.setVisible(true);
        EA_labelNivelArma.setVisible(true);

        EA_labelTipoArma.setVisible(false);
        EA_cmbTipoArma.setVisible(false);
        EA_cmbSeleccionTipo.setVisible(false);
        EA_labelQuienUsaArma.setVisible(false);
        limpiarPantallaEA();
    }


    @FXML
    private void handleBorrarArma(ActionEvent event){
        try{
            mantenimientoArmas.borrarArma(EA_edtNombre.getText());
            limpiarPantallaEA();
            actualizarComboBoxes();
            mensajeBorrado("Arma");

        }catch (Exception e){
            mensajeError();
        }
    }





    private void limpiarPantallaEA(){
        EA_edtAlcance.clear();
        EA_edtDanno.clear();
        EA_edtTipo.clear();
        EA_edtNombre.clear();
        EA_edtApariencia.clear();
        EA_edtNivel.clear();
        EA_edtRango.clear();
        EA_edtNivelAparicion.clear();
        EA_edtNivelMaximo.clear();
        EA_ImageViewArma.setImage(null);
        EA_edtPuedeUsar.clear();
    }


/*
        METODOS DEL TERCER TAB
 */



    @FXML
    private void handleEP_comboBox(ActionEvent event){
        try {
            strHeroe = (String) EP_cmbSeleccionarPersonaje.getValue();
            Personaje personaje = (Personaje) mantenimientoArmas.getDatos().getPersonajes().get(strHeroe);
            EP_edtNombre.setText(personaje.getNombre());
            EP_edtTipo.setText(personaje.getTipo());
            EP_edtVelocidad.setText(String.valueOf(personaje.getVelocidad()));
            EP_edtVida.setText(String.valueOf(personaje.getVida()));
            EP_edtNivel.setText(String.valueOf(personaje.getNivel()));
            EP_edtNivelAparicion.setText(String.valueOf(personaje.getNivelAparicion()));
            EP_edtCosto.setText(String.valueOf(personaje.getCosto()));
            EP_edtApariencia.setText(personaje.getApariencia());
            EP_edtCampos.setText(String.valueOf(personaje.getCampos()));
            EP_edtGolpes.setText(String.valueOf(personaje.getGolpesSegundo()));
            EP_edtNivelMaximo.setText(String.valueOf(personaje.getNivelMaximo()));
            Image imagen = new Image(personaje.getApariencia() + EP_cmbSeleccionarAccion.getValue() + EP_cmbSeleccionarNivel.getValue() + ".gif");
            EP_ImageView.setImage(imagen);
            EP_ImageView.setRotate(180);
        }catch (Exception e){
            mensajeErrorConsulta();
            limpiarPantallaEP();

        }
    }

    @FXML
    private void handleGuardarPersonaje(ActionEvent event){
        try {

            String nombre = EP_edtNombre.getText();
            String tipo = EP_edtTipo.getText();
            long velocidad = Long.parseLong(EP_edtVelocidad.getText());
            long vida = Long.parseLong(EP_edtVida.getText());
            long nivel = Long.parseLong(EP_edtNivel.getText());
            long nivelAparicion = Long.parseLong(EP_edtNivelAparicion.getText());
            long costo = Long.parseLong(EP_edtCosto.getText());
            String apariencia = EP_edtApariencia.getText();
            long campos = Long.parseLong(EP_edtCampos.getText());
            long golpes = Long.parseLong(EP_edtGolpes.getText());
            long nivelMaximo = Long.parseLong(EP_edtNivelMaximo.getText());


            PersonajeFactory personajeFactory = new PersonajeFactory();


            Personaje personaje = personajeFactory.crearPersonaje(tipo, nombre, vida, nivel, nivelMaximo, AbstractObjeto.ESTADO.ESPERANDO,
                    nivelAparicion, costo, apariencia, golpes, campos, velocidad);

            mantenimientoArmas.editarPersonaje(personaje);
            actualizarComboBoxes();

            EP_labelSeleccionarAccion.setVisible(true);
            EP_labelSeleccionarPersonaje.setVisible(true);
            EP_labelSeleccionarNivel.setVisible(true);
            EP_cmbSeleccionarNivel.setVisible(true);
            EP_cmbSeleccionarAccion.setVisible(true);
            EP_cmbSeleccionarPersonaje.setVisible(true);

            EP_labelTipoPersonaje.setVisible(false);
            EP_cmbTipoPersonaje.setVisible(false);


            mensajeExito("Personaje");
        }catch (Exception e){
            mensajeError();
        }


    }




    @FXML
    private void handleBuscarUrlPersonaje(ActionEvent event) throws MalformedURLException {
        String url;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscador de imagen");
        File file =fileChooser.showOpenDialog(tabPane.getScene().getWindow());
        if(file!=null) {
            url= String.valueOf(file.toURI().toURL());
            imgArma = new Image(url);
            EP_ImageView.setImage(imgArma);
            EP_edtApariencia.setText(String.valueOf(file.toURI().toURL()));
        }
    }



    @FXML
    private  void handleEP_crearPersonaje(ActionEvent event){
        limpiarPantallaEP();
        EP_labelSeleccionarAccion.setVisible(false);
        EP_labelSeleccionarPersonaje.setVisible(false);
        EP_labelSeleccionarNivel.setVisible(false);
        EP_cmbSeleccionarNivel.setVisible(false);
        EP_cmbSeleccionarAccion.setVisible(false);
        EP_cmbSeleccionarPersonaje.setVisible(false);

        EP_labelTipoPersonaje.setVisible(true);
        EP_cmbTipoPersonaje.setVisible(true);
    }



    @FXML
    private void hanldeCancelarCreacionPersonaje(ActionEvent  event){
        actualizarComboBoxes();
        EP_labelSeleccionarAccion.setVisible(true);
        EP_labelSeleccionarPersonaje.setVisible(true);
        EP_labelSeleccionarNivel.setVisible(true);
        EP_cmbSeleccionarNivel.setVisible(true);
        EP_cmbSeleccionarAccion.setVisible(true);
        EP_cmbSeleccionarPersonaje.setVisible(true);

        EP_labelTipoPersonaje.setVisible(false);
        EP_cmbTipoPersonaje.setVisible(false);
        limpiarPantallaEP();
    }

    @FXML
    private void handleComboBoxTipoPersonaje(ActionEvent event){
        String tipo= (String) EP_cmbTipoPersonaje.getValue();
        EP_edtTipo.setText(tipo);
    }

    @FXML
    private void handleBorrarPersonaje(ActionEvent event){
        try{
            mantenimientoArmas.borrarPersonaje(EP_edtNombre.getText());
            limpiarPantallaEP();
            mensajeBorrado("Personaje");

        }catch (Exception e){
            mensajeError();
        }
    }




    private void limpiarPantallaEP(){
        EP_edtNivelMaximo.clear();
        EP_edtNombre.clear();
        EP_edtNivel.clear();
        EP_edtCosto.clear();
        EP_edtVelocidad.clear();
        EP_edtVida.clear();
        EP_edtNivelAparicion.clear();
        EP_edtApariencia.clear();
        EP_edtCampos.clear();
        EP_edtGolpes.clear();
        EP_ImageView.setImage(null);
    }


    /*
    METODOS DEL CUARTO TAB
     */



    @FXML
    private void handleCP_comboBoxesActivity(ActionEvent even){
        String nombrePersonaje= (String) CG_cmbHeroe.getValue();
        String nombreArma= (String) CG_cmbArma.getValue();
        String nivel= String.valueOf(CG_cmbNivel.getValue());
        String accion = (String) CG_cmbAccion.getValue();
        LoadSetImages(nombrePersonaje,nombreArma,nivel,accion);
    }


    @FXML
    private void handleGuardarGuerrero(ActionEvent event){
        IPrototype p= mantenimientoArmas.getPersonajes().get(CG_cmbHeroe.getValue());
        Arma arma= mantenimientoArmas.getDatos().getArmas().get(CG_cmbArma.getValue());



    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarPantallas();

    }
    
    private void loadHeroeImage(String name, String nivel,String accion){
        boolImgHeroe = false;
        Personaje p= (Personaje) mantenimientoArmas.getPersonajes().get(name);
        imgHeroe = new Image(p.getApariencia()+nivel +  accion+".gif");

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
    
    private void loadArmaImage(String nameArma,String nivel, String accion){
        boolImgArma = false;
        Arma a= mantenimientoArmas.getDatos().getArmas().get(nameArma);
        
        imgArma = new Image(a.getApariencia()+nivel+accion+".gif");
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
    
    private void loadImages(String  p, String  a,String nivel,String accion){
        loadHeroeImage(p,accion,nivel);
        loadArmaImage(a,accion,nivel);
    }
    
    private void setImages(){
        if (boolImgArma && boolImgHeroe){ // Sólo si las dos imágenes ya están cargadas
            CG_ImageViewHeroe.setImage(imgHeroe);
            CG_ImageViewArma.setRotate(180);
            CG_ImageViewArma.setImage(imgArma);
            CG_ImageViewHeroe.setRotate(180);
        }
    }
    
    private void LoadSetImages(String p,String a,String nivel,String accion){
        loadImages(p,a,nivel,accion);
        setImages();
    }



    // metodo futuro para cargar
    public void cargarPantallas(){


        for (String i:mantenimientoArmas.getDatos().getEstados()) {
            EP_cmbSeleccionarAccion.getItems().add(i);
            CG_cmbAccion.getItems().add(i);

        }

        for (String i:mantenimientoArmas.getDatos().getPersonajes().keySet()) {
            EP_cmbSeleccionarPersonaje.getItems().add(i);
            CG_cmbHeroe.getItems().add(i);

        }


        for (String i:mantenimientoArmas.getDatos().getArmas().keySet()) {
            EA_cmbSeleccionArma.getItems().add(i);
            CG_cmbArma.getItems().add(i);
        }

        for (String i: mantenimientoArmas.getDatos().getTiposPersonajes()
             ) {
            EA_cmbSeleccionTipo.getItems().add(i);

        }


        for (String i: mantenimientoArmas.getDatos().getTiposArmas()
        ) {
            EA_cmbTipoArma.getItems().add(i);

        }


        for (String i: mantenimientoArmas.getDatos().getTiposPersonajes()
        ) {
            EP_cmbTipoPersonaje.getItems().add(i);

        }


        EA_cmbSeleccionTipo.getSelectionModel().select(1);
        EA_cmbTipoArma.getSelectionModel().select(0);
        EA_cmbSeleccionTipo.setVisible(false);
        EA_cmbTipoArma.setVisible(false);
        EA_labelQuienUsaArma.setVisible(false);
        EA_labelTipoArma.setVisible(false);



        EA_cmbSeleccionArma.getSelectionModel().select(0);
        EP_cmbTipoPersonaje.getSelectionModel().select(0);
        EP_cmbSeleccionarPersonaje.getSelectionModel().select(0);
        EP_cmbTipoPersonaje.setVisible(false);
        EP_labelTipoPersonaje.setVisible(false);
        EP_cmbSeleccionarAccion.getSelectionModel().select(0);
        EP_cmbTipoPersonaje.getSelectionModel().select(0);
        CG_cmbHeroe.getSelectionModel().select(0);
        CG_cmbAccion.getSelectionModel().select(0);
        CG_cmbArma.getSelectionModel().select(0);


        Personaje p= (Personaje) mantenimientoArmas.getPersonajes().get(EP_cmbSeleccionarPersonaje.getValue());


        for (int i = 1; i < p.getNivelMaximo()+1; i++) {
            EP_cmbSeleccionarNivel.getItems().add(i);
            CG_cmbNivel.getItems().add(i);
        }

        EP_cmbSeleccionarNivel.getSelectionModel().select(0);


        EA_cmbSeleccionArma.setVisible(true);
        EA_labelSeleccionarArma.setVisible(true);


    }


    //metodo para borrar las varas de las pantalla de editar arma

    public void  actualizarComboBoxes( ){

        for (String i: mantenimientoArmas.getDatos().getArmas().keySet()){
            if (!EA_cmbSeleccionArma.getItems().contains(i)){
                EA_cmbSeleccionArma.getItems().add(i);
                CG_cmbArma.getItems().add(i);
            }
        }
        for (String i: mantenimientoArmas.getDatos().getPersonajes().keySet()){
            if (!EP_cmbSeleccionarPersonaje.getItems().contains(i)){
                EP_cmbSeleccionarPersonaje.getItems().add(i);
                CG_cmbHeroe.getItems().add(i);
            }
        }
    }


    // venatanas emergentes

    public void mensajeExito(String tipo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Ha creado/editado un "+ tipo+" satisfactoriamente!");

        alert.showAndWait();
    }


    public void mensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Ha ocurrido algún error");
        alert.showAndWait();
    }


    public void mensajeErrorConsulta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No existe el elemento aconsultar");
        alert.showAndWait();
    }


    public void mensajeBorrado(String tipo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Ha borrado un "+ tipo+" satisfactoriamente!");

        alert.showAndWait();
    }




}