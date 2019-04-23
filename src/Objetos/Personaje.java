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
public class Personaje extends AbstractObjeto implements IMovible, IPrototype<Personaje>{

    public enum TIPO {TERRESTRE, AEREO}

    protected long golpesSegundo;         // Cantidad de veces que el guerrero ataca por segundo
    protected long campos;                   // Campos que necesita el guerrero
    protected long velocidad;                // Velocidad en que se mueve el guerrero
    
    
    protected AbstractObjeto objetivo;      // El objetivo actual del guerrero
    protected IArma armaFavorita;           // El arma favorita de este guerrero por la que obtiene un porcentaje mayor de daño
    
    private ArrayList<AbstractObjeto> enemigos;

    public Personaje(String nombre, long vida, long nivel, long nivelMaximo, ESTADO estado, long nivelAparicion, long costo, String apariencia, long golpesSegundo, long campos, long velocidad) {
        super(nombre, vida, nivel, nivelMaximo, estado, nivelAparicion, costo, apariencia);
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

    public void setGolpesSegundo(long golpesSegundo) {
        this.golpesSegundo = golpesSegundo;
    }

    public long getCampos() {
        return campos;
    }

    public void setCampos(long campos) {
        this.campos = campos;
    }

    public long getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(long velocidad) {
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

    @Override
    public String toString() {
        return super.toString() + "Personaje{" + "golpesSegundo=" + golpesSegundo + ", campos=" + campos + ", velocidad=" + velocidad + ", objetivo=" + objetivo + ", armaFavorita=" + armaFavorita + ", enemigos=" + enemigos + '}';
    }
    
    @Override
    public Personaje clonar() throws CloneNotSupportedException {
       return new Personaje(nombre, vida, nivel, nivelMaximo, estado, nivelAparicion, costo, apariencia, golpesSegundo, campos, velocidad);
    }

    @Override
    public Personaje deepclonar() throws CloneNotSupportedException {
        return new Personaje(nombre, vida, nivel, nivelMaximo, estado, nivelAparicion, costo, apariencia,  golpesSegundo, campos, velocidad);
    }
    
}
