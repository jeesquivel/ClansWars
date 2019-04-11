/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Alexander Borbón Alpízar
 * @param <T>
 */
public interface IPrototype<T> extends Cloneable{
    public IPrototype<T> clone() throws CloneNotSupportedException;       // Clonado superficial del objeto
    public IPrototype<T> deepclone() throws CloneNotSupportedException;   // Clonado profundo del objeto
}
