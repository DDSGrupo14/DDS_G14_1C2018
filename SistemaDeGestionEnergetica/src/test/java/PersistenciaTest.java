import json.JsonUtils;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;
import utilidades.AdministradorDAO;
import utilidades.DatabaseUtil;
import utilidades.ClienteDAO;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void traerClientesDesdeBaseTest(){

        ClienteDAO userDao = new ClienteDAO();

        List<Cliente> clientes = userDao.listarClientes();

        System.out.println(clientes.get(0).toString());

        assertEquals(2,clientes.size());

    }

    @Test
    public void traerUnSoloClientePorUsernameTest(){

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = clienteDAO.obtenerClientePorUsername("cliente1");

        if( cliente == null ) {

            System.out.println("nulo");

            return;
        }

        System.out.println(cliente.toString());

        assertEquals(false, clienteDAO.getSession().isOpen());

    }

    @Test
    public void traerElAdministradorTest(){

        AdministradorDAO administradorDAO = new AdministradorDAO();

        Administrador administrador = administradorDAO.obtenerAdministradorPorUsername("admin");

        System.out.println(administrador.toString());

        assertEquals(false,administradorDAO.getSession().isOpen());
    }
}
