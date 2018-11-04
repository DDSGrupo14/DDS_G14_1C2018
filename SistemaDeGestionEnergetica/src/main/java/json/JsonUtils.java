package json;

import com.google.gson.GsonBuilder;
import modelos.dispositivos.TipoDispositivo;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static String toJson(Object object) {
        final GsonBuilder gson = new GsonBuilder();
        gson.excludeFieldsWithoutExposeAnnotation();
        gson.registerTypeAdapter(Adaptador.class, new InterfaceAdapter<Adaptador>());
        return gson.setPrettyPrinting().create().toJson(object);
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

    public static List<Administrador> obtenerAdmins(String path) {

        final CargarClaseSimpleDesdeJson cargarAdmins = new CargarClaseSimpleDesdeJson<Administrador>(Administrador.class);
        List<Administrador> administradores;

        try {

            administradores= cargarAdmins.load(new File(path));

        } catch (IOException e) {

            administradores = null;
            e.printStackTrace();
        }
        return administradores;
    }

    public static List<TipoDispositivo> obtenerTiposConcretos(String path) {

        final CargarClaseSimpleDesdeJson cargarTipos = new CargarClaseSimpleDesdeJson<TipoDispositivo>(TipoDispositivo.class);
        List<TipoDispositivo> tipos;

        try {

            tipos= cargarTipos.load(new File(path));

        } catch (IOException e) {

            tipos = null;
            e.printStackTrace();
        }
        return tipos;
    }
}
