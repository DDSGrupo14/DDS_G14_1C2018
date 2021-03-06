import json.CargarClaseSimpleDesdeJson;
import json.CargarZonaDesdeJson;
import json.JsonUtils;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.TipoDispositivo;
import modelos.enre.Zona;
import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import org.junit.jupiter.api.Test;
import utilidades.DatabaseUtil;
import utilidades.Path;

import java.util.List;

public class PersistenciaTest {

    @Test
    public void persistirLoginAdminTest(){

        CargarClaseSimpleDesdeJson<Administrador> cargaAdmin =
                new CargarClaseSimpleDesdeJson<>(Administrador.class);

        List<Administrador> administradores = cargaAdmin.obtenerListaClaseComun(Path.Archivos.LOGIN_ADMINISTRADORES);

        for (Administrador administrador: administradores) {
            DatabaseUtil.persistir(administrador);
        }

    }

    @Test
    public void persistirLoginClientesTest(){

        List<Cliente> clientes = JsonUtils.obtenerClientes(Path.Archivos.LOGIN_CLIENTES);

        for(Cliente cliente: clientes){
            DatabaseUtil.persistir(cliente);
        }
    }

    @Test
    public void persistirTiposConcretosTest(){


        CargarClaseSimpleDesdeJson<TipoDispositivo> cargaTipos =
                new CargarClaseSimpleDesdeJson<>(TipoDispositivo.class);

        List<TipoDispositivo> tipos = cargaTipos.obtenerListaClaseComun(Path.Archivos.TIPOS_CONCRETOS);

        for(TipoDispositivo tipo: tipos){
            DatabaseUtil.persistir(tipo);
        }

    }

    @Test
    public void persistirCategoriasTest(){

        CargarClaseSimpleDesdeJson<Categoria> cargaCateogira =
                new CargarClaseSimpleDesdeJson<>(Categoria.class);

        List<Categoria> categorias = cargaCateogira.obtenerListaClaseComun(Path.Archivos.CATEGORIAS);

        categorias.forEach(categoria -> DatabaseUtil.persistir(categoria));
    }

    @Test
    public void persistirZonasTest(){

        List<Zona> zonas = JsonUtils.obtenerZonas(Path.Archivos.ZONA);

        for(Zona zona: zonas){
            DatabaseUtil.persistir(zona);
        }
    }}
