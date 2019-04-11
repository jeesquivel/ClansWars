package BaseDatos;



import Objetos.Arma;
import Objetos.IArma;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;



import java.io.FileReader;
import java.util.ArrayList;

public class JsonDBArmas implements IBDArma {

    public JSONObject jsonArmas;

    public JsonDBArmas() throws Exception {
       this. jsonArmas =  (JSONObject) cargarJson("example.json");
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
    public ArrayList<IArma> cargarAramas() {
        String name= (String) jsonArmas.get("name");
        Integer alcance= (Integer) jsonArmas.get("alcance");
        Integer danno =  (Integer) jsonArmas.get("danno");
        Integer rango =  (Integer) jsonArmas.get("rango");

        //Arma arma = new Arma(name,alcance,danno,rango);


        return null;

    }

    @Override
    public void guardarArma(IArma arma) {

    }

    @Override
    public void borrarArma(IArma arma) {

    }
}
