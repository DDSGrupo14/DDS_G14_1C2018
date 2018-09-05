package json.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import modelos.reglas.sensores.Sensor;

import java.lang.reflect.Type;

public class SensorDeserializer implements JsonDeserializer<Sensor> {
    @Override
    public Sensor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
