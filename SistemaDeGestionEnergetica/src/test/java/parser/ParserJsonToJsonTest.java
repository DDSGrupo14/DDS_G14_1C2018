package parser;

import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.Test;
import utilidades.RandomDate;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ParserJsonToJsonTest {

    @Test
    public void crearUsuarioTest() {

        List<Double> cargosFijos = Arrays.asList( 18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19 );

        List<Double> cargosVariables = Arrays.asList( 0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851 );

        final Categoria categoria01 = new Categoria( cargosFijos, cargosVariables, 1 );

        RandomDate generadorFecha = new RandomDate();

        LocalDate fecha1 = generadorFecha.createRandomDate(2000, 2010);

        final Cliente cliente = new Cliente("Pepe", "Garcia", "1234",
                "1512312312");

        final DispositivoEstandar lampara = new DispositivoEstandar( new BigDecimal( 60), "lampara");

        final DispositivoEstandar reloj = new DispositivoEstandar( new BigDecimal( 15 ), "reloj");

        final AdaptadorEstandar adaptadorLampara = new AdaptadorEstandar(new BigDecimal( 300 ), "AdaptadorLampara", lampara);

        final DispositivoInteligente lamparaAdaptada = new DispositivoInteligente(adaptadorLampara, 50.0 );

        final AdaptadorAire adaptadorAire = new AdaptadorAire(new BigDecimal( 500 ), "Aire");

        final DispositivoInteligente aire = new DispositivoInteligente( adaptadorAire, 50.0 );

        final Domicilio domicilio01 = new Domicilio("congreso-2288", true, categoria01);

        domicilio01.agregarDispositivoEstandar(reloj).agregarDispositivoInteligente(lamparaAdaptada).agregarDispositivoInteligente(aire);

        cliente.agregarDomicilio(domicilio01);

        JsonUtils jsonUtils = new JsonUtils();

        List<Cliente> clientes = Arrays.asList( cliente );

        String json = jsonUtils.toJson( clientes );

        try {

            FileWriter fileWriter = new FileWriter("src/main/resources/json/clientes.json");
            fileWriter.write( json );
            fileWriter.close();

        } catch ( IOException e) {

            e.printStackTrace();
        }

    }
}
