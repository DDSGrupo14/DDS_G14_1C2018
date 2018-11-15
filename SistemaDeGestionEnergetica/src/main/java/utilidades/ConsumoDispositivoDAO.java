package utilidades;

import modelos.dispositivos.ConsumoDispositivo;
import modelos.dispositivos.DispositivoInteligente;

import java.time.LocalDateTime;
import java.util.List;

public class ConsumoDispositivoDAO {

    final static String ENCENDIDO = "Encendido";
    final static String APAGADO = "Apagado";
    final static String AHORRO = "Ahorro de energia";

    public void encenderDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now(), dispositivoInteligente, ENCENDIDO);

        DatabaseUtil.persistir(consumoDispositivo);
    }

    public void apagarDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now(), dispositivoInteligente, APAGADO);

        DatabaseUtil.persistir(consumoDispositivo);
    }

    public void ahorroEnergiaDispositivo(DispositivoInteligente dispositivoInteligente) {

        ConsumoDispositivo consumoDispositivo = new ConsumoDispositivo(LocalDateTime.now(), dispositivoInteligente, AHORRO);

        DatabaseUtil.persistir(consumoDispositivo);
    }


    public List<ConsumoDispositivo> consumoUltimoMes(DispositivoInteligente dispositivoInteligente) {
        try {
            List<ConsumoDispositivo> lista = DatabaseUtil.getSession().createQuery(
                    "from ConsumoDispositivo where dispositivoInteligente = :id", ConsumoDispositivo.class)
                    .setParameter("id", dispositivoInteligente.getDint_id()).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }
}
