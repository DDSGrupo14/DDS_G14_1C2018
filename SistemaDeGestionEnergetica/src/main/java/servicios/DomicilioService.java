package servicios;

import dao.ConsumoDispositivoDAO;
import dao.DomicilioDAO;
import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.estados.EstadoConcreto;
import modelos.usuarios.Domicilio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DomicilioService {

    private final static DomicilioDAO domicilioDAO = new DomicilioDAO();
    private BigDecimal consumoTotal = new BigDecimal(0);


    public BigDecimal getConsumoTotalDomicilioPeriodo(int id, LocalDateTime p_inicio, LocalDateTime p_final){

        Domicilio domicilio = domicilioDAO.getDomicilio(id);

        List<DispositivoEstandar> listaE = domicilio.getDispositivosEstandar();
        if(listaE != null)
            listaE.forEach(e -> consumoTotal = consumoTotal.add(
                    e.getConsumoDiarioEstimado().multiply( new BigDecimal(ChronoUnit.DAYS.between(p_inicio,p_final)))
            ));

        List<DispositivoInteligente> listaI = domicilio.getDispositivosInteligentes();

        ConsumoService consumoService = new ConsumoService();

        if(listaI != null)
            listaI.forEach( i -> consumoTotal = consumoService.consumoTotalDispositivo(i,p_inicio,p_final));

        return consumoTotal;
    }
}
