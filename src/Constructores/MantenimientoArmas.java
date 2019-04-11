package Constructores;





import BaseDatos.JsonDBArmas;
import Objetos.IArma;

import java.util.ArrayList;

public class MantenimientoArmas implements IMantenimiento{
    private static JsonDBArmas armeria;
    private static  MantenimientoArmas mantenimientoArmas;



    public static  MantenimientoArmas getInstance() {
        if (mantenimientoArmas== null)
            mantenimientoArmas= new MantenimientoArmas();
        return mantenimientoArmas;
    }


    private  MantenimientoArmas()  {
        armeria= (JsonDBArmas) new DBFactory().getDefaultDBArma();
    }



    @Override
    public void guardar() {

    }

    @Override
    public Object cargarTodo() {
        return armeria.getCatalogoArmas();
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
}
