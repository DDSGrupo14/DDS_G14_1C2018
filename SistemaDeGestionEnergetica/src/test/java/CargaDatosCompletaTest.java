import json.CargarClaseSimpleDesdeJson;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.enre.Zona;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import org.junit.jupiter.api.Test;
import utilidades.DatabaseUtil;
import utilidades.Path;
import utilidades.RandomDate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CargaDatosCompletaTest {

    @Test
    public void cargarTodoTest(){

        /*
        ------------------------ CARGA TIPOS DISPOSITIVOS ------------------------
         */
        CargarClaseSimpleDesdeJson<TipoDispositivo> cargaTipos =
                new CargarClaseSimpleDesdeJson<>(TipoDispositivo.class);

        List<TipoDispositivo> tipos = cargaTipos.obtenerListaClaseComun(Path.Archivos.TIPOS_CONCRETOS);

        tipos.forEach(tipo -> DatabaseUtil.persistir(tipo));

        /*
        ------------------------ CARGA TIPOS DISPOSITIVOS ------------------------
         */

        /*
        ------------------------ CARGA CATEGORIAS ------------------------
         */
        CargarClaseSimpleDesdeJson<Categoria> cargaCateogira =
                new CargarClaseSimpleDesdeJson<>(Categoria.class);

        List<Categoria> categorias = cargaCateogira.obtenerListaClaseComun(Path.Archivos.CATEGORIAS);

        categorias.forEach(categoria -> DatabaseUtil.persistir(categoria));
        /*
        ------------------------ CARGA CATEGORIAS ------------------------
         */

        /*
        ------------------------ CARGA CLIENTES ------------------------
         */

        final String nombre1 = "Tomas";
        final String apellido1 = "Fernandez";
        final String documento1 = "12345678";
        final String telefono1 = "5555-5555";
        final String login_usuario1 = "completo1";
        final String password1 = "completo";
        final String direccion1 = "direccion1";
        final double latitud1 = -35.55;
        final double longitud1 = -58.3;
        final LocalDateTime fechaAlta1 = RandomDate.createRandomDate(2015,2018);

        final String nombre2 = "Fernando";
        final String apellido2 = "Juarez";
        final String documento2 = "12342499";
        final String telefono2 = "5555-4444";
        final String login_usuario2 = "completo2";
        final String password2 = "completo";
        final String direccion2 = "direccion3";
        final double latitud2 = -35.55;
        final double longitud2 = -58.3;
        final LocalDateTime fechaAlta2 = RandomDate.createRandomDate(2015,2018);

        final Cliente cliente1 = new Cliente(nombre1,apellido1,documento1,telefono1,login_usuario1,password1);

        Domicilio domicilio1 = new Domicilio(direccion1,true, fechaAlta1);
        domicilio1.setLatitud(latitud1);
        domicilio1.setLongitud(longitud1);
        domicilio1.setCategoria(categorias.get(1));

        TipoDispositivo tipoPlancha = tipos.stream().filter(t -> t.getEquipoConcreto().equals("PlanchaVapor"))
                .findAny().orElse(null);
        DispositivoEstandar plancha1 = new DispositivoEstandar("plancha1",tipoPlancha);

        TipoDispositivo tipoAire1 = tipos.stream().filter( t -> t.getEquipoConcreto().equals("Aire2200Frigorias"))
                .findAny().orElse(null);
        DispositivoInteligente aire1 = new DispositivoInteligente(tipoAire1,"aire1",30.0);

        domicilio1.agregarDispositivoEstandar(plancha1);
        domicilio1.agregarDispositivoInteligente(aire1);

        cliente1.agregarDomicilio(domicilio1);

        final Cliente cliente2 = new Cliente(nombre2,apellido2,documento2,telefono2,login_usuario2,password2);

        Domicilio domicilio2 = new Domicilio(direccion2,true, fechaAlta2);
        domicilio2.setLatitud(latitud2);
        domicilio2.setLongitud(longitud2);
        domicilio2.setCategoria(categorias.get(2));

        TipoDispositivo tipoHeladera = tipos.stream().filter( t -> t.getEquipoConcreto().equals("HeladeraConFreezer"))
                .findAny().orElse(null);
        DispositivoInteligente heladera2 = new DispositivoInteligente(tipoAire1,"heladera2"
                ,50.0);

        domicilio2.agregarDispositivoInteligente(heladera2);

        cliente2.agregarDomicilio(domicilio2);

        List<Cliente> clientes = Arrays.asList(cliente1,cliente2 );

        clientes.forEach(cliente -> DatabaseUtil.persistir(cliente));

        /*
        ------------------------ CARGA CLIENTES ------------------------
         */

        /*
        ------------------------ CARGA ZONAS Y TRANSFORMADORES ------------------------
         */

        CargarClaseSimpleDesdeJson<Zona> cargaZonas =
                new CargarClaseSimpleDesdeJson<>(Zona.class);

        List<Zona> zonas = cargaZonas.obtenerListaClaseComun(Path.Archivos.ZONA);

        zonas.forEach(zona -> DatabaseUtil.persistir(zona));

        /*
        ------------------------ CARGA ZONAS Y TRANSFORMADORES ------------------------
         */

        /*
        ------------------------ CARGA ADMINISTRADORES ------------------------
         */

        CargarClaseSimpleDesdeJson<Administrador> cargarAdmin =
                new CargarClaseSimpleDesdeJson<>(Administrador.class);

        List<Administrador> admins = cargarAdmin.obtenerListaClaseComun(Path.Archivos.LOGIN_ADMINISTRADORES);

        admins.forEach(administrador -> DatabaseUtil.persistir(administrador));

        /*
        ------------------------ CARGA ADMINISTRADORES ------------------------
         */
    }
}
