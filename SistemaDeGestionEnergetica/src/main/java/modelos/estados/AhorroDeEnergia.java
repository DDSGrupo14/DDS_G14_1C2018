package modelos.estados;

public class AhorroDeEnergia implements Estado {

    private Double porcentajeDeAhorro;

    public AhorroDeEnergia(Double porcentajeDeAhorro) {
        this.porcentajeDeAhorro = porcentajeDeAhorro;
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender() {
        return new Encendido();
    }

    @Override
    public Estado apagar() {
        return new Apagado();
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro) {
        return new AhorroDeEnergia( porcentajeAhorro );
    }

    @Override
    public Double porcentajeConsumo() {
        return new Double( 100 - porcentajeDeAhorro);
    }
}
