import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;
import utilidades.AdministradorDAO;
import utilidades.ClienteDAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTest {


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

        if( administrador != null)
        System.out.println(administrador.toString());

        assertEquals(false,administradorDAO.getSession().isOpen());
    }
}
