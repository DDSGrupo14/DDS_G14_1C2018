package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.dispositivos.adaptadores.AdaptadorAire;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;

import java.lang.reflect.Type;

public class AdaptadorDeserializer implements JsonDeserializer<Adaptador> {
    @Override
    public Adaptador deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final Adaptador adaptador;

        String jsonAdaptadorString = jsonObject.get("type").getAsString();
        String tipoAdaptador = jsonAdaptadorString.substring(jsonAdaptadorString.lastIndexOf("." ));


        if(tipoAdaptador.equalsIgnoreCase("AdaptadorEstandar")) {
            adaptador = context.deserialize(jsonObject.get("data"), AdaptadorEstandar.class);
        } else {
            adaptador = context.deserialize(jsonObject.get("data"), AdaptadorAire.class);
        }

        return adaptador;
    }
}
