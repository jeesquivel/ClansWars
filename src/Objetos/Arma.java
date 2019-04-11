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
public class Arma implements IArma{
    protected String nombre;
    protected int alcance;
    protected int danno;
    protected int rango;
    protected int nivel;
    protected int nivelAparicion;
    protected ArrayList<String> apariencia;

    public Arma(String nombre, int alcance, int danno, int rango, int nivel, int nivelAparicion, ArrayList<String> apariencia) {
        this.nombre = nombre;
        this.alcance = alcance;
        this.danno = danno;
        this.rango = rango;
        this.nivel = nivel;
        this.nivelAparicion = nivelAparicion;
        this.apariencia = apariencia;
    }
    

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    @Override
    public IPrototype clone() throws CloneNotSupportedException{
        return (IPrototype)super.clone();
        //return new Arma(nombre, vida, nivel, estado, nivelAparicion, costo, apariencia, posicion, alcance, danno, rango);
    }

    @Override
    public IPrototype deepclone() throws CloneNotSupportedException {
        return (IPrototype)super.clone();
        //return new Arma(nombre, vida, nivel, estado, nivelAparicion, costo, (ArrayList<String>)apariencia.clone(), (Point)posicion.clone(), alcance, danno, rango);
    }

    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", alcance=" + alcance + ", danno=" + danno + ", rango=" + rango + ", nivel=" + nivel + ", nivelAparicion=" + nivelAparicion + ", apariencia=" + apariencia + '}';
    }
    
    
}
