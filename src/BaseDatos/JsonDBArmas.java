package BaseDatos;

/**
 * @author jeesquivel
 */

import Objetos.AbstractObjeto;
import Objetos.Arma;
import Objetos.IArma;
import Objetos.Personaje;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class JsonDBArmas implements IBDArma {

    public JSONObject jsonArmas;
    public Data datos;


    public JsonDBArmas()  {
        datos= new Data();
        try {
            this.jsonArmas = (JSONObject) cargarJson("/home/jeesquivel/Documentos/TEC/diseño/ClansWars/src/BaseDatos/Armas.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cargarAramas();
        cargarPersonajes();
    }


    public static Object cargarJson(String filename) throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename);
        return jsonParser.parse(reader);

    }


    @Override
    public void editarArmas(String nameArma, String atributo,  long valor) {
    }

    @Override
    public void cargarAramas() {
        String nombre;
        long alcance;
        long danno;
        long rango;
        long nivel ;
        long nivelAparicion ;
        String  apariencia ;


        ArrayList atributos =  (ArrayList) jsonArmas.get("armeria");

        for (Object i:atributos) {
            Map mapa = (Map) i;
            nombre = (String) mapa.get("name");
            System.out.println(nombre);
            alcance = (long) mapa.get("alcance");
            danno = (long) mapa.get("danno");
            rango = (long) mapa.get("rango");
            nivel = (long) mapa.get("nivel");
            nivelAparicion = (long) mapa.get("nivelAparicion");
            apariencia = (String) mapa.get("apariencia");

            Arma arma = new Arma(nombre, alcance, danno, rango, nivel, nivelAparicion, apariencia);
            datos.addArma(arma); // agrega un armaal arreglo de armas


        }
    }

    @Override
    public void cargarPersonajes() {
        String nombre;
        long vida;
        long nivel;
        long nivelMaximo;
        long nivelAparicion;
        long costo;
        ArrayList apariencia = new ArrayList();
        Point punto;
        long velocidad, golpesXsegundo, campos;
        long x,  y;

        ArrayList atributos = (ArrayList) jsonArmas.get("Personajes");

        for (Object i : atributos) {
            Map mapa = (Map) i;
            nombre = (String) mapa.get("nombre");
            vida = (long) mapa.get("vida");
            nivel = (long) mapa.get("nivel");
            nivelMaximo = (long) mapa.get("nivelMaximo");
            nivelAparicion = (long) mapa.get("nivelAparicion");
            costo = (long) mapa.get("costo");
            apariencia = (ArrayList) mapa.get("apariencia");
            x= (long)mapa.get("x");
            y= (long)mapa.get("y");
            punto= new Point((int) x,(int) y);
            velocidad= (long) mapa.get("velocidad");
            campos =(long) mapa.get("campos");
            golpesXsegundo=(long) mapa.get("golpesXsegundo");

            Personaje personaje = new Personaje(nombre,vida,nivel,nivelMaximo, AbstractObjeto.ESTADO.ESPERANDO, nivelAparicion,  costo, apariencia, punto,  golpesXsegundo,  campos,  velocidad);

            System.out.println(personaje.toString());


            datos.addPersonaje(personaje);
        }
    }



    @Override
    public void guardarArma(IArma arma) {
    }

    @Override
    public void borrarArma(IArma arma) {

    }



    public Data getData(){
        return datos;
    }





}
