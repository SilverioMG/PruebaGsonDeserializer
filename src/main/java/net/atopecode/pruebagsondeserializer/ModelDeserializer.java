package net.atopecode.pruebagsondeserializer;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ModelDeserializer implements JsonDeserializer<ModelBase> {

    public ModelBase  deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException{
        JsonObject jsonObject = json.getAsJsonObject();

        Gson gson = new Gson();
        if(jsonObject.has("campo1")){
            return gson.fromJson(jsonObject, Model1.class);
        }
        else{
            return gson.fromJson(jsonObject, ModelBase.class);
        }
    }
}
