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
public class Arma extends AbstractObjeto implements IArma, IPrototype{
    protected int alcance;
    protected int danno;
    protected int rango;

    public Arma(String nombre, int vida, int nivel, ESTADO estado, int nivelAparicion, int costo, ArrayList<String> apariencia, Point posicion, int alcance, int danno, int rango) {
        super(nombre, vida, nivel, estado, nivelAparicion, costo, apariencia, posicion);
        this.alcance = alcance;
        this.danno   = danno;
        this.rango   = rango;
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
    public IPrototype clone() {
        return new Arma(nombre, vida, nivel, estado, nivelAparicion, costo, apariencia, posicion, alcance, danno, rango);
    }

    @Override
    public IPrototype deepclone() {
        return new Arma(nombre, vida, nivel, estado, nivelAparicion, costo, (ArrayList<String>)apariencia.clone(), (Point)posicion.clone(), alcance, danno, rango);
    }
    
    
}
