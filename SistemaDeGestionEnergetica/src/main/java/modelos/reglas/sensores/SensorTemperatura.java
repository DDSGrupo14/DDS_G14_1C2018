package modelos.reglas.sensores;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class SensorTemperatura extends Sensor {

    @Transient
    private Magnitud temperatura = Magnitud.TEMPERATURA;

    @Transient
    private int temperaturaActual = 0;

    public SensorTemperatura(Integer temperaturaInicial) {
        this.temperatura.setCantidad( temperaturaInicial );
    }

    public SensorTemperatura() {
    }

    public Magnitud getTemperatura() {
        return temperatura;
    }

    public int getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(int temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    @Override
    public void medirMagnitud( int unValor ) {

        getCondicion().update( Magnitud.TEMPERATURA, unValor );

    }

}
