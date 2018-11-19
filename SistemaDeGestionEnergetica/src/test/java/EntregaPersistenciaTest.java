
import dao.*;
import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.enre.Transformador;
import modelos.estados.EstadoConcreto;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.CondicionMagnitudCalculable;
import modelos.reglas.condiciones.Operador;
import modelos.reglas.reglas.ReglaParaEncender;
import modelos.reglas.sensores.SensorTemperatura;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.Test;
import servicios.DispositivoInteligenteService;
import servicios.DomicilioService;
import servicios.TransformadorService;
import utilidades.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EntregaPersistenciaTest {

    public static void cargarCliente(){

        Cliente cliente = new Cliente("Nuevo","Nuevo"
                ,"12345678","55554444","nuevo","nuevo");

        Domicilio domicilio = new Domicilio("nuevaDir",true,LocalDateTime.now());
        domicilio.setLongitud(-58.479000);
        domicilio.setLatitud(-34.670000);
        cliente.agregarDomicilio(domicilio);

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

        if(cliente1 == null) {
            cargarCliente();
            cliente1 = clienteDAO.obtenerClientePorUsername("nuevo");
        }
        Domicilio principal = cliente1.getPrincipal();

        final double LATITUD = -34.671843;
        final double LONGITUD = -58.482608;

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
        dispositivoInteligente1.pasarAhorroEnergia();
        dispositivoInteligente1.apagarDispositivo();

        List<ConsumoDispositivo> consumos = consumoDispositivoDAO.getConsumoUltimoMes(dispositivoInteligente1);

        consumos.forEach(consumoDispositivo -> System.out.println(
                EstadoConcreto.getEstadoConcreto(consumoDispositivo.getEstadoDispositivo()).toString()
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

        SensorTemperatura sensor = (SensorTemperatura) sensorDAO.getSensor("Sensor1");

        sensor.medirMagnitud(55);

        assertEquals(NOMBREACTUADOR,actuador.getNombre());

        assertEquals(EstadoConcreto.ENCENDIDO.getValue(),dispositivoInteligente1.getUltimoEstado());

    }

    @Test
    public void casoPrueba3Parte2Test(){

        final String NOMBREACTUADOR = "Actuador1";

        SensorDAO sensorDAO = new SensorDAO();
        SensorTemperatura sensor = (SensorTemperatura) sensorDAO.getSensor("Sensor1");

        DispositivoInteligenteDAO dispositivoInteligenteDAO = new DispositivoInteligenteDAO();
        DispositivoInteligente dispositivoInteligente1 =
                dispositivoInteligenteDAO.getDispositivoInteligente("NombreCambiado");

        if( dispositivoInteligente1.getUltimoEstado() != EstadoConcreto.APAGADO.getValue())
            dispositivoInteligente1.apagarDispositivo();

        CondicionMagnitudCalculable condi = (CondicionMagnitudCalculable) sensor.getCondicion();

        condi.setLimite(60);

        DatabaseUtil.actualizar(condi);

        sensor = (SensorTemperatura) sensorDAO.getSensor("Sensor1");

        sensor.medirMagnitud(55);

        assertNotEquals(EstadoConcreto.ENCENDIDO.getValue(),dispositivoInteligente1.getUltimoEstado());
    }

    @Test
    public void casoPrueba4Test(){

        TransformadorDAO transformadorDAO = new TransformadorDAO();

        List<Transformador> lista = transformadorDAO.getAllTransformadores();

        System.out.println(lista.size());
    }

    @Test
    public void consumoTest(){

        DomicilioDAO domicilioDAO = new DomicilioDAO();

        Domicilio domicilio = domicilioDAO.getDomicilio(1);

        DispositivoInteligente disp = domicilio.getDispositivosInteligentes().get(0);

        disp.encenderDispositivo();
        disp.pasarAhorroEnergia();
        disp.apagarDispositivo();

    }

    @Test
    public void casoPrueba5Parte1Test(){

        DomicilioService domicilioService = new DomicilioService();

        BigDecimal consumo = domicilioService.getConsumoTotalDomicilioPeriodo(1,
                LocalDateTime.of(LocalDate.of(2018,01,19), LocalTime.now()),
                LocalDateTime.now());

        System.out.println(consumo);
    }

    @Test
    public void casoPrueba5Parte2Test(){

        DispositivoInteligenteService dispService = new DispositivoInteligenteService();

        BigDecimal consumoPromedio = dispService.getConsumoPromedioPeriodo("aire1",
                LocalDateTime.of(LocalDate.of(2018,01,19), LocalTime.now()),
                LocalDateTime.now());

        System.out.println(consumoPromedio);
    }

    @Test
    public void casoPrueba5Parte3Test(){

        TransformadorService transformadorService = new TransformadorService();

        BigDecimal consumopromedio = transformadorService.getConsumoPromedioPeriodo("transformador1",
                LocalDateTime.of(LocalDate.of(2018,01,19), LocalTime.now()),
                LocalDateTime.now());

        System.out.println(consumopromedio);
    }

}
