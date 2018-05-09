package main.java.Json;

import static main.java.Json.JsonUtils.toJson;

public abstract class BeanToJson <T> {

    public abstract T getObj();

    @Override
    public String toString() {
        return toJson(getObj());
    }

}
