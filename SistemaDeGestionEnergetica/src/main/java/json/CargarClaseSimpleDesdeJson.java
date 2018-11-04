package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CargarClaseSimpleDesdeJson<T> {

    private Class<?> wrapped;

    public CargarClaseSimpleDesdeJson(Class<T> wrapped){
        this.wrapped = wrapped;
    }

    public List< T > load(File file) throws IOException {
        final String json = new JsonFile(file.getAbsolutePath()).read();
        //final Type listType = new TypeToken<ArrayList< T >>(){}.getType();

        final Type listType = TypeToken.getParameterized(ArrayList.class, wrapped).getType();

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.serializeNulls();

        final Gson gson = gsonBuilder.create();

        return  gson.fromJson(json, listType);
    }


    public List<T> obtenerListaClaesComun(String path) {

        List<T> lista;

        try {

            lista= load(new File(path));

        } catch (IOException e) {

            lista = null;
            e.printStackTrace();
        }
        return lista;
    }

}
