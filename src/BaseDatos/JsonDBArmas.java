package BaseDatos;



import Objetos.Arma;
import Objetos.IArma;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;



import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonDBArmas implements IBDArma {

    public JSONObject jsonArmas;

    public JsonDBArmas() throws Exception {
       this. jsonArmas =  (JSONObject) cargarJson("/home/jeesquivel/Documentos/TEC/diseño/ClansWars/src/BaseDatos/Armas.json");
    }


    public static Object cargarJson(String filename) throws Exception {
        JSONParser jsonParser=  new JSONParser();
        FileReader reader = new FileReader(filename);
        return jsonParser.parse(reader);

    }


    @Override
    public void guardarArmas() {

    }

    @Override
    public void  cargarAramas() {
        ArrayList atributos = (ArrayList) jsonArmas.get("armeria");
        System.out.println(atributos.get(0).toString());

    }

    @Override
    public void guardarArma(IArma arma) {

    }

    @Override
    public void borrarArma(IArma arma) {

    }
}
