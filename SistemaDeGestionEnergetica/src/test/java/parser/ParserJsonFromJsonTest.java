package parser;

import json.CargarUsuariosDesdeJson;
import modelos.Usuario;
import org.junit.jupiter.api.Test;
import servicios.UserServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserJsonFromJsonTest {

    CargarUsuariosDesdeJson cargarUsuarios = new CargarUsuariosDesdeJson();

    String path = "src/main/resources/json/usuarios.json";

    public List<Usuario> obtenerUsuarios() {

        List<Usuario> usuarios;

        try {

            usuarios= cargarUsuarios.load(new File(path));

        } catch (IOException e) {

            usuarios = null;

            e.printStackTrace();
        }

        return usuarios;

    }

    @Test
    public void cargarUsuariosDesdeJsonTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        assertEquals(1,usuarios.size(), "No coincide.");

    }

    @Test
    public void deberianExistirSoloTresDispositivosTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        UserServices services = new UserServices();

        assertEquals( new Long(5), services.cantidadTotalDeDispositivos(usuario), "No coincide cantidad." );

    }

    @Test
    public void deberiaDeHaberTresDispositivosApagadosTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        UserServices services = new UserServices();

        assertEquals( new Long(3), services.cantidadTotalDeDispositivosApagados(usuario), "No coincide cantidad." );

    }

    @Test
    public void soloDeberiaHaberUnDispositivoEncendidoTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        UserServices services = new UserServices();

        usuario.getDomicilios().get(1).getDispositivos().get(0).setEncendido(true);

        assertEquals( new Long(1), services.cantidadTotalDeDispositivosEncendidos(usuario), "No coincide cantidad." );

    }

    @Test
    public void noDeberiaHaberDispositivosEncendidosEnCualquierDomicilioTest(){

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        UserServices services = new UserServices();

        usuario.getDomicilios().get(1).getDispositivos().get(0).setEncendido(true);

        assertFalse( services.hayAlgunDispositivoEncendidoEnCualquierDomicilio(usuario),"Error.");

    }

}
