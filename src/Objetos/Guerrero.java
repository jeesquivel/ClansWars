/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexander
 */
public class Guerrero extends AbstractObjeto implements IMovible, IAtacador, Runnable{
    public enum TIPO {TERRESTRE, AEREO}
    
    protected double golpesSegundo;         // Cantidad de veces que el guerrero ataca por segundo
    protected int campos;                   // Campos que necesita el guerrero
    protected int velocidad;                // Velocidad en que se mueve el guerrero
    protected IArma arma;                   // El arma asignada al guerrero
    protected TIPO tipo;                    // El tipo de guerrero
    protected AbstractObjeto objetivo;      // El objetivo actual del guerrero
    protected IArma armaFavorita;           // El arma favorita de este guerrero por la que obtiene un porcentaje mayor de daño
    
    private ArrayList<AbstractObjeto> enemigos;

    public Guerrero(String nombre, int vida, int nivel, ESTADO estado, int nivelAparicion, int costo, ArrayList<String> apariencia, Point posicion, double golpesSegundo, int campos, int velocidad, IArma arma, TIPO tipo, AbstractObjeto objetivo) {
        super(nombre, vida, nivel, estado, nivelAparicion, costo, apariencia, posicion);
        this.golpesSegundo = golpesSegundo;
        this.campos        = campos;
        this.velocidad     = velocidad;
        this.arma          = arma;
        this.tipo          = tipo;
        this.objetivo      = objetivo;
    }
    
    public void atacado(int danno){
        this.vida -= danno;
        if (this.vida <= 0)
            this.estado = ESTADO.MUERTO;
    }

    public double getGolpesSegundo() {
        return golpesSegundo;
    }

    public void setGolpesSegundo(double golpesSegundo) {
        this.golpesSegundo = golpesSegundo;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public IArma getArma() {
        return arma;
    }

    public void setArma(IArma arma) {
        this.arma = arma;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public AbstractObjeto getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(AbstractObjeto objetivo) {
        this.objetivo = objetivo;
    }

    public IArma getArmaFavorita() {
        return armaFavorita;
    }

    public void setArmaFavorita(IArma armaFavorita) {
        this.armaFavorita = armaFavorita;
    }

    public ArrayList<AbstractObjeto> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<AbstractObjeto> enemigos) {
        this.enemigos = enemigos;
    }
    
    /*
    Mueve el guerrero en la dirección hacia donde se encuentra el objetivo actual
    */
    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    El guerrero primero pregunta si hay un objetivo asignado y si el objetivo está vivo,
    de ser así si el objetivo está al alcance de su arma entonces lo ataca sino se mueve hacia él,
    si el objetivo no está vivo o no hay objetivo entonces se busca un objetivo.
    */
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Busca el objetivo que se encuentre más cercano, ¿ponemos objetivos favoritos?
    */
    @Override
    public AbstractObjeto buscarObjetivo(ArrayList<AbstractObjeto> enemigos) {
        AbstractObjeto mejorObjetivo = null;
        for(AbstractObjeto enemigo: enemigos){
            if (enemigo != null && ((Guerrero)enemigo).estado != ESTADO.MUERTO){
                if (mejorObjetivo == null)
                    mejorObjetivo = enemigo;
                else if (distancia2(this.posicion, enemigo.posicion) < distancia2(this.posicion, mejorObjetivo.posicion))
                    mejorObjetivo = enemigo;
            }
        }
        return mejorObjetivo;
    }
    
    /*
    Calcula la distancia al cuadrado entre dos puntos dados
    */
    private double distancia2(Point punto1, Point punto2){
        return Math.pow(punto2.x - punto1.x, 2) + Math.pow(punto2.y - punto1.y, 2);
    }
    
    @Override
    public void run() {
        while(this.estado != ESTADO.MUERTO){
            try {
                if (this.objetivo == null || ((Guerrero)this.objetivo).estado == ESTADO.MUERTO){
                    this.objetivo = buscarObjetivo(enemigos);
                }else if (distancia2(this.objetivo.posicion,this.posicion) <= Math.pow(((Arma)this.arma).alcance,2)){
                    atacar();
                    sleep((int)(1000/this.golpesSegundo));
                }else{
                    mover();
                    sleep((int)(1000/this.velocidad));
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
