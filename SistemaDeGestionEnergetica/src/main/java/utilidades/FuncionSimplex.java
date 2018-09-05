package utilidades;

import modelos.dispositivos.DispositivoInteligente;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

import java.util.List;

public class FuncionSimplex {

    public static volatile FuncionSimplex instance;

    public static FuncionSimplex getInstance(){

        if( instance == null){
            synchronized (FuncionSimplex.class){
                if(instance == null){
                    try{
                        instance = new FuncionSimplex();
                    }catch(Exception e){
                        System.out.println("Fallo la creacion de la instancia: " + e.getMessage());
                    }
                }
            }
        }
        return instance;
    }

    private FuncionSimplex() throws Exception{

    }

    public static void obtenerMejorCombinacion(List<DispositivoInteligente> dispositivos){

        final ExpressionsBasedModel tmpModel = new ExpressionsBasedModel();

        final Expression funcionEconomica = tmpModel.addExpression("Funcion Economica").lower(0).upper(612);

        for (DispositivoInteligente dispositivo:dispositivos
             ) {

            Variable var = Variable.make(dispositivo.getNombre()).lower(dispositivo.getUsoMensualMinimo())
                    .upper(dispositivo.getUsoMensualMaximo()).weight(dispositivo.getConsumoEstimadoKWh()).integer(true);

            funcionEconomica.set(var,dispositivo.consumoActual());

            tmpModel.addVariable(var);
        }

        Optimisation.Result resultado=  tmpModel.maximise();

        BasicLogger.debug();
        BasicLogger.debug(resultado);
        BasicLogger.debug();
        BasicLogger.debug(tmpModel);
        BasicLogger.debug();

 //       return dispositivos;
    }
}
