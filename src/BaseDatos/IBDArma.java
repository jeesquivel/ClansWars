package BaseDatos;

import Objetos.Arma;
import Objetos.IArma;

import java.util.ArrayList;

public interface IBDArma {
    public void editarArmas(String nameArma, String atributo,  long valor);
    public void cargarArmas();
    public void guardarArma(IArma arma);
    public void borrarArma(IArma arma);
    void cargarPersonajes();
    void cargarEstados();
}
