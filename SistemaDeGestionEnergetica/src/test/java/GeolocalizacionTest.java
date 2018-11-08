import modelos.enre.Zona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilidades.ZonaDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class GeolocalizacionTest {

    static List<Zona> zonas;

    @BeforeAll
    public static void cargarZonas(){
        ZonaDAO zonaDAO = new ZonaDAO();

        zonas = zonaDAO.obtenerZonas();

    }

    @Test
    public void deberianExistirZonasTest(){

        zonas.forEach(Zona::toString);

        assertEquals(false, zonas.size() == 0);

    }
}
