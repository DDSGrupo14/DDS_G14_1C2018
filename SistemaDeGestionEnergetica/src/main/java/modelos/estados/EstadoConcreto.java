package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

import java.util.HashMap;
import java.util.Map;

public enum EstadoConcreto {

    APAGADO(0, "Apagado"),
    ENCENDIDO(1, "Encendido"),
    AHORROENERGIA(2, "Ahorro de energia");

    private int value;
    private String nombreEstadoConcreto;
    private static Map map = new HashMap<>();


    static {
        for (EstadoConcreto estadoConcreto : EstadoConcreto.values()) {
            map.put(estadoConcreto.value, estadoConcreto);
        }
    }
    EstadoConcreto(int value, String nombreEstadoConcreto){
        this.value = value;
        this.nombreEstadoConcreto = nombreEstadoConcreto;
    }

    public int getValue() {
        return value;
    }

    public String getNombreEstadoConcreto() {
        return nombreEstadoConcreto;
    }

    public static EstadoConcreto getEstadoConcreto(int idEstado ){
        return (EstadoConcreto) map.get(idEstado);
    }


    public Estado getEstadoDispositivo(DispositivoInteligente dispositivoInteligente){

        switch (this){
            case APAGADO: return new Apagado(dispositivoInteligente);
            case ENCENDIDO: return new Encendido(dispositivoInteligente);
            case AHORROENERGIA: return  new AhorroDeEnergia(dispositivoInteligente);
            default: throw new AssertionError("Estado desconocido " + this);
        }
    }

    public Estado getEstado(double porcentajeAhorro){

        switch (this){
            case APAGADO: return new Apagado();
            case ENCENDIDO: return new Encendido();
            case AHORROENERGIA: return  new AhorroDeEnergia(porcentajeAhorro);
            default: throw new AssertionError("Estado desconocido " + this);
        }
    }
}
