package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class AdaptadorEstandarDeserializer implements  JsonDeserializer<AdaptadorEstandar> {

    @Override
    public AdaptadorEstandar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String nombre = jsonObject.get("nombre").getAsString();

        final BigDecimal consumoPorHora = jsonObject.get("consumoPorHora").getAsBigDecimal();

        final AdaptadorEstandar adaptadorEstandar= new AdaptadorEstandar(consumoPorHora,nombre);

        return adaptadorEstandar;
    }
}
