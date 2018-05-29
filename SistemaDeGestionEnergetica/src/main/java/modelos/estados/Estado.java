package modelos.estados;

public interface Estado {

    Estado encender();

    Estado apagar();

    Estado ahorrarEnergia( Double porcentajeAhorro );

    Double porcentajeConsumo();

    boolean estasEncendido();

}
