package servicios;

import modelos.mongo.DataStoreHandler;
import modelos.mongo.Reporte;
import modelos.mongo.ReporteDAO;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class BaseService {

    protected final static ReporteDAO reporteDAO = DataStoreHandler.getReporteDAO();

    protected static String nombreClase;

    protected BigDecimal consumoTotal = new BigDecimal(0);

    public BigDecimal getConsumoTotalPeriodo(int id, LocalDate inicio, LocalDate fin){
        return consumoTotal;
    }

    public BigDecimal getConsumoPromedioPeriodo(int id, LocalDate inicio, LocalDate fin){

        Reporte reporte = reporteDAO.getReporte(nombreClase, id,inicio,fin);

        if( reporte != null )
            return reporte.getConsumoPromedioPeriodo();

        return getConsumoTotalPeriodo( id, inicio, fin).divide(new BigDecimal(24));
    }
}
