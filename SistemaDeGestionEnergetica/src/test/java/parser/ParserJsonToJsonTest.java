package parser;

import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;
import modelos.usuarios.Administrador;
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
    public void crearUsuariosCompletosTest() {

        final Categoria categoria01 = new Categoria( 1,new BigDecimal(2.3),new BigDecimal(3.2) );

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

        final DispositivoEstandar aireEstandar = new DispositivoEstandar("aireEstandar", new BigDecimal( 100));


        final AdaptadorAire adaptadorAire = new AdaptadorAire(new BigDecimal( 500 ), "Aire");

        adaptadorAire.setDispositivoEstandar(aireEstandar);

        TipoDispositivo aire3500 = new TipoDispositivo("Aire3500"
                ,90,360,new BigDecimal(1.613));

        final DispositivoInteligente aire = new DispositivoInteligente(aire3500,"Aire",50.0 );

        aire.setAdaptador(adaptadorAire);

        final Domicilio domicilio01 = new Domicilio("congreso-2288", true, LocalDateTime.now().toString());

        domicilio01.agregarDispositivoEstandar(reloj).agregarDispositivoInteligente(lamparaAdaptada).agregarDispositivoInteligente(aire);

        cliente.agregarDomicilio(domicilio01, categoria01);

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

    @Test
    public void crearUsuariosTest(){

        final String nombre1 = "Tomas";
        final String apellido1 = "Fernandez";
        final String documento1 = "12345678";
        final String telefono1 = "5555-5555";
        final String login_usuario1 = "cliente1";
        final String password1 = "123456";

        final String nombre2 = "Fernando";
        final String apellido2 = "Juarez";
        final String documento2 = "12342499";
        final String telefono2 = "5555-4444";
        final String login_usuario2 = "cliente2";
        final String password2 = "111111";


        final Cliente cliente1 = new Cliente(nombre1,apellido1,documento1,telefono1,login_usuario1,password1);

        final Cliente cliente2 = new Cliente(nombre2,apellido2,documento2,telefono2,login_usuario2,password2);

        JsonUtils jsonUtils = new JsonUtils();

        List<Cliente> clientes = Arrays.asList(cliente1,cliente2 );

        String json = jsonUtils.toJson( clientes );

        try {

            FileWriter fileWriter = new FileWriter("src/main/resources/json/clientes_login.json");
            fileWriter.write( json );
            fileWriter.close();

        } catch ( IOException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void crearAdministradoresTest(){


        final String nombre3 = "Juan";
        final String apellido3 = "Alvarez";
        final String documento3 = "15947833";
        final String telefono3 = "5555-3333";
        final String fechaAlta1 = "10/05/2018";
        final String login_usuario3 = "admin";
        final String password3 = "admin";


        final Administrador administrador =
                new Administrador(nombre3,apellido3,documento3,telefono3,fechaAlta1,login_usuario3,password3);

        JsonUtils jsonUtils = new JsonUtils();

        List<Administrador> administradores = Arrays.asList(administrador );

        String json = jsonUtils.toJson( administradores );

        try {

            FileWriter fileWriter = new FileWriter("src/main/resources/json/administradores_login.json");
            fileWriter.write( json );
            fileWriter.close();

        } catch ( IOException e) {

            e.printStackTrace();
        }
    }
}
