package parser;

import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilidades.FuncionSimplex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FuncionSimplexTest {

    static DispositivoInteligente aire;
    static DispositivoInteligente lampara;
    static DispositivoInteligente computadora;
    static List<DispositivoInteligente> dispositivos;

    @BeforeAll
    public static void cargarDispositivos(){

        aire = new DispositivoInteligente();
        aire.setNombre("aire");

        //TipoDispositivo(String equipoConcreto, int usoMensualMinimo, int usoMensualMaximo, BigDecimal consumoEstimadoKWh)
        aire.setTipoDispositivo(
                new TipoDispositivo("aire220",90,360,new BigDecimal(1.013)));

        aire.setConsumoActual(new BigDecimal(300));

        lampara = new DispositivoInteligente();
        lampara.setNombre("lampara");
        lampara.setTipoDispositivo(
                new TipoDispositivo("lampara11W", 90, 360, new BigDecimal(0.011)));

        lampara.setConsumoActual(new BigDecimal(200));

        computadora= new DispositivoInteligente();
        computadora.setNombre("computadora");
        computadora.setTipoDispositivo(
                new TipoDispositivo("escritorio", 60, 360, new BigDecimal(0.4)));

        computadora.setConsumoActual(new BigDecimal(500));

        dispositivos = new ArrayList<>();
        dispositivos.add(aire);
        dispositivos.add(lampara);
        dispositivos.add(computadora);
    }

    @Test
    public void funcionDeSegundaEntregaTest() {

        dispositivos.forEach(disp -> System.out.println(disp.getNombre()));

        FuncionSimplex.obtenerMejorCombinacion(dispositivos);
    }
}
