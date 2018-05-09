package main.java.Modelos;

import main.java.Json.BeanToJson;

import java.util.List;

public class Categoria extends BeanToJson<Categoria> {

    private List<Double> cargosFijos;
    private List<Double> cargosVariables;

    public List<Double> getCargosFijos() {
        return cargosFijos;
    }

    public void setCargosFijos(List<Double> cargosFijos) {
        this.cargosFijos = cargosFijos;
    }

    public List<Double> getCargosVariables() {
        return cargosVariables;
    }

    public void setCargosVariables(List<Double> cargosVariables) {
        this.cargosVariables = cargosVariables;
    }

    @Override
    public Categoria getObj() {
        return this;
    }
}
