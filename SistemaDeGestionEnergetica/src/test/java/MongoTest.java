import modelos.mongo.DataStoreHandler;
import modelos.mongo.Reporte;
import modelos.mongo.ReporteDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MongoTest {

    @Test
    public void obtenerReporteTest(){

        final ReporteDAO reporteDAO = DataStoreHandler.getReporteDAO();

        List<Reporte> reportes = reporteDAO.getAllReportes();

        System.out.println(reportes.size());
    }
}
