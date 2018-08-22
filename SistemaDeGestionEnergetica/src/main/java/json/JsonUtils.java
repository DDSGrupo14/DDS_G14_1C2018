package json;

import com.google.gson.GsonBuilder;
import modelos.dispositivos.adaptadores.Adaptador;

public class JsonUtils {

    public static String toJson(Object object) {
        final GsonBuilder gson = new GsonBuilder();
        gson.excludeFieldsWithoutExposeAnnotation();
        gson.registerTypeAdapter(Adaptador.class, new InterfaceAdapter<Adaptador>());
        return gson.setPrettyPrinting().create().toJson(object);
    }

}
