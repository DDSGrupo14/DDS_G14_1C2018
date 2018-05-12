package Modelos;

import java.util.Arrays;
import java.util.List;

public class Categoria {

    private List<Double> cargosFijos = Arrays.asList( 5.2, 7.6, 9.1, 12.4, 15.8, 20.8, 25.9, 28.5, 30.6 );
    private List<Double> cargosVariables = Arrays.asList( 2.2, 3.6, 4.1, 5.4, 6.8, 7.8, 9.9, 10.5, 11.6 );

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

    public Double obtenerCargoFijo( Integer categoria ){

        return cargosFijos.get( categoria - 1);
    }

    public Double obtenerCargoVariable( Integer categoria ){

        return cargosVariables.get( categoria - 1);
    }

}
