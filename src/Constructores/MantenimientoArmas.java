package Constructores;





import BaseDatos.Data;
import BaseDatos.JsonDBArmas;
import Objetos.Arma;
import Objetos.IPrototype;

import java.util.ArrayList;
import java.util.HashMap;


public class MantenimientoArmas implements IMantenimiento{
    private static JsonDBArmas armeria;
    private static  MantenimientoArmas mantenimientoArmas;


    public static  MantenimientoArmas getInstance() {
        if (mantenimientoArmas== null)
            mantenimientoArmas= new MantenimientoArmas();
        return mantenimientoArmas;
    }

    private  MantenimientoArmas()  {
        armeria = (JsonDBArmas) new DBFactory().getDefaultDBArma();
    }

    public static void setArmeria(JsonDBArmas armeria) {
        MantenimientoArmas.armeria = armeria;
    }


    @Override
    public void guardar() {

    }

    @Override
    public Object cargarTodo() {
        return armeria;
    }

    @Override
    public void cargar() {

    }

    @Override
    public void insertar() {

    }

    @Override
    public void borrar() {

    }

    @Override
    public void editarArma(Arma arma) {
        armeria.getData().getArmasHash().put(arma.getNombre(), arma);
    }

    public Data getDatos(){
        return armeria.getData();
    }

    public ArrayList<IPrototype> getPersonajes(){
        return armeria.getData().getPersonajes();
    }


}
