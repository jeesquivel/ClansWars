/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author alexander
 */
public class Personaje extends AbstractObjeto implements IMovible, Cloneable{
    public enum TIPO {TERRESTRE, AEREO}
    
    protected double golpesSegundo;         // Cantidad de veces que el guerrero ataca por segundo
    protected int campos;                   // Campos que necesita el guerrero
    protected int velocidad;                // Velocidad en que se mueve el guerrero
    
    
    protected AbstractObjeto objetivo;      // El objetivo actual del guerrero
    protected IArma armaFavorita;           // El arma favorita de este guerrero por la que obtiene un porcentaje mayor de daño
    
    private ArrayList<AbstractObjeto> enemigos;

    public Personaje(String nombre, int vida, int nivel, ESTADO estado, int nivelAparicion, int costo, ArrayList<String> apariencia, Point posicion, double golpesSegundo, int campos, int velocidad) {
        super(nombre, vida, nivel, estado, nivelAparicion, costo, apariencia, posicion);
        this.golpesSegundo = golpesSegundo;
        this.campos        = campos;
        this.velocidad     = velocidad;
        this.objetivo      = null;
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
    
    
}
