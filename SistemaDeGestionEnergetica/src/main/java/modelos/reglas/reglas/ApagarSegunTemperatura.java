package modelos.reglas.reglas;

public class ApagarSegunTemperatura extends Regla {

    @Override
    public void actuar(){

        getActuador().apagar();

    }
}
