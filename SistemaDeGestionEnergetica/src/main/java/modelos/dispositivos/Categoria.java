package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.util.Arrays;
import java.util.List;

public class Categoria extends BeanToJson<Categoria> {

    private List<Double> cargosFijos = Arrays.asList( 18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19 );

    private List<Double> cargosVariables = Arrays.asList( 0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851 );
    @Expose
    private Integer categoriaActual;

    public Categoria(Integer categoriaActual){

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

    public void recategorizar( Integer nuevaCategoria ){
        this.categoriaActual = nuevaCategoria;
    }

}
