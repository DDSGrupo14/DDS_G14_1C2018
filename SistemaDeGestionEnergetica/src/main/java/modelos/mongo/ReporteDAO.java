package modelos.mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ReporteDAO extends BasicDAO<Reporte, String> {


    public ReporteDAO(Class<Reporte> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    public Reporte getReporte(String nombreClase, int id, LocalDate inicio, LocalDate fin){

        Query<Reporte> query = createQuery();

        query.and(
                query.criteria("nombreClase").equal(nombreClase),
                query.criteria("idObjeto").equal(id),
                query.criteria("periodo_inicio").equal(inicio),
                query.criteria("periodo_fin").equal(fin)
        );

        return findOne(query);
    }

    public List<Reporte> getAllReportes(){
        return find().asList();
    }
}
