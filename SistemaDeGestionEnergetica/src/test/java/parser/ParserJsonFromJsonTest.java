package parser;

import json.CargarClaseSimpleDesdeJson;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.enre.Zona;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;
import utilidades.Path;

import static json.JsonUtils.obtenerClientes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class ParserJsonFromJsonTest {


    @Test
    public void cargarClientesDesdeJsonTest() {

        List<Cliente> clientes = obtenerClientes(Path.Archivos.CLIENTE_COMPLETO);

        assertEquals(1,clientes.size(), "No coincide.");
        System.out.println("Tamaño lista: " + clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes().size());
        for(DispositivoInteligente dispositivoInteligente: clientes.get(0).getDomicilios().get(0).getDispositivosInteligentes()){
            System.out.println(dispositivoInteligente.getAdaptador().getDispositivoEstandar().getNombre());
        }
    }

    @Test
    public void cargaAdminsDesdeJsonTest(){

        CargarClaseSimpleDesdeJson<Administrador> cargarAdmin = new CargarClaseSimpleDesdeJson<Administrador>(Administrador.class);

        List<Administrador> admins = cargarAdmin.obtenerListaClaesComun(Path.Archivos.LOGIN_ADMINISTRADORES);

        Administrador admin = admins.get(0);

        System.out.println(admin.toString());

        assertEquals(1,admins.size());
    }

    @Test
    public void cargarLoginClientesDesdeJsonTest(){

        List<Cliente> clientes = obtenerClientes(Path.Archivos.LOGIN_CLIENTES);

        Cliente cliente = clientes.get(0);

        System.out.println(cliente.toString());

        assertEquals(2,clientes.size());
    }

    @Test
    public void cargarTiposConcretosDesdeJsonTest(){

        CargarClaseSimpleDesdeJson<TipoDispositivo> cargaTipo =
                new CargarClaseSimpleDesdeJson<>(TipoDispositivo.class);

        List<TipoDispositivo> tipos = cargaTipo.obtenerListaClaesComun(Path.Archivos.TIPOS_CONCRETOS);

        System.out.println(tipos.get(4).toString());

        assertEquals(24, tipos.size());

    }


    @Test
    public void cargarCategoriasDesdeJsonTest(){

        CargarClaseSimpleDesdeJson<Categoria> cargaCategoria =
                new CargarClaseSimpleDesdeJson<>(Categoria.class);

        List<Categoria> categorias = cargaCategoria.obtenerListaClaesComun(Path.Archivos.CATEGORIAS);

        System.out.println(categorias.get(4).toString());

        assertEquals(9, categorias.size());

    }

    @Test
    public void cargarZonasDesdeJsonTest(){

        CargarClaseSimpleDesdeJson<Zona> cargaZonas =
                new CargarClaseSimpleDesdeJson<>(Zona.class);

        List<Zona> zonas = cargaZonas.obtenerListaClaesComun(Path.Archivos.ZONA);

        System.out.println(zonas.get(0).toString());

        assertEquals(1, zonas.size());

    }
}
