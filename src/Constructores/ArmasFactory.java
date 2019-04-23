package Constructores;

import Objetos.ArmaAtaque;
import Objetos.IArma;

public class ArmasFactory implements IArmaFactoryMethod {

    @Override
    public IArma crearArma(String tipo, String nombre, long alcance, long danno, long rango, long nivel, long nivelMaximo, long nivelAparicion, String apariencia) {
        IArma objetoArma;

        switch (tipo){
            case "SANACION":
                objetoArma= null ;
                break;
            case "ATAQUE":
                objetoArma = new ArmaAtaque(nombre,alcance,danno,rango,nivel,nivelMaximo,nivelAparicion,apariencia);
                break;
            default:
                objetoArma =null;
        }
        return  objetoArma;
    }

}
