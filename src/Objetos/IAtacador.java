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
 */
public interface IAtacador {
    public void atacar();
    public AbstractObjeto buscarObjetivo(ArrayList<AbstractObjeto> enemigos);
}
