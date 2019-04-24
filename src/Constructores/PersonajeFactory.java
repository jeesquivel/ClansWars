package Constructores;

import Objetos.*;

public class PersonajeFactory  implements IPersonajeFactoryMethod{
    @Override
    public Personaje crearPersonaje(String tipo, String nombre, long vida, long nivel, long nivelMaximo, AbstractObjeto.ESTADO estado, long nivelAparicion, long costo, String apariencia, long golpesSegundo, long campos, long velocidad) {

        Personaje personaje;

        switch (tipo){

            case"AEREO":
                personaje= new PersonajeAereo(nombre,tipo,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            case"TERRESTRE":
                personaje = new PersonajeTerrestre(nombre,tipo,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            default:
                personaje = new PersonajeTerrestre(nombre,tipo,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
        }
        return personaje;
    }
}
