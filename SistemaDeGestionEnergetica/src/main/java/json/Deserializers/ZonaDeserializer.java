package json.Deserializers;

import com.google.gson.*;
import modelos.enre.Transformador;
import modelos.enre.Zona;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ZonaDeserializer implements JsonDeserializer<Zona> {
    @Override
    public Zona deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String codigo = jsonObject.get("codigo").getAsString();
        final double latitud = jsonObject.get("latitud").getAsDouble();
        final double longitud = jsonObject.get("longitud").getAsDouble();
        final int radio = jsonObject.get("radio").getAsInt();
        Transformador[] transformadores =
                context.deserialize(jsonObject.get("transformadores"),Transformador[].class);

        List<Transformador> listaTransformadores = Arrays.asList(transformadores);

        final Zona zona = new Zona();

        zona.setCodigo(codigo);
        zona.setLatitud(latitud);
        zona.setLongitud(longitud);
        zona.setRadio(radio);
        zona.setTransformadores(listaTransformadores);

        return zona;
    }
}
