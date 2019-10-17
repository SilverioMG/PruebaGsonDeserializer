package net.atopecode.pruebagsondeserializer;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ModelSerializer implements JsonSerializer<ModelBase> {
    public JsonElement serialize(ModelBase src, Type typeOfSrc, JsonSerializationContext context){
        JsonObject result = new JsonObject();

        Gson gson = new Gson();
        if(src instanceof Model1){
            Model1 model1 = (Model1) src;
            result = gson.toJsonTree(model1).getAsJsonObject();
        }
        else{
            result = gson.toJsonTree(src).getAsJsonObject();
        }

        return result;
    }
}
