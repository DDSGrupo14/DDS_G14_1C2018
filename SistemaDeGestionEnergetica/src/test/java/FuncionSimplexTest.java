import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilidades.SimplexFacade;
import utilidades.SimplexUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        aire.setTipoDispositivo(
                new TipoDispositivo("aire220",90,
                        360,new BigDecimal(1.013), true, false));

        lampara = new DispositivoInteligente();
        lampara.setNombre("lampara");
        lampara.setTipoDispositivo(
                new TipoDispositivo("lampara11W", 90, 360, new BigDecimal(0.011),true,true));

        computadora= new DispositivoInteligente();
        computadora.setNombre("computadora");
        computadora.setTipoDispositivo(
                new TipoDispositivo("escritorio", 60, 360, new BigDecimal(0.4),true,true));

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
        simplexFacade.agregarRestriccion(Relationship.LEQ, 612*30*24, 	1.013, 	0.011, 	0.4);
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
    public void testSimplex(){

        SimplexUtil simplexUtil = new SimplexUtil();
        try{
            PointValuePair solucion = simplexUtil.aplicarSimplexSobreDispositivos(dispositivos);
            System.out.println(solucion.getValue());
            System.out.println(solucion.getPoint()[0]);
            System.out.println(solucion.getPoint()[1]);
            //System.out.println(dispositivos.get(2).getConsumoRecomendadoSimplex());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void otroSimplex() {

        double c1 = 1;
        double c2 = 1;
        double c3 = 1;
        double[] coeficientes = {
                c1,
                c2,
                c3
        };

        LinearObjectiveFunction funcion = new LinearObjectiveFunction(coeficientes, 0);
        Collection<LinearConstraint> restricciones = new ArrayList<LinearConstraint>();

        restricciones.add(new LinearConstraint(new double[]{1, 0, 0}, Relationship.LEQ, 360));
        restricciones.add(new LinearConstraint(new double[]{1, 0, 0}, Relationship.GEQ, 90));

        restricciones.add(new LinearConstraint(new double[]{0, 1, 0}, Relationship.LEQ, 360));
        restricciones.add(new LinearConstraint(new double[]{0, 1, 0}, Relationship.GEQ, 90));

        restricciones.add(new LinearConstraint(new double[]{0, 0, 1}, Relationship.LEQ, 360));
        restricciones.add(new LinearConstraint(new double[]{0, 0, 1}, Relationship.GEQ, 60));

        restricciones.add(new LinearConstraint(new double[]{1.013, 	0.011, 	0.4}, Relationship.LEQ, 612*24*30));

        SimplexSolver solver = new SimplexSolver();
        PointValuePair optSolution = solver.optimize(
                new MaxIter(100),
                funcion,
                new LinearConstraintSet(restricciones),
                GoalType.MAXIMIZE,
                new NonNegativeConstraint(true)
        );

        System.out.println("x1=" + optSolution.getPoint()[0]);
        System.out.println("x2=" + optSolution.getPoint()[1]);
        System.out.println("x3=" + optSolution.getPoint()[2]);
        System.out.println("Z=" + optSolution.getValue());
    }

}
