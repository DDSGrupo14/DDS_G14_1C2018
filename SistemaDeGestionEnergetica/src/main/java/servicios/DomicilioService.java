package servicios;

import dao.DomicilioDAO;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.mongo.Reporte;
import modelos.usuarios.Domicilio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DomicilioService extends BaseService{

    private final static DomicilioDAO domicilioDAO = new DomicilioDAO();

    public DomicilioService(){
        this.nombreClase = Domicilio.class.getSimpleName();
    }

    public BigDecimal getConsumoTotalPeriodo(int id, LocalDate inicio, LocalDate fin){

        Reporte reporte = reporteDAO.getReporte(nombreClase,id,inicio,fin);

        if( reporte != null )
            return reporte.getConsumoTotalPeriodo();

        LocalDateTime p_inicio = LocalDateTime.of(inicio, LocalTime.of(0,0,0)) ;
        LocalDateTime p_final = LocalDateTime.of(fin,LocalTime.of(0,0,0)) ;

        Domicilio domicilio = domicilioDAO.getDomicilio(id);

        if(domicilio == null)
            return consumoTotal;

        List<DispositivoEstandar> listaE = domicilio.getDispositivosEstandar();
        if(listaE != null)
            listaE.forEach(e -> consumoTotal = consumoTotal.add(
                    e.getConsumoDiarioEstimado().multiply( new BigDecimal(ChronoUnit.DAYS.between(p_inicio,p_final)))
            ));

        List<DispositivoInteligente> listaI = domicilio.getDispositivosInteligentes();
        ConsumoService consumoService = new ConsumoService();

        if(listaI != null)
            listaI.forEach( i -> consumoTotal = consumoService.getConsumoTotalPeriodo(i,p_inicio,p_final));

        reporte = new Reporte(nombreClase,domicilio.getDom_id(),inicio,fin,
                consumoTotal, consumoTotal.divide(new BigDecimal(24)));

        reporteDAO.save(reporte);

        return consumoTotal;
    }
}
