package utilidades;

import modelos.dispositivos.DispositivoInteligente;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.List;

public class SimplexUtil {

    private static SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);

    private static double valorPivote = 612*24*30;

    public SimplexUtil() {
    }

    public double getValorPivote() {
        return valorPivote;
    }

    public void setValorPivote(double valorPivote) {
        this.valorPivote = valorPivote;
    }

    public PointValuePair aplicarSimplexSobreDispositivos(List<DispositivoInteligente> dispositivos){

        int tamanio = dispositivos.size();
        int i = 0;
        double[] variables = new double[tamanio];
        double[] coeficientes = new double[tamanio];
        double[] posicionVariable = new double[tamanio];
        while( i < tamanio){
            variables[i] = 1;
            posicionVariable[i] = 0;
            i++;
        }

        simplexFacade.crearFuncionEconomica(variables);
        i = 0;
        for(DispositivoInteligente disp: dispositivos){
            posicionVariable[i] = 1;
            coeficientes[i] = disp.getConsumoEstimadoKWh().doubleValue();
            simplexFacade.agregarRestriccion(Relationship.LEQ, disp.getUsoMensualMaximo(), posicionVariable);
            simplexFacade.agregarRestriccion(Relationship.GEQ, disp.getUsoMensualMinimo(), posicionVariable);
            posicionVariable[i] = 0;
            i++;
        }
        simplexFacade.agregarRestriccion(Relationship.LEQ, valorPivote, coeficientes);

        PointValuePair resultado = simplexFacade.resolver();

        i = 0;

        for(DispositivoInteligente disp: dispositivos){
            //disp.setConsumoRecomendadoSimplex(resultado.getPoint()[i]);
            i++;
        }

        return resultado;
    }
}
