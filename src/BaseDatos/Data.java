package BaseDatos;

import Objetos.Arma;
import Objetos.IPrototype;
import Objetos.Personaje;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    public HashMap<String, IPrototype> personajes = new HashMap<>();
    public HashMap<String, IPrototype> guerreros = new HashMap<>();
    public HashMap<String, Arma> armas = new HashMap<>();
    public ArrayList<String> estados = new ArrayList<>();
    public ArrayList<String> TiposGenerales= new ArrayList<>();
    public ArrayList<String> tiposArmas = new ArrayList<>();

    public ArrayList<String> getTiposArmas() {
        return tiposArmas;
    }

    public void setTiposArmas(ArrayList<String> tiposArmas) {
        this.tiposArmas = tiposArmas;
    }


    public ArrayList<String> getTiposGenerales() {
        return this.TiposGenerales;
    }

    public void setTiposGenerales(ArrayList<String> tiposGenerales) {
        this.TiposGenerales = tiposGenerales;
    }


    public Data() {
    }




    public ArrayList<String> getEstados(){
        return this.estados;
    }

    public void setEstado(String estado){
        estados.add(estado);
    }

    public HashMap<String, Arma> getArmas() {
        return armas;
    }

    public void addArma(Arma arma) {
        this.armas.put(arma.getNombre(), arma);
    }

    public HashMap<String, IPrototype> getPersonajes() {
        return personajes;
    }

    public void addPersonaje(Personaje personaje) {

        this.personajes.put(personaje.getNombre(), personaje);
    }

    public HashMap<String, IPrototype> getGuerreros() {
        return guerreros;
    }

    public void addGuerrero(Personaje guerrero) {

        this.guerreros.put(guerrero.getNombre(), guerrero);
    }

}
