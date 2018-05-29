package modelos.estados;

public class Apagado implements Estado {
    @Override
    public boolean estasEncendido() {
        return false;
    }

    @Override
    public Encendido encender() {
        return new Encendido();
    }

    @Override
    public Estado apagar() {
        return null;
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro) {
        return new AhorroDeEnergia( porcentajeAhorro );
    }

    @Override
    public Double porcentajeConsumo() {
        return new Double( 0 );
    }
}
