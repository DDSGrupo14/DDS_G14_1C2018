package modelos.reglas;

import java.util.List;

public class Sensor< T > {

    private List< Actuador > actuadores;

    private T medicion; // T es una clase generica para tratar distintas medidas
}
