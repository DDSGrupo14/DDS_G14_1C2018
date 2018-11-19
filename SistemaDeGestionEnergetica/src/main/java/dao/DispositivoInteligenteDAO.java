package dao;

import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.TipoDispositivo;
import modelos.usuarios.Domicilio;
import utilidades.DatabaseUtil;

import java.util.List;

public class DispositivoInteligenteDAO {

    static String hql;

    public TipoDispositivo getTipoDispositivo(String equipoConcreto){
        try {
            hql = "FROM TipoDispositivo where equipoConcreto = :nombre";
            return DatabaseUtil.getSession().createQuery(hql,TipoDispositivo.class)
                    .setParameter("nombre",equipoConcreto).getSingleResult();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<TipoDispositivo> getAllTiposDispositivos(){
        try{
            hql = "FROM TipoDispositivo ";
            return DatabaseUtil.getSession().createQuery(hql,TipoDispositivo.class)
                    .getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DispositivoInteligente getDispositivoInteligentePorId(int id){
        try {
            hql = "FROM DispositivoInteligente where dint_id = :id";
            DispositivoInteligente dispositivoInteligente = DatabaseUtil
                    .getSession().createQuery(hql,DispositivoInteligente.class)
                    .setParameter("id",id).getSingleResult();

            dispositivoInteligente.iniciarDispositivoInteligente();

            return dispositivoInteligente;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DispositivoInteligente getDispositivoInteligentePorNombre(String nombre){
        try {
            hql = "FROM DispositivoInteligente where nombre = :nombre";
            DispositivoInteligente dispositivoInteligente = DatabaseUtil
                    .getSession().createQuery(hql,DispositivoInteligente.class)
                    .setParameter("nombre",nombre).getSingleResult();

            dispositivoInteligente.iniciarDispositivoInteligente();

            return dispositivoInteligente;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<DispositivoInteligente> getAllDispIntDomicilio(Domicilio domicilio){
        try {
            hql = "FROM DispositivoInteligente where domicilio = :domicilio";
            List<DispositivoInteligente> lista = DatabaseUtil.getSession().createQuery(hql,DispositivoInteligente.class)
                    .setParameter("domicilio",domicilio).getResultList();

            lista.forEach(DispositivoInteligente::iniciarDispositivoInteligente);

            return lista;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
