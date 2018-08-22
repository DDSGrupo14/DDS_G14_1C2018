package modelos.enre;

import java.util.ArrayList;
import java.util.List;

public class Zona {

    private final List<Transformador> transformadores = new ArrayList<Transformador>();

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void agregarTransformador(Transformador transformador){ transformadores.add(transformador); }

    public Double obtenerConsumoTotalActual(){

        return transformadores.stream().map( Transformador::obtenerConsumoActual).reduce(0.,Double::sum);
    }

    public void enviarConsumoEnre(){}
}
