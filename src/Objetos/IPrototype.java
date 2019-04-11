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
public interface IPrototype<T>{
    public T clonar() throws CloneNotSupportedException;       // Clonado superficial del objeto
    public T deepclonar() throws CloneNotSupportedException;   // Clonado profundo del objeto
}
