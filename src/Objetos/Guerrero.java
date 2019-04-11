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
public class Guerrero implements IAtacador, Runnable, IPrototype<Guerrero>{
    Personaje personaje;
    IArma arma;
    
    public Guerrero(Personaje personaje, IArma arma){
        this.personaje = personaje;
        this.arma = arma;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public IArma getArma() {
        return arma;
    }

    public void setArma(IArma arma) {
        this.arma = arma;
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
            if (enemigo != null && ((Personaje)enemigo).estado != AbstractObjeto.ESTADO.MUERTO){
                if (mejorObjetivo == null)
                    mejorObjetivo = enemigo;
                else if (distancia2(personaje.posicion, enemigo.posicion) < distancia2(personaje.posicion, mejorObjetivo.posicion))
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
        while(this.personaje.estado != AbstractObjeto.ESTADO.MUERTO){
            try {
                if (personaje.objetivo == null || ((Personaje)personaje.objetivo).estado == AbstractObjeto.ESTADO.MUERTO){
                    personaje.objetivo = buscarObjetivo(personaje.getEnemigos());
                }else if (distancia2(personaje.objetivo.posicion, personaje.posicion) <= Math.pow(((Arma)this.arma).alcance,2)){
                    atacar();
                    sleep((int)(1000/personaje.golpesSegundo));
                }else{
                    personaje.mover();
                    sleep((int)(1000/personaje.velocidad));
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Guerrero clonar() throws CloneNotSupportedException {
       return new Guerrero(personaje, arma);
    }

    @Override
    public Guerrero deepclonar() throws CloneNotSupportedException {
        return new Guerrero(personaje.deepclonar(), arma.deepclonar());
    }

    @Override
    public String toString() {
        return "Guerrero{" + "personaje=" + personaje.toString() + ", arma=" + arma.toString() + '}';
    }
    
    
    
}
