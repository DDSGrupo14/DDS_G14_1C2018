import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.estados.Encendido;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.CondicionMagnitudCalculable;
import modelos.reglas.condiciones.Operador;
import modelos.reglas.reglas.ReglaParaApagar;
import modelos.reglas.sensores.SensorTemperatura;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SensorAdaptadorTest {

    static DispositivoInteligente dispositivoInteligente;
    static AdaptadorAire adaptadorAire;
    static DispositivoEstandar aire;
    static SensorTemperatura sensorTemperatura;
    static Actuador actuador;
    static ReglaParaApagar regla;
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
        dispositivoInteligente.setEstado(new Encendido(dispositivoInteligente));

        actuador = new Actuador();
        actuador.setDispositivoInteligente(dispositivoInteligente);
        sensorTemperatura= new SensorTemperatura();
        regla = new ReglaParaApagar();
        condicion = new CondicionMagnitudCalculable(Operador.MENOR.getValue(),25);
        regla.agregarCondicion(condicion);
        regla.setActuador(actuador);
        sensorTemperatura.setCondicion(condicion);
        condicion.setRegla(regla);
    }

    @Test
    public void dispositivoDeberiaApagarsePorLaRegla(){

        sensorTemperatura.medirMagnitud(24);

        assertFalse(dispositivoInteligente.getEstado().estasEncendido());
    }
}
