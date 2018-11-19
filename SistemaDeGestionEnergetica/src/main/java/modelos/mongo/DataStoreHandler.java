package modelos.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DataStoreHandler {

    private final static Morphia morphia = new Morphia();

    private static DataStoreHandler dataStoreHandler;

    private static Datastore datastore;

    private DataStoreHandler(){

    }

    public static DataStoreHandler getInstance(){

        if(dataStoreHandler == null) {
            dataStoreHandler = new DataStoreHandler();
            morphia.map(Reporte.class);
            datastore = morphia.createDatastore(new MongoClient(), "sge_reportes");
            //datastore.getDB().dropDatabase();
            datastore.ensureIndexes();
        }
        return dataStoreHandler;
    }

    public static ReporteDAO getReporteDAO(){
        return new ReporteDAO(Reporte.class, getInstance().datastore);
    }
}
