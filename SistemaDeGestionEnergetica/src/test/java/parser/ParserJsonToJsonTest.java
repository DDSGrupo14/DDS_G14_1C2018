package parser;
/*
import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoInteligente;
import modelos.usuarios.Domicilio;
import modelos.usuarios.Usuario;
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

        RandomDate generadorFecha = new RandomDate();

        LocalDate fecha1 = generadorFecha.createRandomDate(2000, 2010);

        final Usuario usuario = new Usuario("Pepe", "Garcia", "1234",
                "1512312312", fecha1.toString());

        final DispositivoInteligente dipositivo01 = new DispositivoInteligente( "AireAcondicionado", new BigDecimal( 500.36), false);

        final DispositivoInteligente dipositivo02 = new DispositivoInteligente( "ConsolaDeVideoJuegos", new BigDecimal( 200.1), false);

        final DispositivoInteligente dipositivo03 = new DispositivoInteligente( "Televisor", new BigDecimal( 150.3), false);

        final List<DispositivoInteligente> dispositivos01 = Arrays.asList( dipositivo01, dipositivo02);

        final List<DispositivoInteligente> dispositivos02 = Arrays.asList( dipositivo03 );

        final Categoria categoria01 = new Categoria( cargosFijos, cargosVariables, 1 );

        final Domicilio domicilio01 = new Domicilio("congreso-2288", true, categoria01, dispositivos01);

        final Categoria categoria02 = new Categoria( cargosFijos, cargosVariables, 5);

        final Domicilio domicilio02 = new Domicilio("tucuman-333", false, categoria02, dispositivos02);

        usuario.setDomicilios( Arrays.asList( domicilio01, domicilio02));

        JsonUtils jsonUtils = new JsonUtils();

        List<Usuario> usuarios = Arrays.asList( usuario );

        String json = jsonUtils.toJson( usuarios );

        try {

            FileWriter fileWriter = new FileWriter("src/main/resources/json/usuarios.json");
            fileWriter.write( json );
            fileWriter.close();

        } catch ( IOException e) {

            e.printStackTrace();
        }

    }
}
*/