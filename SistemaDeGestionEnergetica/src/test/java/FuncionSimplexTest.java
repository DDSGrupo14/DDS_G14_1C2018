import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilidades.SimplexFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
                new TipoDispositivo("aire220",90,
                        360,new BigDecimal(1.013), true, false));

        aire.setConsumoActual(new BigDecimal(0));

        lampara = new DispositivoInteligente();
        lampara.setNombre("lampara");
        lampara.setTipoDispositivo(
                new TipoDispositivo("lampara11W", 90, 360, new BigDecimal(0.011),true,true));

        lampara.setConsumoActual(new BigDecimal(0.0));

        computadora= new DispositivoInteligente();
        computadora.setNombre("computadora");
        computadora.setTipoDispositivo(
                new TipoDispositivo("escritorio", 60, 360, new BigDecimal(0.4),true,true));

        computadora.setConsumoActual(new BigDecimal(0));

        dispositivos = new ArrayList<>();
        dispositivos.add(aire);
        dispositivos.add(lampara);
        dispositivos.add(computadora);
    }

    @Test
    public void funcionDeSegundaEntregaTest() {

        dispositivos.forEach(disp -> System.out.println(disp.getNombre()));

    }

    @Test
    public void funcionSimplexFacade(){

        SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
        simplexFacade.crearFuncionEconomica(1,1,1);
        simplexFacade.agregarRestriccion(Relationship.LEQ, 100, 	1.013, 	0.011, 	0.4);
        simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 		0, 		0, 		1);
        simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 	0, 		0, 		1);
        simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 		0, 		1, 		0);
        simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 		0, 		1, 		0);
        simplexFacade.agregarRestriccion(Relationship.GEQ, 60, 	1, 		0, 		0);
        simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 	1, 		0, 		0);
        try{
            PointValuePair solucion = simplexFacade.resolver();
            System.out.println(solucion.getValue());
            System.out.println(solucion.getPoint()[0]);
            System.out.println(solucion.getPoint()[1]);
            System.out.println(solucion.getPoint()[2]);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testeando(){

        SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
        simplexFacade.crearFuncionEconomica(new double[]{1,2,3});
    }

}
