package parser;

import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;
import modelos.enre.Transformador;
import modelos.enre.Zona;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.Test;
import utilidades.Path;
import utilidades.RandomDate;

import java.beans.Transient;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserJsonToJsonTest {

    @Test
    public void crearUsuariosCompletosTest() {

      /*  final String PATH = "src/main/resources/json/clientes.json";

        final Categoria categoria01 = new Categoria( "R1",new BigDecimal(2.3),new BigDecimal(3.2) );

        RandomDate generadorFecha = new RandomDate();

        LocalDateTime fecha1 = generadorFecha.createRandomDate(2000, 2010);
        
        final Cliente cliente = new Cliente("Pepe", "Garcia", "1234",
                "1512312312", "completo1", "completo");

        final DispositivoEstandar lampara = new DispositivoEstandar("lampara", new BigDecimal( 60));

        final DispositivoEstandar reloj = new DispositivoEstandar( "reloj",new BigDecimal( 15 ));

        final AdaptadorEstandar adaptadorLampara =
                new AdaptadorEstandar(new BigDecimal( 300 ), "AdaptadorLampara");

        adaptadorLampara.setDispositivoEstandar(lampara);

        TipoDispositivo lamparaAlogena40 = new TipoDispositivo("Lampara40"
                ,90,360,new BigDecimal(0.04),true, false);

        final DispositivoInteligente lamparaAdaptada = new DispositivoInteligente( lamparaAlogena40
                ,"Lampara",60.0 );

        lamparaAdaptada.setAdaptador(adaptadorLampara);

        final DispositivoEstandar aireEstandar = new DispositivoEstandar("aireEstandar", new BigDecimal( 100));

        final AdaptadorAire adaptadorAire = new AdaptadorAire(new BigDecimal( 500 ), "Aire");

        adaptadorAire.setDispositivoEstandar(aireEstandar);

        TipoDispositivo aire3500 = new TipoDispositivo("Aire3500"
                ,90,360,new BigDecimal(1.613), true, false);

        final DispositivoInteligente aire = new DispositivoInteligente(aire3500,"Aire",50.0 );
        aire.setAdaptador(adaptadorAire);
        final Domicilio domicilio01 = new Domicilio("congreso-2288", true, LocalDateTime.now());

        domicilio01.agregarDispositivoEstandar(reloj).agregarDispositivoInteligente(lamparaAdaptada).agregarDispositivoInteligente(aire);

        cliente.agregarDomicilio(domicilio01, categoria01);

        List<Cliente> clientes = Arrays.asList( cliente );

        JsonUtils.crearArchivoJson(clientes, PATH);*/

    }

    @Test
    public void crearLoginClientesTest(){

        final String PATH = "src/main/resources/json/clientes_login.json";

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

        List<Cliente> clientes = Arrays.asList(cliente1,cliente2 );

        JsonUtils.crearArchivoJson(clientes, PATH);
    }

    @Test
    public void crearLoginAdministradoresTest(){

        final String PATH = "src/main/resources/json/administradores_login.json";

        final String nombre3 = "Juan";
        final String apellido3 = "Alvarez";
        final String documento3 = "15947833";
        final String telefono3 = "5555-3333";
        final String fechaAlta1 = "10/05/2018";
        final String login_usuario3 = "admin";
        final String password3 = "admin";

        final Administrador administrador =
                new Administrador(nombre3,apellido3,documento3,telefono3,fechaAlta1,login_usuario3,password3);

        List<Administrador> administradores = Arrays.asList(administrador );

        JsonUtils.crearArchivoJson(administradores, PATH);

    }

    @Test
    public void crearEquiposConcretosTest(){

        final String PATH = "src/main/resources/json/tipos_concretos.json";

        final int AIRE = 0, LAMPARA = 1, TELEVISOR = 2, LAVARROPA = 3, PC = 4, MICROONDA = 5
                , PLANCHA = 6, VENTILADOR = 7, HELADERA = 8;

        final int minimos[] = { 90, 90, 90, 6, 60, 3, 3, 120, 120 };

        final int maximos[] = { 360, 360, 360, 30, 360, 15, 30, 360, 360 };

        final TipoDispositivo aire1 = new TipoDispositivo("Aire3500Frigorias",minimos[AIRE],
                maximos[AIRE],new BigDecimal(1.613),true,false);

        final TipoDispositivo aire2 = new TipoDispositivo("Aire2200Frigorias",minimos[AIRE],
                maximos[AIRE],new BigDecimal(1.013),true,true);

        final TipoDispositivo tele1 = new TipoDispositivo("TeleTuvo21", minimos[TELEVISOR], maximos[TELEVISOR]
            , new BigDecimal(0.075), false, false);

        final TipoDispositivo tele2 = new TipoDispositivo("TeleTuvo29a34", minimos[TELEVISOR], maximos[TELEVISOR]
                , new BigDecimal(0.175), false, false);

        final TipoDispositivo tele3 = new TipoDispositivo("LCD40", minimos[TELEVISOR], maximos[TELEVISOR]
                , new BigDecimal(0.18), false, false);

        final TipoDispositivo tele4 = new TipoDispositivo("LED24", minimos[TELEVISOR], maximos[TELEVISOR]
                , new BigDecimal(0.04), true, true);

        final TipoDispositivo tele5 = new TipoDispositivo("LED32", minimos[TELEVISOR], maximos[TELEVISOR]
                , new BigDecimal(0.055), true, true);

        final TipoDispositivo tele6 = new TipoDispositivo("LED40", minimos[TELEVISOR], maximos[TELEVISOR]
                , new BigDecimal(0.08), true, true);

        final TipoDispositivo heladera1 = new TipoDispositivo("HeladeraConFreezer", minimos[HELADERA]
                , maximos[HELADERA], new BigDecimal(0.09), true, true);

        final TipoDispositivo heladera2 = new TipoDispositivo("HeladeraSinFreezer", minimos[HELADERA]
                , maximos[HELADERA], new BigDecimal(0.075), true, true);

        final TipoDispositivo lavaropa1 = new TipoDispositivo("Lavaropa5kgAutoCaliente", minimos[HELADERA]
                , maximos[HELADERA], new BigDecimal(0.175), false, false);

        final TipoDispositivo lavaropa2 = new TipoDispositivo("5kgAuto", minimos[HELADERA]
                , maximos[HELADERA], new BigDecimal(0.075), true, true);

        final TipoDispositivo lavaropa3 = new TipoDispositivo("5kgSemiAuto", minimos[HELADERA]
                , maximos[HELADERA], new BigDecimal(0.1275), false, true);

        final TipoDispositivo ventilador1 = new TipoDispositivo("ventiladorDePie", minimos[VENTILADOR]
                , maximos[VENTILADOR], new BigDecimal(0.09), false, true);

        final TipoDispositivo ventilador2 = new TipoDispositivo("ventiladorDeTecho", minimos[VENTILADOR]
                , maximos[VENTILADOR], new BigDecimal(0.06), true, true);

        final TipoDispositivo lampara1 = new TipoDispositivo("LamparaHalogena40W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.04), true, false);

        final TipoDispositivo lampara2 = new TipoDispositivo("LamparaHalogena60W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.06), true, false);

        final TipoDispositivo lampara3 = new TipoDispositivo("LamparaHalogena100W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.0015), true, false);

        final TipoDispositivo lampara4 = new TipoDispositivo("Lampara11W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.011), true, true);

        final TipoDispositivo lampara5 = new TipoDispositivo("Lampara15W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.015), true, true);

        final TipoDispositivo lampara6 = new TipoDispositivo("Lampara20W", minimos[LAMPARA]
                , maximos[LAMPARA], new BigDecimal(0.02), true, true);

        final TipoDispositivo pc1 = new TipoDispositivo("PCEscritorio", minimos[PC]
                , maximos[PC], new BigDecimal(0.4), true, true);

        final TipoDispositivo microondas1 = new TipoDispositivo("MicroondaConvencional", minimos[MICROONDA]
                , maximos[MICROONDA], new BigDecimal(0.64), false, true);

        final TipoDispositivo plancha1 = new TipoDispositivo("PlanchaVapor", minimos[PLANCHA]
                , maximos[PLANCHA], new BigDecimal(0.75), false, true);

        List<TipoDispositivo> tipos = Arrays.asList(aire1, aire2, tele1, tele2, tele3, tele4, tele5, tele6,
                heladera1, heladera2, lavaropa1, lavaropa2, lavaropa3, ventilador1, ventilador2, lampara1,
                lampara2, lampara3, lampara4, lampara5, lampara6, pc1, microondas1, plancha1);

        JsonUtils.crearArchivoJson(tipos, PATH);
    }

    @Test
    public void crearCategoriasTest(){

        int i = 0;
        final double cargosFijos[] = {18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19};
        final double cargosVariables[] = {0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851};
        List<Categoria> categorias = new ArrayList<>();

        while( i < 9){
            categorias.add(new Categoria(String.format("R%d", i+1),
                    new BigDecimal(cargosFijos[i]), new BigDecimal(cargosVariables[i])));
            i++;
        }

        JsonUtils.crearArchivoJson(categorias, Path.Archivos.CATEGORIAS);
    }

    @Test
    public void crearZonas(){

        final String direccion1 = "direccion1";
        final String direccion2 = "direccion2";
        final String direccion3 = "direccion3";
        final String direccion4 = "direccion4";
        final String direccion5 = "direccion5";
        final String direccion6 = "direccion6";

        List<String> direcciones1 = Arrays.asList(direccion1,direccion2);
        final double latitud1= -34.670177;
        final double longitud1= -58.479916;
        final String trans_codigo1 = "transformador1";
        Transformador transformador1 = new Transformador(true,latitud1,longitud1,trans_codigo1, direcciones1);

        List<String> direcciones2 = Arrays.asList(direccion3,direccion4);
        final double latitud2= -34.665116;
        final double longitud2= -58.489735;
        final String trans_codigo2 = "transformador2";
        Transformador transformador2 = new Transformador(true,latitud2,longitud2, trans_codigo2, direcciones2);

        List<String> direcciones3 = Arrays.asList(direccion5);
        final double latitud3= -34.657089;
        final double longitud3= -58.501854;
        final String trans_codigo3 = "transformador3";
        Transformador transformador3 = new Transformador(true,latitud3,longitud3, trans_codigo3, direcciones3);

        List<String> direcciones4 = Arrays.asList(direccion6);
        final double latitud4= -34.662878;
        final double longitud4= -58.505802;
        final String trans_codigo4 = "transformador4";
        Transformador transformador4 = new Transformador(true,latitud4,longitud4, trans_codigo4, direcciones4);

        final double latitudZona1 = -34.672627;
        final double longitudZona1 = -58.47698;
        final int radio1 = 1000;
        final String codigo1 = "ZONA1";
        List<Transformador> transformadores1 = Arrays.asList(transformador1, transformador2);
        Zona zona1 = new Zona(codigo1,latitudZona1, longitudZona1, radio1,transformadores1);

        final double latitudZona2 = -34.657795;
        final double longitudZona2 = -58.500996;
        final int radio2 = 1000;
        final String codigo2 = "ZONA2";
        List<Transformador> transformadores2 = Arrays.asList(transformador3, transformador4);
        Zona zona2 = new Zona(codigo2,latitudZona2, longitudZona2, radio2,transformadores2);

        JsonUtils.crearArchivoJson(Arrays.asList(zona1,zona2), Path.Archivos.ZONA);
    }
}
