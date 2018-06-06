package parser;

import json.CargarClientesDesdeJson;
import modelos.usuarios.Cliente;
import modelos.usuarios.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserJsonFromJsonTest {

    CargarClientesDesdeJson cargarClientes = new CargarClientesDesdeJson();

    String path = "src/main/resources/json/clientes.json";

    public List<Cliente> obtenerClientes() {

        List<Cliente> clientes;

        try {

            clientes= cargarClientes.load(new File(path));

        } catch (IOException e) {

            clientes = null;

            e.printStackTrace();
        }

        return clientes;

    }

    @Test
    public void cargarClientesDesdeJsonTest() {

        List<Cliente> clientes = obtenerClientes();

        assertEquals(1,clientes.size(), "No coincide.");

    }

    @Test
    public void deberianExistirSoloTresDispositivosTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        assertEquals( 5, cliente.cantidadTotalDeDispositivos(), "No coincide cantidad." );

    }

    @Test
    public void deberiaDeHaberTresDispositivosApagadosTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        assertEquals( 3, cliente.cantidadTotalDeDispositivosApagados(), "No coincide cantidad." );

    }

    @Test
    public void soloDeberiaHaberUnDispositivoEncendidoTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        cliente.getDomicilios().get(1).getDispositivosInteligentes().get(0).encenderDispositivo();

        assertEquals( 1, cliente.cantidadTotalDeDispositivosEncendidos(), "No coincide cantidad." );

    }

    @Test
    public void noDeberiaHaberDispositivosEncendidosEnCualquierDomicilioTest(){

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        cliente.getDomicilios().get(1).getDispositivosInteligentes().get(0).encenderDispositivo();

        assertFalse( cliente.hayAlgunDispositivoEncendidoEnAlgunDomicilio(),"Error.");

    }

}
