package Constructores;


import Objetos.Arma;

/**
 * @author jeesquivel
 */

public interface IMantenimiento {

    public void guardar();
    public Object cargarTodo();
    public void cargar();
    public void insertar();
    public void borrar();
    void editarArma(Arma arma);
}
