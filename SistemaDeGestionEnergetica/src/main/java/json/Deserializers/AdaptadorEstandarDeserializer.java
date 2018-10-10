package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class AdaptadorEstandarDeserializer implements  JsonDeserializer<AdaptadorEstandar> {

    @Override
    public AdaptadorEstandar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String nombreAdaptador = jsonObject.get("nombreAdaptador").getAsString();

        final BigDecimal consumoPorHora = jsonObject.get("consumoPorHora").getAsBigDecimal();

        final AdaptadorEstandar adaptadorEstandar= new AdaptadorEstandar(consumoPorHora, nombreAdaptador);

        final DispositivoEstandar dispositivoEstandar = context.deserialize(jsonObject.get("dispositivoEstandar"),DispositivoEstandar.class);

        // final AdaptadorEstandar adaptadorEstandar= new AdaptadorEstandar(new BigDecimal(5),"asd");

        adaptadorEstandar.setDispositivoEstandar(dispositivoEstandar);

        return adaptadorEstandar;
    }
}
