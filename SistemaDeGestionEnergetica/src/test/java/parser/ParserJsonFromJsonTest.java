package parser;

import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;

import static json.JsonUtils.obtenerAdmins;
import static json.JsonUtils.obtenerClientes;
import static json.JsonUtils.obtenerTiposConcretos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class ParserJsonFromJsonTest {


    final static String clientesCompletos = "src/main/resources/json/clientes.json";

    final static String clientesLogin = "src/main/resources/json/clientes_login.json";

    final static String adminLogin = "src/main/resources/json/administradores_login.json";

    final static String tiposConcretos = "src/main/resources/json/tipos_concretos.json";

    @Test
    public void cargarClientesDesdeJsonTest() {

        List<Cliente> clientes = obtenerClientes(clientesCompletos);

        assertEquals(1,clientes.size(), "No coincide.");
        System.out.println("Tamaño lista: " + clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes().size());
        for(DispositivoInteligente dispositivoInteligente: clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes()){
            System.out.println(dispositivoInteligente.getAdaptador().getDispositivoEstandar().getNombre());
        }
    }

    @Test
    public void cargaAdmins(){

        List<Administrador> admins = obtenerAdmins(adminLogin);

        Administrador admin = admins.get(0);

        System.out.println(admin.toString());

        assertEquals(1,admins.size());
    }

    @Test
    public void cargarClientes(){

        List<Cliente> clientes = obtenerClientes(clientesLogin);

        Cliente cliente = clientes.get(0);

        System.out.println(cliente.toString());

        assertEquals(2,clientes.size());
    }

    @Test
    public void cargarTiposConcretos(){

        List<TipoDispositivo> tipos = obtenerTiposConcretos(tiposConcretos);

        System.out.println(tipos.get(4).toString());

        assertEquals(24, tipos.size());

    }
}
