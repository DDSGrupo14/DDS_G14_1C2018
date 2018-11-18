package json.Deserializers;

import com.google.gson.*;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;
import modelos.usuarios.Domicilio;
import modelos.dispositivos.Categoria;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DomicilioDeserializer implements JsonDeserializer<Domicilio> {
    @Override
    public Domicilio deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String direccion = jsonObject.get("direccion").getAsString();
        final Boolean principal = jsonObject.get("principal").getAsBoolean();
        final LocalDateTime fechaAltaEnSistema = LocalDateTime.parse(jsonObject.get("fechaAltaEnSistema").getAsString());

        Categoria categoria = context.deserialize( jsonObject.get("categoria"),Categoria.class);

        DispositivoInteligente[] dispositivosInteligentes =
                context.deserialize( jsonObject.get("dispositivosInteligentes"),DispositivoInteligente[].class);

        DispositivoEstandar[] dispositivosEstandar =
                context.deserialize( jsonObject.get("dispositivosEstandar"),DispositivoEstandar[].class);

        Actuador[] actuadores = context.deserialize( jsonObject.get("actuadores"),Actuador[].class);

        Sensor[] sensores = context.deserialize( jsonObject.get("sensores"),Sensor[].class);

        final Domicilio domicilio = new Domicilio(direccion,principal,fechaAltaEnSistema);

        domicilio.setCategoria(categoria);

        List<DispositivoInteligente> listaInteligentes = Arrays.asList(dispositivosInteligentes);

        domicilio.setDispositivosInteligentes(listaInteligentes);

        List<DispositivoEstandar> listaEstandar = Arrays.asList(dispositivosEstandar);

        domicilio.setDispositivosEstandar(listaEstandar);

        List<Actuador> listaActuador = Arrays.asList(actuadores);

        domicilio.setActuadores(listaActuador);

        List<Sensor> listaSensor = Arrays.asList(sensores);

        domicilio.setSensores(listaSensor);

        return domicilio;
    }
}
