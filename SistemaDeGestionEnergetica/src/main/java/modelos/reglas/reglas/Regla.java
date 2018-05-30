package modelos.reglas.reglas;

import modelos.reglas.actuadores.Actuador;

public abstract class Regla {

    private Actuador actuador;

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public void actuar(){}

}
