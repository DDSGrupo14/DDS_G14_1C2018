package servicios;

import dao.DispositivoInteligenteDAO;
import modelos.dispositivos.DispositivoInteligente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DispositivoInteligenteService {

    private final static DispositivoInteligenteDAO dispDAO = new DispositivoInteligenteDAO();

    public BigDecimal getConsumoPromedioPeriodo(String nombre, LocalDateTime p_inicio, LocalDateTime p_final) {
        DispositivoInteligente i = dispDAO.getDispositivoInteligente(nombre);
        if (i != null) {
            ConsumoService consumoService = new ConsumoService();

            BigDecimal consumoTotal = consumoService.consumoTotalDispositivo(i, p_inicio, p_final);

            return consumoTotal.divide(new BigDecimal(24));
        } else
            return new BigDecimal(0);
    }
}
