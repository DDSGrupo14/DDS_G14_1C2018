package parser;

import json.CargarClientesDesdeJson;
import modelos.dispositivos.DispositivoInteligente;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserJsonFromJsonTest {

    final static CargarClientesDesdeJson cargarClientes = new CargarClientesDesdeJson();

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
        System.out.println("Tamaño lista: " + clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes().size());
        for(DispositivoInteligente dispositivoInteligente: clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes()){
            System.out.println(dispositivoInteligente.getAdaptador().getDispositivoEstandar().getNombre());
        }
    }

    @Test
    public void deberianExistirSoloTresDispositivosTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        final int CANTIDAD_DISPOSITIVOS_ESPERADA = 3;

        assertEquals( CANTIDAD_DISPOSITIVOS_ESPERADA
                , cliente.cantidadTotalDeDispositivos(), "No coincide cantidad." );

    }

    @Test
    public void deberiaDeHaberTresDispositivosApagadosTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        final int CANTIDAD_DISPOSITIVOS_APAGADOS_ESPERADA = 2;

        assertEquals( CANTIDAD_DISPOSITIVOS_APAGADOS_ESPERADA
                , cliente.cantidadTotalDeDispositivosApagados(), "No coincide cantidad." );

    }

    @Test
    public void soloDeberiaHaberUnDispositivoEncendidoTest() {

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        final int PRIMER_DOMICILIO = 0;

        final int POSICION_DISPOSITIVO = 0;

        final DispositivoInteligente dispositivoInteligente = cliente.getDomicilios().get(PRIMER_DOMICILIO)
                .getDispositivosInteligentes().get(POSICION_DISPOSITIVO);

        dispositivoInteligente.encenderDispositivo();

        System.out.println(dispositivoInteligente.getNombre());

        assertEquals( 1, cliente.cantidadTotalDeDispositivosEncendidos(), "No coincide cantidad." );

    }

    @Test
    public void noDeberiaHaberDispositivosEncendidosEnCualquierDomicilioTest(){

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        final int PRIMER_DOMICILIO = 0;

        cliente.getDomicilios().get(PRIMER_DOMICILIO).getDispositivosInteligentes().get(0).encenderDispositivo();

        assertFalse( !cliente.hayAlgunDispositivoEncendidoEnAlgunDomicilio(),"Error.");

    }

    @Test
    public void nombreLamparaTest(){

        List<Cliente> clientes = obtenerClientes();

        Cliente cliente = clientes.get(0);

        final int POSICION_DISPOSITIVO = 0;

        final DispositivoInteligente dispositivoInteligente = cliente.getDomicilios().get(POSICION_DISPOSITIVO)
                .getDispositivosInteligentes().get(POSICION_DISPOSITIVO);

        assertNotEquals( "lampara",dispositivoInteligente.getNombre());
        assertNotEquals( "adaptadorLampara",dispositivoInteligente.getNombre());

    }

}
