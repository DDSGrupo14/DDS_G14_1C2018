package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.DispositivoInteligente;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.dispositivos.adaptadores.AdaptadorEstandar;

import java.lang.reflect.Type;

public class DispositivoInteligenteDeserializer implements JsonDeserializer<DispositivoInteligente> {

    @Override
    public DispositivoInteligente deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final Double porcentajeAhorroEnergia = jsonObject.get("porcentajeAhorroEnergia").getAsDouble();

        final DispositivoInteligente dispositivoInteligente = new DispositivoInteligente(porcentajeAhorroEnergia);

/*        final AdaptadorEstandar adaptador = context.deserialize( jsonObject.get("adaptador"), AdaptadorEstandar.class);

        if (adaptador != null) {
            dispositivoInteligente.setAdaptador(adaptador);
        }
*/
        return dispositivoInteligente;
    }

}
