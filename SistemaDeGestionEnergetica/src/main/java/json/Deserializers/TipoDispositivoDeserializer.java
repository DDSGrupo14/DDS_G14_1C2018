package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.TipoDispositivo;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class TipoDispositivoDeserializer implements JsonDeserializer<TipoDispositivo> {

    @Override
    public TipoDispositivo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String equipoConcreto = jsonObject.get("equipoConcreto").getAsString();

        final int consumoMinimo = jsonObject.get("consumoMensualMinimo").getAsInt();

        final int consumoMaximo = jsonObject.get("consumoMensualMaximo").getAsInt();

        final BigDecimal consumoEstimadoKWh = jsonObject.get("consumoEstimadoKWh").getAsBigDecimal();

        final boolean esInteligente = jsonObject.get("esInteligente").getAsBoolean();

        final boolean esBajoConsumo = jsonObject.get("esBajoConsumo").getAsBoolean();

        final TipoDispositivo tipo = new TipoDispositivo(equipoConcreto,consumoMinimo,consumoMaximo
                ,consumoEstimadoKWh, esInteligente, esBajoConsumo);

        return tipo;
    }
}
