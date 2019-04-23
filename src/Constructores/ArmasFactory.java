package Constructores;

import Objetos.ArmaAtaque;
import Objetos.ArmaHechizo;
import Objetos.IArma;

public class ArmasFactory implements IArmaFactoryMethod {

    @Override
    public IArma crearArma(String nombre,String tipo,  long alcance, long danno, long rango, long nivel, long nivelMaximo, long nivelAparicion, String apariencia,String puedeUsar) {
        IArma objetoArma;

        switch (tipo){
            case "HECHIZO":
                objetoArma= new ArmaHechizo(nombre,tipo,alcance,danno,rango,nivel,nivelMaximo,nivelAparicion,apariencia,puedeUsar);
                break;
            case "ATAQUE":
                objetoArma = new ArmaAtaque(nombre,tipo,alcance,danno,rango,nivel,nivelMaximo,nivelAparicion,apariencia,puedeUsar);
                break;
            default:
                objetoArma =null;
        }
        return  objetoArma;
    }

}
