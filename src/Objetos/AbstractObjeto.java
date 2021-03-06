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
 * @author Alexander
 */
public abstract class AbstractObjeto{
    public enum ESTADO {ESPERANDO, AVANZANDO, ATACANDO, MUERTO}
    
    protected String nombre;                    // Nombre que tendrá el objeto
    protected long vida;                         // Puntos de vida del objeto
    protected long nivel;                        // Nivel en el que está el objeto
    protected long nivelMaximo;                  // Nivel máximo al que puede llegar este personaje
    protected ESTADO estado;                    // El estado actual del guerrero
    protected long nivelAparicion;               // Nivel del personaje a partir del cual se tendrá acceso al objeto
    protected long costo;                        // Costo en dinero del juego necesario para comprar el objeto
    protected String apariencia;     // Lista de direcciones donde estarán las imágenes de este objeto
    protected Point posicion;                   // Posición en la cuadrícula donde está este objeto.

    public AbstractObjeto(String nombre, long vida, long nivel, long nivelMaximo, ESTADO estado, long nivelAparicion, long costo,String apariencia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.nivelMaximo = nivelMaximo;
        this.estado = estado;
        this.nivelAparicion = nivelAparicion;
        this.costo = costo;
        this.apariencia = apariencia;
        this.posicion = new Point(0,0);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getVida() {
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

    public long getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public long getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(int nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public long getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String  getApariencia() {
        return apariencia;
    }

    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "AbstractObjeto{" + "nombre=" + nombre + ", vida=" + vida + ", nivel=" + nivel + ", nivelMaximo=" + nivelMaximo + ", estado=" + estado + ", nivelAparicion=" + nivelAparicion + ", costo=" + costo + ", apariencia=" + apariencia + ", posicion=" + posicion + '}';
    }
    
    
}
