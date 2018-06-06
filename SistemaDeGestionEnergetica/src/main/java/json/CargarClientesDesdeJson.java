package json;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelos.usuarios.Cliente;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarClientesDesdeJson {

    public List<Cliente> load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        final Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
        return  new GsonBuilder().create().fromJson(json, listType);
    }

}
