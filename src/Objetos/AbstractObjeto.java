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
public abstract class AbstractObjeto {
    public enum ESTADO {ESPERANDO, AVANZANDO, ATACANDO, MUERTO}
    
    protected String nombre;                    // Nombre que tendrá el objeto
    protected int vida;                         // Puntos de vida del objeto
    protected int nivel;                        // Nivel en el que está el objeto
    protected ESTADO estado;                    // El estado actual del guerrero
    protected int nivelAparicion;               // Nivel del personaje a partir del cual se tendrá acceso al objeto
    protected int costo;                        // Costo en dinero del juego necesario para comprar el objeto
    protected ArrayList<String> apariencia;     // Lista de direcciones donde estarán las imágenes de este objeto
    protected Point posicion;                   // Posición en la cuadrícula donde está este objeto.

    public AbstractObjeto(String nombre, int vida, int nivel, ESTADO estado, int nivelAparicion, int costo, ArrayList<String> apariencia, Point posicion) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.estado = estado;
        this.nivelAparicion = nivelAparicion;
        this.costo = costo;
        this.apariencia = apariencia;
        this.posicion = posicion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<String> getApariencia() {
        return apariencia;
    }

    public void setApariencia(ArrayList<String> apariencia) {
        this.apariencia = apariencia;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }
    
    
}
