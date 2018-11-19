package servicios;

import dao.DispositivoInteligenteDAO;
import modelos.dispositivos.DispositivoInteligente;
import modelos.mongo.Reporte;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DispositivoInteligenteService extends BaseService{


    public DispositivoInteligenteService(){
        this.nombreClase = DispositivoInteligente.class.getSimpleName();
    }

    private final static DispositivoInteligenteDAO dispDAO = new DispositivoInteligenteDAO();

    public BigDecimal getConsumoTotalPeriodo(int id, LocalDate inicio, LocalDate fin){

        Reporte reporte = reporteDAO.getReporte(nombreClase,id,inicio,fin);

        if( reporte != null )
            return reporte.getConsumoTotalPeriodo();

        LocalDateTime p_inicio = LocalDateTime.of(inicio, LocalTime.of(0,0,0)) ;
        LocalDateTime p_final = LocalDateTime.of(fin,LocalTime.of(0,0,0)) ;

        DispositivoInteligente i = dispDAO.getDispositivoInteligentePorId(id);

        if (i == null)
            return new BigDecimal(0);

        ConsumoService consumoService = new ConsumoService();

        consumoTotal = consumoService.getConsumoTotalPeriodo(i, p_inicio, p_final);

        reporte = new Reporte(nombreClase,i.getDint_id(),inicio,fin,
                consumoTotal, consumoTotal.divide(new BigDecimal(24)));

        reporteDAO.save(reporte);

        return consumoTotal;
    }

}
