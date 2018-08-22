package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.adaptadores.AdaptadorAire;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class AdaptadorAireDeserializer implements  JsonDeserializer<AdaptadorAire> {

    @Override
    public AdaptadorAire deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String nombre = jsonObject.get("nombre").getAsString();

        final BigDecimal consumoPorHora = jsonObject.get("consumoPorHora").getAsBigDecimal();

        final AdaptadorAire adaptadorAire= new AdaptadorAire(consumoPorHora,nombre);

        return adaptadorAire;
    }
}
