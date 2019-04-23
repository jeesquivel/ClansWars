package Constructores;

import Objetos.*;
import com.sun.deploy.perf.PerfRollup;
import org.omg.CORBA.PERSIST_STORE;

public class PersonajeFactory  implements IPersonajeFactoryMethod{
    @Override
    public Personaje crearPersonaje(String tipo, String nombre, long vida, long nivel, long nivelMaximo, AbstractObjeto.ESTADO estado, long nivelAparicion, long costo, String apariencia, long golpesSegundo, long campos, long velocidad) {

        Personaje personaje;

        switch (tipo){
            case "BARBARO":
                personaje= new Barbaro(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            case"MAGO":
                personaje= new Mago(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            case "ENFEREMERA":
                personaje= new Enfermera(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            case "SOLDADO":
                personaje= new Soldado(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
            case"ARQUERA":
                personaje = new Arquera(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
                break;
                default:
                    personaje= new Barbaro(nombre,vida,nivel,nivelMaximo,estado,nivelAparicion,costo,apariencia,golpesSegundo,campos,velocidad);
        }
        return personaje;
    }
}
