
import modelos.dao.*;
import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.estados.EstadoConcreto;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.CondicionMagnitudCalculable;
import modelos.reglas.condiciones.Operador;
import modelos.reglas.reglas.ReglaParaEncender;
import modelos.reglas.sensores.Sensor;
import modelos.reglas.sensores.SensorTemperatura;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.Test;
import utilidades.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaPersistenciaTest {

    public static void cargarCliente(){

        Cliente cliente = new Cliente("Nuevo","Nuevo"
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
        DispositivoInteligente dispositivoInteligente = new DispositivoInteligente();
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

    public static void cargarActuador(){

        Actuador actuador = new Actuador();

        actuador.setNombre("Actuador1");

        ReglaParaEncender regla = new ReglaParaEncender();

        CondicionMagnitudCalculable condicion = new CondicionMagnitudCalculable(Operador.MAYOR, 30);

        SensorTemperatura sensor = new SensorTemperatura();

        sensor.setNombre("Sensor1");
        DatabaseUtil.persistir(sensor);
        condicion.setSensor(sensor);

        regla.agregarCondicion(condicion);

        actuador.setRegla(regla);

        DatabaseUtil.persistir(actuador);
    }

    @Test
    public void casoPrueba1Test(){

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente1 = clienteDAO.obtenerClientePorUsername("nuevo");

        if(cliente1 == null)
            cargarCliente();

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
    public void casoPrueba2Parte1Test(){

        final String NUEVONOMBRE = "AireNuevo";

        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();
        ConsumoDispositivoDAO consumoDispositivoDAO = new ConsumoDispositivoDAO();
        DispositivoInteligente dispositivoInteligente1 =
                dispositivoInteligenteDAO.getDispositivoInteligente(NUEVONOMBRE);

        if( dispositivoInteligente1 == null){
            cargarDispositivo();
            dispositivoInteligente1 =
                    dispositivoInteligenteDAO.getDispositivoInteligente(NUEVONOMBRE);
        }
        dispositivoInteligente1.iniciarDispositivoInteligente();
        dispositivoInteligente1.encenderDispositivo();
        dispositivoInteligente1.apagarDispositivo();

        List<ConsumoDispositivo> consumos = consumoDispositivoDAO.consumoUltimoMes(dispositivoInteligente1);

        consumos.forEach(consumoDispositivo -> System.out.println(
                EstadoConcreto.obtenerEstadoConcreto(consumoDispositivo.getEstadoDispositivo()).toString()
        ));
    }

    @Test
    public void casoPrube2Parte2Test(){

        final String NOMBREVIEJO = "AireNuevo";

        final String CAMBIONOMBRE = "NombreCambiado";

        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();

        DispositivoInteligente dispositivoInteligente =
                dispositivoInteligenteDAO.getDispositivoInteligente(NOMBREVIEJO);

        System.out.println(dispositivoInteligente.getEstado().toString());

        dispositivoInteligente.setNombre(CAMBIONOMBRE);

        DatabaseUtil.actualizar(dispositivoInteligente);

        DispositivoInteligente dipActualizado =
                dispositivoInteligenteDAO.getDispositivoInteligente(CAMBIONOMBRE);

        assertEquals(CAMBIONOMBRE, dipActualizado.getNombre());
    }

    @Test
    public void casoPrueba3Parte1Test(){

        final String NOMBREACTUADOR = "Actuador1";

        ActuadorDAO actuadorDAO = new ActuadorDAO();

        Actuador actuador = actuadorDAO.getActuador(NOMBREACTUADOR);

        if(actuador == null){
            cargarActuador();
            actuador = actuadorDAO.getActuador(NOMBREACTUADOR);
        }

        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();
        DispositivoInteligente dispositivoInteligente1 =
                dispositivoInteligenteDAO.getDispositivoInteligente("NombreCambiado");

        if( dispositivoInteligente1 == null) {
            cargarDispositivo();
            dispositivoInteligente1 =
                    dispositivoInteligenteDAO.getDispositivoInteligente("NombreCambiado");
        }

        if(actuador.getDispositivoInteligente() == null)
            actuador.setDispositivoInteligente(dispositivoInteligente1);

        DatabaseUtil.actualizar(dispositivoInteligente1);

        if( dispositivoInteligente1.getUltimoEstado() != EstadoConcreto.APAGADO.getValue())
            dispositivoInteligente1.apagarDispositivo();

        SensorDAO sensorDAO = new SensorDAO();

        SensorTemperatura sensor = (SensorTemperatura) sensorDAO.getSenor("Sensor1");

        sensor.medirMagnitud(55);

        assertEquals(NOMBREACTUADOR,actuador.getNombre());

        assertEquals(EstadoConcreto.ENCENDIDO.getValue(),dispositivoInteligente1.getUltimoEstado());

    }
}
