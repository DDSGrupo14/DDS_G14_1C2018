package servicios;

import dao.DomicilioDAO;
import dao.TransformadorDAO;
import modelos.enre.Transformador;
import modelos.mongo.Reporte;
import modelos.usuarios.Domicilio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TransformadorService extends BaseService{

    private final static TransformadorDAO transformadorDAO = new TransformadorDAO();


    public TransformadorService(){
        this.nombreClase = Transformador.class.getSimpleName();
    }

    public BigDecimal getConsumoTotalPeriodo(int id, LocalDate inicio, LocalDate fin){

        Reporte reporte = reporteDAO.getReporte(nombreClase,id,inicio,fin);

        if( reporte != null )
            return reporte.getConsumoTotalPeriodo();

        Transformador transformador = transformadorDAO.getTransformador(id);

        if(transformador == null)
            return consumoTotal;

        DomicilioDAO domicilioDAO = new DomicilioDAO();

        List<Domicilio> domicilios = domicilioDAO.getAllDomiciliosTransformador(transformador);

        if( domicilios == null)
            return consumoTotal;

        DomicilioService domicilioService = new DomicilioService();

        domicilios.forEach(domicilio -> {
            consumoTotal = consumoTotal.add(
                    domicilioService.getConsumoTotalPeriodo(domicilio.getDom_id(),inicio,fin));
        });

        reporte = new Reporte(nombreClase,transformador.getTransf_id(),inicio,fin,
                consumoTotal, consumoTotal.divide(new BigDecimal(24)));

        reporteDAO.save(reporte);

        return consumoTotal;
    }

}
