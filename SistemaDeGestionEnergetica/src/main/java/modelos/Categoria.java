package modelos;

import json.BeanToJson;

import java.util.List;

public class Categoria extends BeanToJson<Categoria> {

    private List<Double> cargosFijos;
    private List<Double> cargosVariables;

    //agregar los constructores , no es necesario los getters y setters.
    @Override
    public Categoria getObj() {
        return this;
    }
}
