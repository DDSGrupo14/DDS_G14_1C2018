package Json;

import Modelos.Usuario;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarUsuariosDesdeJson {

    public List<Usuario> load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        final Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        return  new GsonBuilder().create().fromJson(json, listType);
    }

}
