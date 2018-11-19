package servicios;

import dao.DomicilioDAO;
import dao.TransformadorDAO;
import modelos.enre.Transformador;
import modelos.usuarios.Domicilio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransformadorService {

    private final static TransformadorDAO transformadorDAO = new TransformadorDAO();

    private BigDecimal consumoTotal = new BigDecimal(0);

    public BigDecimal getConsumoPromedioPeriodo(String codigo, LocalDateTime p_inicio, LocalDateTime p_fin){

        Transformador transformador = transformadorDAO.getTransformador(codigo);

        if(transformador == null)
            return consumoTotal;

        DomicilioDAO domicilioDAO = new DomicilioDAO();

        List<Domicilio> domicilios = domicilioDAO.getAllDomiciliosTransformador(transformador);

        if( domicilios == null)
            return consumoTotal;

        DomicilioService domicilioService = new DomicilioService();

        domicilios.forEach(domicilio -> {
            consumoTotal = consumoTotal.add(
                    domicilioService.getConsumoTotalDomicilioPeriodo(domicilio.getDom_id(),p_inicio,p_fin));
        });

        return consumoTotal.divide(new BigDecimal(24));
    }
}
