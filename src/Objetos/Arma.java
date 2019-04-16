/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author alexander
 * @author jeesquivel
 */
public class Arma implements IArma{
    protected String nombre;
    protected long alcance;
    protected long danno;
    protected long rango;
    protected long nivel;
    protected long nivelAparicion;
    protected String apariencia;

    public Arma(String nombre, long alcance, long danno, long rango, long nivel, long nivelAparicion, String apariencia) {
        this.nombre = nombre;
        this.alcance = alcance;
        this.danno = danno;
        this.rango = rango;
        this.nivel = nivel;
        this.nivelAparicion = nivelAparicion;
        this.apariencia = apariencia;
    }
    


    public long getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public long getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public long getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    @Override
    public Arma clonar() {
       return new Arma(nombre, alcance, danno, rango, nivel, nivelAparicion, apariencia);
    }

    @Override
    public Arma deepclonar() {
        return new Arma(nombre, alcance, danno, rango, nivel, nivelAparicion,  apariencia);
    }

    @Override
    public String toString() {
        return "Arma {" + "nombre=" + nombre + ", alcance=" + alcance + ", danno=" + danno + ", rango=" + rango + ", nivel=" + nivel + ", nivelAparicion=" + nivelAparicion + ", apariencia=" + apariencia + '}';
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
