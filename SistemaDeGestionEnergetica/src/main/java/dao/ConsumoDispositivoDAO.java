package dao;

import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.estados.EstadoConcreto;
import utilidades.DatabaseUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ConsumoDispositivoDAO {

    private static String hql;

    public void encenderDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now()
                , dispositivoInteligente, EstadoConcreto.ENCENDIDO);

        DatabaseUtil.persistir(consumoDispositivo);
    }

    public void apagarDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now()
                , dispositivoInteligente, EstadoConcreto.APAGADO);

        DatabaseUtil.persistir(consumoDispositivo);
    }

    public void ahorroEnergiaDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now()
                , dispositivoInteligente, EstadoConcreto.AHORROENERGIA);

        DatabaseUtil.persistir(consumoDispositivo);
    }


    public List<ConsumoDispositivo> getConsumoUltimoMes(DispositivoInteligente dispositivoInteligente) {
        try {
            hql = "from ConsumoDispositivo where dispositivoInteligente = :dispositivo and " +
                    "date( fecha ) between date_sub_month(current_date ,1) and current_date ";

            return DatabaseUtil.getSession().createQuery(hql, ConsumoDispositivo.class)
                    .setParameter("dispositivo", dispositivoInteligente).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    public List<ConsumoDispositivo> getConsumoPeriodo
            (DispositivoInteligente dipI, LocalDateTime p_inicio, LocalDateTime p_fin){
        try{
            hql = "from ConsumoDispositivo where dispositivoInteligente = :dispositivo and " +
                    " fecha between :p_inicio and :p_fin";
            return DatabaseUtil.getSession().createQuery(hql, ConsumoDispositivo.class)
                    .setParameter("dispositivo", dipI)
                    .setParameter("p_inicio", p_inicio)
                    .setParameter("p_fin", p_fin)
                    .getResultList();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }
}
