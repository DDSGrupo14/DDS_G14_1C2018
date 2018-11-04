package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelos.usuarios.Administrador;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarAdminsDesdeJson {

    public List<Administrador> load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        final Type listType = new TypeToken<ArrayList<Administrador>>(){}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.serializeNulls();

        final Gson gson = gsonBuilder.create();

        return  gson.fromJson(json, listType);
    }
}
