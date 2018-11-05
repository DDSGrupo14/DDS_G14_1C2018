package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import json.Deserializers.ZonaDeserializer;
import json.JsonFile;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.enre.Zona;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarZonaDesdeJson {

    public List<Zona> load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        final Type listType = new TypeToken<ArrayList<Zona>>(){}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.serializeNulls();

        gsonBuilder.registerTypeAdapter(Zona.class, new ZonaDeserializer());


        final Gson gson = gsonBuilder.create();

        return  gson.fromJson(json, listType);
    }
}
