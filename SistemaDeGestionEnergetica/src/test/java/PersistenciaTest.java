import json.JsonUtils;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;
import utilidades.DatabaseUtil;

import java.util.List;

public class PersistenciaTest {

    final static String clientesCompletos = "src/main/resources/json/clientes.json";

    final static String clientesLogin = "src/main/resources/json/clientes_login.json";

    final static String adminLogin = "src/main/resources/json/administradores_login.json";

    @Test
    public void persistirLoginAdminTest(){

        List<Administrador> administradores = JsonUtils.obtenerAdmins(adminLogin);

        for (Administrador administrador: administradores) {
            DatabaseUtil.persistir(administrador);
        }

    }

    @Test
    public void persistirLoginClientesTest(){

        List<Cliente> clientes = JsonUtils.obtenerClientes(clientesLogin);

        for(Cliente cliente: clientes){
            DatabaseUtil.persistir(cliente);
        }
    }
}
