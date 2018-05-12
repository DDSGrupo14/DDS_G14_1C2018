package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.util.List;

public class Categoria extends BeanToJson<Categoria> {

    private List<Double> cargosFijos;
    private List<Double> cargosVariables;
    @Expose
    private Integer categoriaActual;

    public Categoria( List<Double> cargosFijos, List<Double> cargosVariables, Integer categoriaActual){

        this.cargosFijos = cargosFijos;
        this.cargosVariables = cargosVariables;
        this.categoriaActual = categoriaActual;
    }

    //agregar los constructores , no es necesario los getters y setters.
    @Override
    public Categoria getObj() {
        return this;
    }

    public Double obtenerCargoVariable( ){

        return cargosVariables.get( categoriaActual - 1);
    }

    public Double obtenerCargoFijo( ){

        return cargosFijos.get( categoriaActual - 1);
    }

}
