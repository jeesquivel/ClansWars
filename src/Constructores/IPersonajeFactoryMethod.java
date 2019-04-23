package Constructores;

import Objetos.AbstractObjeto;
import Objetos.IPrototype;
import Objetos.Personaje;

public interface IPersonajeFactoryMethod {
    public Personaje crearPersonaje(String tipo, String nombre, long vida, long nivel, long nivelMaximo,
                                    AbstractObjeto.ESTADO estado, long nivelAparicion, long costo, String apariencia,
                                    long golpesSegundo, long campos, long velocidad);

    }
