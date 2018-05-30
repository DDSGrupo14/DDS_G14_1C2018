package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;

public abstract class CondicionTemperatura extends Condicion {

    public Integer temperaturaPivote;

    public CondicionTemperatura(Regla regla, Integer temperatura ) {

        super(regla);
        this.temperaturaPivote = temperatura;
    }

}
