package Constructores;

import BaseDatos.JsonDBArmas;
import Objetos.IArma;

import java.util.ArrayList;

public class MantenimientoArmas {
    private static JsonDBArmas armeria;
    private static  MantenimientoArmas mantenimientoArmas;



    public static  MantenimientoArmas getMantenimientoArmas() {
        if (mantenimientoArmas== null)
            mantenimientoArmas= new MantenimientoArmas();
        return mantenimientoArmas;
    }


    private  MantenimientoArmas()  {
        armeria= (JsonDBArmas) new DBFactory().getDefaultDBArma();
    }



    public ArrayList<IArma> getArmeria(){
        return armeria.getCatalogoArmas();
    }










}
