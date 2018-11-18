package modelos.reglas.condiciones;

import java.util.HashMap;
import java.util.Map;

public enum Operador {

    IGUAL(0),
    MENOR(1),
    MAYOR(2),
    MENOR_IGUAL(3),
    MAYOR_IGUAL(4);

    private int value;
    private static Map map = new HashMap<>();

    Operador( int value ){
        this.value = value;
    }

    static {
        for (Operador operador : Operador.values()) {
            map.put(operador.value, operador);
        }
    }

    public int getValue() {
        return value;
    }

    public static Operador obtenerOperador( int tipoOperador ){
        return (Operador) map.get(tipoOperador);
    }

    Boolean calcular(int pivote, int cantidadActual){

        switch( this ){
            case IGUAL: return cantidadActual == pivote;
            case MAYOR: return cantidadActual > pivote;
            case MENOR: return cantidadActual < pivote;
            case MAYOR_IGUAL: return cantidadActual >= pivote;
            case MENOR_IGUAL: return cantidadActual <= pivote;
            default: throw new AssertionError("Operacion desconocida " + this);
        }
    }
}
