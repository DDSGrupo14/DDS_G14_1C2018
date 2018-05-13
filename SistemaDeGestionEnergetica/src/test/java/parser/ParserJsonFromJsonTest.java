package parser;

import json.CargarUsuariosDesdeJson;
import modelos.Usuario;
import org.junit.jupiter.api.Test;

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

        assertEquals( 5, usuario.cantidadTotalDeDispositivos(), "No coincide cantidad." );

    }

    @Test
    public void deberiaDeHaberTresDispositivosApagadosTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);


        assertEquals( 3, usuario.cantidadTotalDeDispositivosApagados(), "No coincide cantidad." );

    }

    @Test
    public void soloDeberiaHaberUnDispositivoEncendidoTest() {

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        usuario.getDomicilios().get(1).getDispositivos().get(0).setEncendido(true);

        assertEquals( 1, usuario.cantidadTotalDeDispositivosEncendidos(), "No coincide cantidad." );

    }

    @Test
    public void noDeberiaHaberDispositivosEncendidosEnCualquierDomicilioTest(){

        List<Usuario> usuarios = obtenerUsuarios();

        Usuario usuario = usuarios.get(0);

        usuario.getDomicilios().get(1).getDispositivos().get(0).setEncendido(true);

        assertFalse( usuario.hayAlgunDispositivoEncendidoEnAlgunDomicilio(),"Error.");

    }

}
