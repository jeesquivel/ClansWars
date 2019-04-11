/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author alexander
 * @param <T>
 */
public interface IPrototype<T> {
    public IPrototype<T> clone();       // Clonado superficial del objeto
    public IPrototype<T> deepclone();   // Clonado profundo del objeto
}
