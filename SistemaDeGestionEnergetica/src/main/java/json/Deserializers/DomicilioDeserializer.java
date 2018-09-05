package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;
import modelos.usuarios.Domicilio;
import modelos.dispositivos.Categoria;

import java.lang.reflect.Type;

public class DomicilioDeserializer implements JsonDeserializer<Domicilio> {
    @Override
    public Domicilio deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String direccion = jsonObject.get("direccion").getAsString();
        final Boolean principal = jsonObject.get("principal").getAsBoolean();
        final String fechaAltaEnSistema = jsonObject.get("fechaAltaEnSistema").getAsString();

        Categoria categoria = context.deserialize( jsonObject.get("categoria"),Categoria.class);

        DispositivoInteligente[] dispositivosInteligentes =
                context.deserialize( jsonObject.get("dispositivosInteligentes"),DispositivoInteligente[].class);

        DispositivoEstandar[] dispositivosEstandar =
                context.deserialize( jsonObject.get("dispositivosEstandar"),DispositivoEstandar[].class);

        Actuador[] actuadores = context.deserialize( jsonObject.get("actuadores"),Actuador[].class);

 //       Sensor[] sensores = context.deserialize( jsonObject.get("sensores"),Sensor[].class);

        final Domicilio domicilio = new Domicilio(direccion,principal,categoria,fechaAltaEnSistema);

        if( actuadores!=null)
            for ( Actuador actuador:actuadores
                 ) {
                domicilio.agregarActuador(actuador);
            }
/*
        for ( Sensor sensor:sensores
             ) {
            domicilio.agregarSensor(sensor);
        }
*/
        for ( DispositivoEstandar dispE: dispositivosEstandar
             ) {
            domicilio.agregarDispositivoEstandar(dispE);
        }

        for ( DispositivoInteligente dispI:dispositivosInteligentes
             ) {
            domicilio.agregarDispositivoInteligente(dispI);
        }

        return domicilio;
    }
}
