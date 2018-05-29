package modelos.estados;

public class Encendido implements Estado {
    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender() {
        return new Encendido(); // Poner excepcion despues
    }

    @Override
    public Apagado apagar() {

        return new Apagado();
    }

    @Override
    public Estado ahorrarEnergia( Double porcentajeAhorro ) {
        return new AhorroDeEnergia( porcentajeAhorro );
    }

    @Override
    public Double porcentajeConsumo() {
        return new Double( 100 );
    }
}
