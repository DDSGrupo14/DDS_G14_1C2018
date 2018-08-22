package modelos.enre;

import modelos.usuarios.Domicilio;

import java.util.ArrayList;
import java.util.List;

public class Transformador {

    private final List<Domicilio> domicilios = new ArrayList<Domicilio>();

    private Boolean estaActivo;

    public void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public void agregarDomicilio( Domicilio domicilio){ domicilios.add(domicilio); }

    public Double obtenerConsumoActual(){

        return 1.;
    }

}
