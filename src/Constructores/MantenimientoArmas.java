package Constructores;

import BaseDatos.JsonDBArmas;
import Objetos.IArma;

import java.util.ArrayList;

public class MantenimientoArmas {
    private static JsonDBArmas jsonDBArmas;
    private static  MantenimientoArmas mantenimientoArmas;



    private static MantenimientoArmas getMantenimientoArmas() throws Exception {
        if (mantenimientoArmas== null)
            mantenimientoArmas= new MantenimientoArmas();
        return mantenimientoArmas;
    }


    private MantenimientoArmas() throws Exception {
        this.jsonDBArmas= new JsonDBArmas();

    }









}
