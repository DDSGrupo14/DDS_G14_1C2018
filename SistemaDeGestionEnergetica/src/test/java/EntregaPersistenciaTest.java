
import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilidades.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaPersistenciaTest {

    private static Cliente cliente = null;

    private static DispositivoInteligente dispositivoInteligente = null;

    public static void cargarCliente(){

        cliente = new Cliente("Nuevo","Nuevo"
                ,"12345678","55554444","nuevo","nuevo");

        Domicilio domicilio = new Domicilio();
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        domicilio.setDireccion("nuevaDir");
        domicilio.setPrincipal(true);
        domicilio.setFechaAltaEnSistema(LocalDate.now().toString());
        domicilio.setLongitud(-58.479000);
        domicilio.setLatitud(-34.670000);
        cliente.agregarDomicilio(domicilio,domicilioDAO.obtenerCategoriaPorNombre("R1"));

        DatabaseUtil.persistir(cliente);
    }

    public static void cargarDispositivo(){

        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();
        dispositivoInteligente = new DispositivoInteligente();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente2 = clienteDAO.obtenerClientePorUsername("nuevo");
        Domicilio principal = cliente2.getPrincipal();
        dispositivoInteligente.setNombre("AireNuevo");
        dispositivoInteligente.setPorcentajeAhorroEnergia(50.0);
        dispositivoInteligente.setTipoDispositivo(dispositivoInteligenteDAO
                .getTipoDispositivo("Aire2200Frigorias"));
        dispositivoInteligente.setDomicilio(principal);
        dispositivoInteligente.iniciarDispositivoInteligente();
        DatabaseUtil.persistir(dispositivoInteligente);
    }

    @Test
    public void casoPrueba1Test(){

        if(cliente == null)
            cargarCliente();

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente1 = clienteDAO.obtenerClientePorUsername("nuevo");

        Domicilio principal = cliente1.getPrincipal();

        final double LATITUD = -36.670000;
        final double LONGITUD = -58.479000;

        principal.setLongitud(LONGITUD);
        principal.setLatitud(LATITUD);

        DatabaseUtil.actualizar(principal);

        Cliente cliente2 = clienteDAO.obtenerClientePorUsername("nuevo");

        Domicilio principal1 = cliente2.getPrincipal();

        assertEquals(LONGITUD+LATITUD,principal1.getLatitud()+principal1.getLongitud());
    }

    @Test
    public void casoPrueba2Test(){

        final String NUEVONOMBRE = "NombreLoco";

      //  if(dispositivoInteligente == null)
   //         cargarDispositivo();
        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();
        ConsumoDispositivoDAO consumoDispositivoDAO = new ConsumoDispositivoDAO();
        DispositivoInteligente dispositivoInteligente1 =
                dispositivoInteligenteDAO.getDispositivoInteligente("AireNuevo");

        dispositivoInteligente1.encenderDispositivo();
        dispositivoInteligente1.apagarDispositivo();

        List<ConsumoDispositivo> consumos = consumoDispositivoDAO.consumoUltimoMes(dispositivoInteligente1);

        consumos.forEach(consumoDispositivo -> System.out.println(consumoDispositivo.getEstadoDispositivo()));
    }
}
