package BaseDatos;



import Objetos.Arma;
import Objetos.IArma;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;


import java.io.FileReader;
import java.net.URLClassLoader;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonDBArmas implements IBDArma {

    public JSONObject jsonArmas;
    public ArrayList<IArma> catalogoArmas= new ArrayList<>();

    public JsonDBArmas()  {
        try {
            this.jsonArmas = (JSONObject) cargarJson("/home/jeesquivel/Documentos/TEC/diseño/ClansWars/src/BaseDatos/Armas.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cargarAramas();
    }


    public static Object cargarJson(String filename) throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename);
        return jsonParser.parse(reader);

    }


    @Override
    public void guardarArmas() {

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
            Map mapa= (Map) i;
            nombre= (String) mapa.get("name");
            alcance= (long) mapa.get("alcance");
            danno= (long) mapa.get("danno");
            rango=(long) mapa.get("rango");
            nivel=(long) mapa.get("nivel");
            nivelAparicion =(long) mapa.get("nivelAparicion");
            apariencia = (String) mapa.get("apariencia");


            Arma arma = new Arma(nombre,alcance,danno,rango,nivel,nivelAparicion,apariencia);
            catalogoArmas.add(arma);
        }
    }








    @Override
    public void guardarArma(IArma arma) {

    }

    @Override
    public void borrarArma(IArma arma) {

    }

    public ArrayList<IArma> getCatalogoArmas() {
        return catalogoArmas;
    }

    public void setCatalogoArmas(ArrayList<IArma> catalogoArmas) {
        this.catalogoArmas = catalogoArmas;
    }
}
