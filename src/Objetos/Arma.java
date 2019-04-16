/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

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
    protected long nivelMaximo;
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

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    public long getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(long nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public long getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(long nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public String getApariencia() {
        return apariencia;
    }

    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }
    
    
}
