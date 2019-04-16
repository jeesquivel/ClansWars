package BaseDatos;

import Objetos.Arma;
import Objetos.IArma;
import Objetos.IPrototype;
import com.sun.deploy.panel.IProperty;

import java.util.ArrayList;

public class Data {

    public ArrayList<Arma> armas = new ArrayList<>();
    public ArrayList<IPrototype> personajes= new ArrayList<>();
    public ArrayList<IPrototype> guerreros= new ArrayList<>();


    public Data() {

    }


    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void addArma(Arma arma) {
        this.armas.add(arma);
    }

    public ArrayList<IPrototype> getPersonajes() {
        return personajes;
    }

    public void addPersonaje(IPrototype personaje) {
        this.personajes.add(personaje);
    }

    public ArrayList<IPrototype> getGuerreros() {
        return guerreros;
    }

    public void addGuerrero(IPrototype guerrero) {
        this.guerreros.add(guerrero);
    }
}
