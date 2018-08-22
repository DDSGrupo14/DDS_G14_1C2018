package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import json.Deserializers.*;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarClientesDesdeJson {

    public List<Cliente> load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        final Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.serializeNulls();

        gsonBuilder.registerTypeAdapter(Domicilio.class, new DomicilioDeserializer());

        gsonBuilder.registerTypeAdapter(DispositivoInteligente.class, new DispositivoInteligenteDeserializer());

        gsonBuilder.registerTypeAdapter(AdaptadorEstandar.class, new AdaptadorEstandarDeserializer());

        gsonBuilder.registerTypeAdapter(AdaptadorAire.class, new AdaptadorAireDeserializer());

        final Gson gson = gsonBuilder.create();

        return  gson.fromJson(json, listType);
    }

}
