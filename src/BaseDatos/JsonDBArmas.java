package BaseDatos;

/**
 * @author jeesquivel
 */


import Objetos.AbstractObjeto;
import Objetos.Arma;
import Objetos.IArma;
import Objetos.Personaje;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class JsonDBArmas implements IBDArma {

    public JSONObject jsonArmas;
    public Data datos;


    public JsonDBArmas()  {
        datos= new Data();
        try {
            this.jsonArmas = (JSONObject) cargarJson(getClass().getResource("./Armas.json").getPath().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        cargarArmas();
        cargarPersonajes();
        cargarEstados();
        cargarTiposGenerales();
        cargarTiposArmas();
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
    public void cargarArmas() {

        String nombre;
        String tipo;
        long nivel;
        long nivelMaximo ;
        long nivelAparicion;
        long  danno;
        long  alcance;
        long rango;
        String  apariencia ;
        String puedeUsar;


        ArrayList atributos =  (ArrayList) jsonArmas.get("armeria");

        for (Object i:atributos) {
            Map armaAux = (Map) i;
            nombre = (String) armaAux.get("nombre");
            tipo= (String) armaAux.get("tipo");
            nivel= (long) armaAux.get("nivel");
            nivelMaximo= (long) armaAux.get("nivelMaximo");
            nivelAparicion= (long) armaAux.get("nivelAparicion");
            danno= (long) armaAux.get("danno");
            alcance= (long) armaAux.get("danno");
            rango= (long) armaAux.get("rango");
            apariencia= (String) armaAux.get("apariencia");
            puedeUsar= (String) armaAux.get("puedeUsar");

                // arreglar esta mierda y poner un patron de disenno

            Arma arma  = new Arma(nombre, tipo,alcance, danno, rango, nivel,nivelMaximo, nivelAparicion,apariencia,puedeUsar);
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
        String apariencia;
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
            apariencia = (String) mapa.get("apariencia");
            x= (long)mapa.get("x");
            y= (long)mapa.get("y");
            punto= new Point((int) x,(int) y);
            velocidad= (long) mapa.get("velocidad");
            campos =(long) mapa.get("campos");
            golpesXsegundo=(long) mapa.get("golpesXsegundo");

            Personaje personaje = new Personaje(nombre,vida,nivel,nivelMaximo, AbstractObjeto.ESTADO.ESPERANDO, nivelAparicion,  costo, apariencia,  golpesXsegundo,  campos,  velocidad);
            datos.addPersonaje(personaje);
        }
    }

    @Override
    public void cargarEstados() {
        ArrayList<String> estados = (ArrayList) jsonArmas.get("estados");

        for (String i: estados) {
            datos.setEstado(i);
        }
    }

    @Override
    public void cargarTiposGenerales() {
        ArrayList<String> tipos = (ArrayList<String>) jsonArmas.get("TiposGenerales");
        datos.setTiposGenerales(tipos);


    }

    @Override
    public void cargarTiposArmas() {
        ArrayList<String> tipos = (ArrayList<String>) jsonArmas.get("TiposArmas");
        datos.setTiposArmas(tipos);

    }

    @Override
    public void guardarArma(IArma arma) {
    }

    @Override
    public void borrarArma(IArma arma) {

    }

    public void actualizarArmas(){
        ObjectMapper mapper= new ObjectMapper();
        Map<String,Object> mapa= new HashMap<>();
        mapa.put("armeria",datos.getArmas());

        JSONArray employeeList = (JSONArray)  jsonArmas.get("armeria");
        //Write JSON file
        try (FileWriter file = new FileWriter("Armas1.json")) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public Data getData(){
        return datos;
    }
}
