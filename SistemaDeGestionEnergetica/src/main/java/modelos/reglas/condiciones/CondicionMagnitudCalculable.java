package modelos.reglas.condiciones;

import modelos.reglas.sensores.Magnitud;

import javax.persistence.*;

@Entity
@Table(name = "condicion" )
public class CondicionMagnitudCalculable extends Condicion {

    public CondicionMagnitudCalculable(){}

    public CondicionMagnitudCalculable( Operador operador, Integer limite){

        super(operador.getValue(), limite);
    }

    @Override
    public CondicionMagnitudCalculable getClaseConcreta(){
        return this;
    }


    @Override
    public void update(Magnitud magnitud, int valor){

        if(magnitud.getEsCalculable())
            setCondicionCumplida(Operador.obtenerOperador(getOperador()).calcular(getLimite(), valor));

        if(getCondicionCumplida()) updateRegla();
    }
}
