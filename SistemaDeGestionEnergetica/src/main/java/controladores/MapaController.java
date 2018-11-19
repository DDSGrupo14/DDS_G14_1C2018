package controladores;

import modelos.enre.Zona;
import spark.Request;
import spark.Response;
import spark.Route;
import utilidades.Path;
import utilidades.ViewUtil;
import dao.ZonaDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaController {

    public static Route obtenerMApa = (Request request, Response response) -> {

        Map<String, Object> model = new HashMap<>();

        ZonaDAO zonaDAO = new ZonaDAO();

        List<Zona> zonas = zonaDAO.getAllZonas();

        zonas.forEach(Zona::calcularConsumoDeTransformadores);

        model.put("zonas", zonas);

        return ViewUtil.render(model, Path.Template.MAPA);
    };
}
