package modelos.dao;

import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;
import modelos.estados.EstadoConcreto;
import utilidades.DatabaseUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ConsumoDispositivoDAO {

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


    public List<ConsumoDispositivo> consumoUltimoMes(DispositivoInteligente dispositivoInteligente) {
        try {
            List<ConsumoDispositivo> lista = DatabaseUtil.getSession().createQuery(
                    "from ConsumoDispositivo where dispositivoInteligente = :dispositivo and " +
                            "date( fecha ) between date_sub_month(current_date ,1) and current_date "
                    , ConsumoDispositivo.class)
                    .setParameter("dispositivo", dispositivoInteligente).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }
}
