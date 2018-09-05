package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;

import java.lang.reflect.Type;

public class ActuadorDeserializer implements JsonDeserializer<Actuador> {
    @Override
    public Actuador deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final DispositivoInteligente dispositivoInteligente = context
                .deserialize(jsonObject.get("dispositivoInteligente"),DispositivoInteligente.class);

        final Actuador actuador = new Actuador(dispositivoInteligente);

        return actuador;
    }
}
