package parser;

import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
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
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ParserJsonToJsonTest {

    @Test
    public void crearUsuarioTest() {

        final Categoria categoria01 = new Categoria( 1 );

        RandomDate generadorFecha = new RandomDate();

        LocalDate fecha1 = generadorFecha.createRandomDate(2000, 2010);
        
        final Cliente cliente = new Cliente("Pepe", "Garcia", "1234",
                "1512312312", "admin", "admin");

        final DispositivoEstandar lampara = new DispositivoEstandar("lampara", new BigDecimal( 60));

        final DispositivoEstandar reloj = new DispositivoEstandar( "reloj",new BigDecimal( 15 ));

        final AdaptadorEstandar adaptadorLampara =
                new AdaptadorEstandar(new BigDecimal( 300 ), "AdaptadorLampara");

        adaptadorLampara.setDispositivoEstandar(lampara);

        TipoDispositivo lamparaAlogena40 = new TipoDispositivo("Lampara40"
                ,90,360,new BigDecimal(0.04));

        final DispositivoInteligente lamparaAdaptada = new DispositivoInteligente( lamparaAlogena40
                ,"Lampara",60.0 );

        lamparaAdaptada.setAdaptador(adaptadorLampara);

        final AdaptadorAire adaptadorAire = new AdaptadorAire(new BigDecimal( 500 ), "Aire");

        TipoDispositivo aire3500 = new TipoDispositivo("Aire3500"
                ,90,360,new BigDecimal(1.613));

        final DispositivoInteligente aire = new DispositivoInteligente(aire3500,"Aire",50.0 );

        aire.setAdaptador(adaptadorAire);

        final Domicilio domicilio01 = new Domicilio("congreso-2288", true, categoria01, LocalDateTime.now().toString());

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
