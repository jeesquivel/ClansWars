package BaseDatos;

import Objetos.Arma;
import Objetos.IArma;

import java.util.ArrayList;

public interface IBDArma {
    public void guardarArmas();
    public void cargarAramas();
    public void guardarArma(IArma arma);
    public void borrarArma(IArma arma);
}
