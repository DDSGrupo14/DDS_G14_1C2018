import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.estados.Apagado;
import modelos.estados.Encendido;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.CondicionMagnitudCalculable;
import modelos.reglas.condiciones.Operador;
import modelos.reglas.reglas.ApagarSegunTemperatura;
import modelos.reglas.sensores.Magnitud;
import modelos.reglas.sensores.SensorTemperatura;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SensorAdaptadorTest {

    static DispositivoInteligente dispositivoInteligente;
    static AdaptadorAire adaptadorAire;
    static DispositivoEstandar aire;
    static SensorTemperatura sensorTemperatura;
    static Actuador actuador;
    static ApagarSegunTemperatura regla;
    static CondicionMagnitudCalculable condicion;

    final static String NOMBRE = "hola";
    final static int CANTHORAS = 1;
    final static BigDecimal KWCONSUMIDO = new BigDecimal(120);

    @BeforeAll
    public static void setupMock(){
        aire = new DispositivoEstandar();
        aire.setNombre("aire1");

        adaptadorAire = new AdaptadorAire();
        adaptadorAire.setNombreAdaptador("adaptadorAire1");

        dispositivoInteligente = new DispositivoInteligente();
        dispositivoInteligente.setAdaptador(adaptadorAire);
        dispositivoInteligente.setConsumoActual(KWCONSUMIDO);
        dispositivoInteligente.setEstado(new Encendido());

        actuador = new Actuador();
        actuador.setDispositivoInteligente(dispositivoInteligente);
        sensorTemperatura= new SensorTemperatura();
        regla = new ApagarSegunTemperatura();
        condicion = new CondicionMagnitudCalculable(Operador.MENOR.getValue(),100);
        regla.agregarCondicion(condicion);
        regla.setActuador(actuador);
        sensorTemperatura.agregarRegla(regla);
    }

    @Test
    public void dispositivoDeberiaApagarsePorLaRegla(){

        sensorTemperatura.medirMagnitud(Magnitud.TEMPERATURA,150);

        assertFalse(dispositivoInteligente.getEstado().estasEncendido());
    }
}
