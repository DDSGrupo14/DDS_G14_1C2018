package modelos.dao;

import modelos.dispositivos.Categoria;
import modelos.enre.Transformador;
import modelos.usuarios.Cliente;
import modelos.usuarios.Domicilio;
import utilidades.DatabaseUtil;

import java.util.List;

public class DomicilioDAO {

    private static String hql;

    public Categoria getCategoria(String nombreCategoria){

        try {
            hql = "FROM Categoria where nombreCategoria = :nombre";
            return DatabaseUtil.getSession().createQuery(hql,Categoria.class)
                    .setParameter("nombre",nombreCategoria)
                    .getSingleResult();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Domicilio> getAllDomicilios(){
        try{
            hql = "FROM Domicilio ";
            return DatabaseUtil.getSession().createQuery(hql,Domicilio.class)
                    .getResultList();
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

    public Domicilio getDomicilioPrincipal(Cliente cliente){
        try{
            hql = "FROM Domicilio where cliente = :cliente and principal = :principal";
            return DatabaseUtil.getSession().createQuery(hql,Domicilio.class)
                    .setParameter("cliente", cliente)
                    .setParameter("principal",true)
                    .getSingleResult();
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

    public List<Domicilio> getAllDomiciliosCliente(Cliente cliente){
        try{
            hql = "FROM Domicilio where cliente = :cliente";
            return DatabaseUtil.getSession().createQuery(hql,Domicilio.class)
                    .setParameter("cliente",cliente).getResultList();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

    public List<Domicilio> getAllDomiciliosTransformador(Transformador transformador){
        try{
            hql = "FROM Domicilio where transformador = :transformador";
            return DatabaseUtil.getSession().createQuery(hql,Domicilio.class)
                    .setParameter("transformador",transformador).getResultList();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

}
