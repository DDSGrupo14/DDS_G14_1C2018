package json;

import com.google.gson.GsonBuilder;
import modelos.dispositivos.TipoDispositivo;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonUtils {


    public static String toJson(Object object) {
        final GsonBuilder gson = new GsonBuilder();
        gson.excludeFieldsWithoutExposeAnnotation();
        gson.registerTypeAdapter(Adaptador.class, new InterfaceAdapter<Adaptador>());
        return gson.setPrettyPrinting().create().toJson(object);
    }

    public static void crearArchivoJson( List<?> lista, String path){

        final String json = toJson( lista );

        try {

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write( json );
            fileWriter.close();

        } catch ( IOException e) {

            e.printStackTrace();
        }
    }

    public static List<Cliente> obtenerClientes(String path) {

        final CargarClientesDesdeJson cargarClientes = new CargarClientesDesdeJson();
        List<Cliente> clientes;

        try {

            clientes= cargarClientes.load(new File(path));

        } catch (IOException e) {

            clientes = null;
            e.printStackTrace();
        }
        return clientes;
    }

}
