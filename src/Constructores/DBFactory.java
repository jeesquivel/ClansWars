package Constructores;

import BaseDatos.IBDArma;
import BaseDatos.JsonDBArmas;

public class DBFactory {


    public IBDArma getDefaultDBArma() throws Exception {
            return new JsonDBArmas();
    };



}
