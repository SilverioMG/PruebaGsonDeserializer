package net.atopecode.pruebagsondeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ModelCollection {

    //@JsonAdapter(ModelSerializer.class)
    private List<ModelBase> models = new ArrayList<ModelBase>();

    public ModelCollection(){

    }

    public void add(ModelBase model){
        models.add(model);
    }

    public JsonObject toJson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ModelBase.class, new ModelSerializer())
                .serializeNulls()
                .create();
        return gson.toJsonTree(this).getAsJsonObject();
    }

    public static ModelCollection fromJson(JsonObject json){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ModelBase.class, new ModelDeserializer())
                .serializeNulls()
                .create();
        ModelCollection result = gson.fromJson(json, ModelCollection.class);
        return result;
    }
}
