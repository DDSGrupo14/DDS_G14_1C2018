package modelos.usuarios;

import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    static Cliente cliente;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File

        try {
            Configuration configObj = new Configuration();
            configObj.configure();
            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            //ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
            // Creating Hibernate SessionFactory Instance
            sessionFactoryObj = configObj.buildSessionFactory();
            return sessionFactoryObj;
        } catch (Throwable ex){
            System.err.println(ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();
            cliente = new Cliente("nuevo","renuevo","4444444","12345", "admin", "admin");
           // cargarCategorias();

            Categoria categoria01 = (Categoria) sessionObj.get( Categoria.class,1);
            final Domicilio domicilio = new Domicilio("direccionNueva",true,"05/1/15");

            final TipoDispositivo tipo = new TipoDispositivo("aire",90,220
                    ,new BigDecimal(100), true, true);

            sessionObj.save(tipo);

           // final TipoDispositivo _tipo = sessionObj.get(TipoDispositivo.class,1);

            final DispositivoInteligente dips1 = new DispositivoInteligente(tipo,"aire acondicionado",30.0);

            final DispositivoEstandar disp2 = new DispositivoEstandar("estandar",new BigDecimal(200));

            domicilio.agregarDispositivoInteligente(dips1);
            domicilio.agregarDispositivoEstandar(disp2);

            cliente.agregarDomicilio(domicilio,categoria01);

            sessionObj.save(cliente);

            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
/*
    private static void cargarCategorias( ){

        final List<Double> cargosFijos = Arrays.asList( 18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19 );
        final List<Double> cargosVariables = Arrays.asList( 0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851 );


        for(int i = 0; i<9; i++){
            sessionObj.save(new Categoria(i+1, new BigDecimal(cargosFijos.get(i)),new BigDecimal(cargosVariables.get(i))));
        }
    }*/
}
