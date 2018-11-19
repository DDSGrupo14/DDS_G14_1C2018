package servicios;

import dao.ConsumoDispositivoDAO;
import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.estados.EstadoConcreto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ConsumoService {

    private final static ConsumoDispositivoDAO consumoDispositivoDAO = new ConsumoDispositivoDAO();


    public BigDecimal consumoTotalDispositivo(DispositivoInteligente i, LocalDateTime p_inicio, LocalDateTime p_final){

        List<ConsumoDispositivo> listaC = consumoDispositivoDAO.getConsumoPeriodo(i, p_inicio, p_final);
        BigDecimal consumoTotal = new BigDecimal(0);
        for(int j= 0; j < listaC.size()-1; j++){
            EstadoConcreto estado1 = EstadoConcreto.getEstadoConcreto(listaC.get(j).getEstadoDispositivo());

            double pAhorro = listaC.get(j).getDispositivoInteligente().getPorcentajeAhorroEnergia();
            BigDecimal porcentajeAhorro = new BigDecimal(estado1.getEstado(pAhorro).getPorcentajeAhorro());
            BigDecimal consumoEstKWH = listaC.get(j).getDispositivoInteligente().getConsumoEstimadoKWh();
            BigDecimal horas = new BigDecimal
                    (ChronoUnit.HOURS.between(listaC.get(j).getFecha(),listaC.get(j+1).getFecha()));

            BigDecimal suma = porcentajeAhorro.multiply(consumoEstKWH).multiply(horas);
            consumoTotal = consumoTotal.add(suma);
        }
        return consumoTotal;
    }
}
